import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;


class MainTest {

    @Test
    void min() {
        long[] numbers = {3, 46436, 546, 23, 6};

        long answer = Main.min(numbers);

        assertEquals(3, answer);
    }

    @Test
    void max() {
        long[] numbers = {43, 5, 564, 3454, 6454, 322, 536};

        long answer = Main.max(numbers);

        assertEquals(6454, answer);
    }

    @Test
    void sum() {
        long[] numbers = {1, 1, 454, 656, 34, 456, 889};

        long answer = Main.sum(numbers);

        assertEquals(2491, answer);
    }

    @Test
    void mult() {
        long[] numbers = {5, 3, 5, 7, 10, 657};

        long answer = Main.mult(numbers);

        assertEquals(3449250, answer);
    }

    @Test
    void min_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            long[] numbers = new long[size];
            Arrays.setAll(numbers, i -> (long) r.nextInt(100));
            long start = System.nanoTime();
            Main.min(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения поиска минимума в наносекундах: " + all_time);
        }
    }

    @Test
    void max_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            long[] numbers = new long[size];
            Arrays.setAll(numbers, i -> (long) r.nextInt(100));
            long start = System.nanoTime();
            Main.max(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения поиска максимума в наносекундах: " + all_time);
        }
    }

    @Test
    void sum_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            long[] numbers = new long[size];
            Arrays.setAll(numbers, i -> (long) r.nextInt(100));
            long start = System.nanoTime();
            Main.sum(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения вычисления суммы всех чисел в наносекундах: " + all_time);
        }
    }

    @Test
    void mult_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            long[] numbers = new long[size];
            Arrays.setAll(numbers, i ->(long) r.nextInt(100));
            long start = System.nanoTime();
            Main.mult(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения нахождения произведения всех чисел в наносекундах: " + all_time);
        }
    }

    @Test
    void extra_test_timeout_min() {
        long[] numbers = {323, 23, 4, 435, 435, 43663, 21134, 78970, 13654768, 42545};

        Assertions.assertTimeout(Duration.ofNanos(1401), () -> {
            Thread.sleep(1);
            Main.min(numbers);
        });
    }

}
