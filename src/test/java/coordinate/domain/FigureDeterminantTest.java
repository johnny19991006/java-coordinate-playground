package coordinate.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureDeterminantTest {
    private List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void null입력에대한예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            FigureDeterminant.create(null);
        });
    }

    @Test
    void point1개입력에대한예외처리() {
        points.add(new Point(1, 2));
        assertThrows(IllegalArgumentException.class, () -> {
            FigureDeterminant.create(points);
        });
    }

    @Test
    void point5개이상입력에대한예외처리() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 5));
        points.add(new Point(5, 6));
        points.add(new Point(7, 9));
        points.add(new Point(11, 13));
        assertThrows(IllegalArgumentException.class, () -> {
            FigureDeterminant.create(points);
        });
    }

    @Test
    void point가2개일경우_Line생성() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        assertThat(FigureDeterminant.create(points)).isEqualTo(new Line(points));
    }

    @Test
    void point가3개일경우_Triangle생성() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(4, 7));
        assertThat(FigureDeterminant.create(points)).isEqualTo(new Triangle(points));
    }

    @Test
    void point가4개일경우_Rectangle생성() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(1, 4));
        points.add(new Point(3, 2));
        assertThat(FigureDeterminant.create(points)).isEqualTo(new Rectangle(points));
    }

    @AfterEach
    void point초기화() {
        points = null;
    }
}
