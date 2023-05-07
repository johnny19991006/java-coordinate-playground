package coordinate.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("null 입력에 대한 예외처리")
    void nullExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            FigureDeterminant.create(null);
        });
    }

    @Test
    @DisplayName("point1개 입력에 대한 예외처리")
    void point1ExceptionTest() {
        points.add(new Point(1, 2));
        assertThrows(IllegalArgumentException.class, () -> {
            FigureDeterminant.create(points);
        });
    }

    @Test
    @DisplayName("point5개 이상 입력에 대한 예외처리")
    void point5ExceptionTest() {
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
    @DisplayName("point가2개일경우 Line생성")
    void point2ExceptionTest() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        assertThat(FigureDeterminant.create(points)).isEqualTo(new Line(points));
    }

    @Test
    @DisplayName("point가3개일경우 Triangle생성")
    void point3ExceptionTest() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(4, 7));
        assertThat(FigureDeterminant.create(points)).isEqualTo(new Triangle(points));
    }

    @Test
    @DisplayName("point가4개일경우 Rectangle생성")
    void point4ExceptionTest() {
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(1, 4));
        points.add(new Point(3, 2));
        assertThat(FigureDeterminant.create(points)).isEqualTo(new Rectangle(points));
    }

    @AfterEach
    @DisplayName("포인트 리셋")
    void resetPoint() {
        points = null;
    }
}
