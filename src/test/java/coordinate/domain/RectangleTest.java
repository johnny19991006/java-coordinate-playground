package coordinate.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    private List<Point> points;
    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        points = Arrays.asList(new Point(1, 1), new Point(1, 15)
                , new Point(3, 1), new Point(3, 15));
        rectangle = new Rectangle(points);
    }

    @Test
    void 직사각형생성() {
        assertThat(rectangle).isEqualTo(new Rectangle(points));
    }

    @Test
    void 직사각형생성오류() {
        List<Point> illegalPoints = Arrays.asList(new Point(1, 1), new Point(1, 3)
                , new Point(3, 1), new Point(3, 5));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(illegalPoints);
        });
    }

    @Test
    void 직사각형넓이계산() {
        assertThat(rectangle.area()).isEqualTo(28);
    }

    @AfterEach
    void 직사각형초기화() {
        points = null;
        rectangle = null;
    }
}
