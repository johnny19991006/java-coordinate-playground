package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void 포인트생성() {
        Assertions.assertThat(new Point(1, 2)).isEqualTo(new Point(1, 2));
    }

    @Test
    void 좌표의범위를넘어가는값이생성자에입력되었을경우() {
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
