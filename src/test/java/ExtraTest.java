import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class ExtraTest {
    @Test
    void extra_test_timeout_min() {
        // Создаем массив чисел для тестирования
        int[] numbers = {323, 23, 4, 435, 435, 43663, 21134, 78970, 13654768, 42545};

        // Проверяем, что метод Main.min() выполняется за указанное время
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            Main.min(numbers); // Вызываем метод для нахождения минимального числа
        });
    }
}
