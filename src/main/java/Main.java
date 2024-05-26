import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:"); // Предлагаем пользователю ввести путь к файлу
        String filePath = scanner.nextLine(); // Читаем путь к файлу из консоли

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
            result *= n; // Умножаем числа друг на друга
        }
        return result; // Возвращаем произведение всех чисел
    }

}
