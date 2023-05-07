package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    @DisplayName("포인트생성")
    void 포인트생성() {
        Assertions.assertThat(new Point(1, 2)).isEqualTo(new Point(1, 2));
    }

    @Test
    @DisplayName("좌표의 범위를 넘어가는 값이 생성자에 입력되었을 경우")
    void exceedPointTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(0, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(3, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(25, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(1, 25);
        });
    }
}
