package coordinate.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    private List<Point> points;
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        points = Arrays.asList(new Point(1, 1), new Point(2, 10), new Point(7, 5));
        triangle = new Triangle(points);
    }

    @Test
    @DisplayName("삼각형 생성")
    void createTriangleTest() {
        assertThat(triangle).isEqualTo(new Triangle(points));
    }

    @Test
    @DisplayName("삼각형 생성오류")
    void createTriangleErrorTest() {
        List<Point> illegalPoints = Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(illegalPoints);
        });
    }

    @Test
    @DisplayName("삼각형 넓이계산")
    void calculateTriangleTest() {
        assertThat(triangle.area()).isEqualTo(25.000, offset(0.00099));
    }

    @AfterEach
    @DisplayName("삼각형 초기화")
    void resetTriangle() {
        points = null;
        triangle = null;
    }
}
