package coordinate.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(new Point(1, 2), new Point(3, 4));
        line = new Line(points);
    }

    @Test
    @DisplayName("라인의 길이를 계산")
    void calculateLineTest() {
        assertThat(line.area()).isEqualTo(2.828, offset(0.00099));
    }

    @AfterEach
    @DisplayName("라인 초기화")
    void resetLine() {
        line = null;
    }
}
