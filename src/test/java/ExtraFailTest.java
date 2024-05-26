import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class ExtraFailTest {
    @Test
    void extra_test_timeout_min() {
        int[] numbers = {323, 23, 4, 435, 435, 43663, 21134, 78970, 13654768, 42545};

        Assertions.assertTimeout(Duration.ofMillis(1), () -> {
            Main.min(numbers);
        });
    }
}
