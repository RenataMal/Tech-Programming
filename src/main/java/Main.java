import java.io.*;
import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        final String filePath = "numbers.txt";

        try (BufferedReader buffile = new BufferedReader(new FileReader(filePath))) { // Открываем файл для чтения
            String line = buffile.readLine(); // Читаем первую строку из файла
            if (line != null) { // Если файл не пустой
                String[] numbersStr = line.split(" "); // Разбиваем строку на массив строк по пробелам
                int[] numbers = new int[numbersStr.length]; // Создаем массив для хранения чисел
                for (int i = 0; i < numbersStr.length; i++) { // Преобразуем строки в числа и сохраняем их в массив
                    numbers[i] = Integer.parseInt(numbersStr[i]);
                }
                // Выводим результаты на экран
                System.out.println("Минимальное число: " + min(numbers));
                System.out.println("Максимальное число: " + max(numbers));
                System.out.println("Сумма всех чисел: " + sum(numbers));
                System.out.println("Произведение всех чисел: " + mult(numbers));
            } else {
                System.out.println("Файл пуст."); // Выводим сообщение, если файл пустой
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath); // Выводим сообщение об ошибке, если файл не найден
        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage()); // Выводим сообщение об ошибке ввода/вывода
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат числа в файле: " + e.getMessage()); // Выводим сообщение об ошибке преобразования строки в число
        }

        // Запуск тестов на производительность
        min_speed();
        max_speed();
        sum_speed();
        mult_speed();
    }

    // Метод для нахождения минимального числа в массиве
    public static int min(int[] numbers) {
        int minn = numbers[0];
        for (int n : numbers) { // Проходим по всем числам в массиве
            if (minn > n) { // Если текущее число меньше минимального, обновляем минимальное число
                minn = n;
            }
        }
        return minn; // Возвращаем минимальное число
    }

    // Метод для нахождения максимального числа в массиве
    public static int max(int[] numbers) {
        int maxx = numbers[0];
        for (int n : numbers) { // Проходим по всем числам в массиве
            if (maxx < n) { // Если текущее число больше максимального, обновляем максимальное число
                maxx = n;
            }
        }
        return maxx; // Возвращаем максимальное число
    }

    // Метод для вычисления суммы всех чисел в массиве
    public static int sum(int[] numbers) throws ArithmeticException {
        int summ = 0;
        for (int n : numbers) { // Проходим по всем числам в массиве
            try {
                summ = Math.addExact(summ, n); // Суммируем числа, обрабатывая возможное переполнение
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Возникло переполнение при вычислении суммы: " + e.getMessage()); // Если произошло переполнение, выбрасываем исключение
            }
        }
        return summ; // Возвращаем сумму всех чисел
    }

    // Метод для вычисления произведения всех чисел в массиве
    public static long mult(int[] numbers) {
        long result = 1;
        for (int n : numbers) { // Проходим по всем числам в массиве
            try {
                result *= n; // Умножаем числа друг на друга
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Возникло переполнение при вычислении произведения: " + e.getMessage()); // Если произошло переполнение, выбрасываем исключение
            }
        }
        return result; // Возвращаем произведение всех чисел
    }

    // Тесты для проверки производительности
    public static void min_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100));
            long start = System.nanoTime();
            min(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения поиска минимума в наносекундах: " + all_time);
        }
    }

    public static void max_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100));
            long start = System.nanoTime();
            max(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения поиска максимума в наносекундах: " + all_time);
        }
    }

    public static void sum_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100));
            long start = System.nanoTime();
            sum(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения вычисления суммы всех чисел в наносекундах: " + all_time);
        }
    }

    public static void mult_speed() {
        int[] size_of_array = {10, 100, 1000, 10000, 100000, 1000000};
        for (int size : size_of_array) {
            Random r = new Random();
            int[] numbers = new int[size];
            Arrays.setAll(numbers, i -> r.nextInt(100));
            long start = System.nanoTime();
            mult(numbers);
            long end = System.nanoTime();
            long all_time = end - start;
            System.out.println("Количество чисел в файле: " + size + ". Время выполнения нахождения произведения всех чисел в наносекундах: " + all_time);
        }
    }

}
