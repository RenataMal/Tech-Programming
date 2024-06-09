import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
