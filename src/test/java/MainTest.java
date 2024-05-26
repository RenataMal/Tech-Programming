import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Random;

class MainTest {

    // Тестирование метода Main.min()
    @Test
    void min() {
        int[] numbers = {3, 46436, 546, 23, 6}; // Задаем тестовые числа

        int answer = Main.min(numbers); // Получаем результат

        assertEquals(3, answer, "Не работает."); // Проверяем, что результат соответствует ожидаемому значению
    }

    // Тестирование метода Main.max()
    @Test
    void max() {
        int[] numbers = {43, 5, 564, 3454, 6454, 322, 536}; // Задаем тестовые числа

        int answer = Main.max(numbers); // Получаем результат

        assertEquals(6454, answer, "Не работает."); // Проверяем, что результат соответствует ожидаемому значению
    }

    // Тестирование метода Main.sum()
    @Test
    void sum() {
        int[] numbers = {1, 1, 454, 656, 34, 456, 889}; // Задаем тестовые числа

        int answer = Main.sum(numbers); // Получаем результат

        assertEquals(2491, answer, "Не работает."); // Проверяем, что результат соответствует ожидаемому значению
    }

    // Тестирование метода Main.mult()
    @Test
    void mult() {
        int[] numbers = {5, 3, 5, 7, 10, 657}; // Задаем тестовые числа

        long answer = Main.mult(numbers); // Получаем результат

        assertEquals(3449250, answer, "Не работает."); // Проверяем, что результат соответствует ожидаемому значению
    }

    // Тестирование скорости выполнения метода Main.min()
    @Test
    void min_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000}; // Размеры массивов для тестирования скорости выполнения
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100)); // Генерируем случайные числа
            long start = System.nanoTime(); // Запускаем таймер перед выполнением метода
            Main.min(numbers); // Вызываем метод для нахождения минимального числа
            long end = System.nanoTime(); // Завершаем таймер после выполнения метода
            long all_time = end - start; // Вычисляем время выполнения метода
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения поиска минимума в наносекундах: " + all_time);
        }
    }

    // Тестирование скорости выполнения метода Main.max()
    @Test
    void max_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000}; // Размеры массивов для тестирования скорости выполнения
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100)); // Генерируем случайные числа
            long start = System.nanoTime(); // Запускаем таймер перед выполнением метода
            Main.max(numbers); // Вызываем метод для нахождения максимального числа
            long end = System.nanoTime(); // Завершаем таймер после выполнения метода
            long all_time = end - start; // Вычисляем время выполнения метода
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения поиска максимума в наносекундах: " + all_time);
        }
    }

    // Тестирование скорости выполнения метода Main.sum()
    @Test
    void sum_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000}; // Размеры массивов для тестирования скорости выполнения
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100)); // Генерируем случайные числа
            long start = System.nanoTime(); // Запускаем таймер перед выполнением метода
            Main.sum(numbers); // Вызываем метод для вычисления суммы всех чисел
            long end = System.nanoTime(); // Завершаем таймер после выполнения метода
            long all_time = end - start; // Вычисляем время выполнения метода
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения вычисления суммы всех чисел в наносекундах: " + all_time);
        }
    }

    // Тестирование скорости выполнения метода Main.mult()
    @Test
    void mult_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000}; // Размеры массивов для тестирования скорости выполнения
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100)); // Генерируем случайные числа
            long start = System.nanoTime(); // Запускаем таймер перед выполнением метода
            Main.mult(numbers); // Вызываем метод для вычисления произведения всех чисел
            long end = System.nanoTime(); // Завершаем таймер после выполнения метода
            long all_time = end - start; // Вычисляем время выполнения метода
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения нахождения произведения всех чисел в наносекундах: " + all_time);
        }
    }

}
