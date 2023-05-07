package coordinate.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("직사각형 생성")
    void createRectangleTest() {
        assertThat(rectangle).isEqualTo(new Rectangle(points));
    }

    @Test
    @DisplayName("직사각형생성 오류")
    void createRectangleErrorTest() {
        List<Point> illegalPoints = Arrays.asList(new Point(1, 1), new Point(1, 3)
                , new Point(3, 1), new Point(3, 5));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(illegalPoints);
        });
    }

    @Test
    @DisplayName("직사각형넓이계산")
    void calculateRectangleTest() {
        assertThat(rectangle.area()).isEqualTo(28);
    }

    @AfterEach
    @DisplayName("사각형 초기화")
    void resetRectangle() {
        points = null;
        rectangle = null;
    }
}
