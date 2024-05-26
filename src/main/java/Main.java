import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        try (BufferedReader buffile = new BufferedReader(new FileReader(filePath))) {
            String line = buffile.readLine();
            if (line != null) {
                String[] numbersStr = line.split(" ");
                int[] numbers = new int[numbersStr.length];
                for (int i = 0; i < numbersStr.length; i++) {
                    numbers[i] = Integer.parseInt(numbersStr[i]);
                }
                System.out.println("Минимальное число: " + min(numbers));
                System.out.println("Максимальное число: " + max(numbers));
                System.out.println("Сумма всех чисел: " + sum(numbers));
                System.out.println("Произведение всех чисел: " + mult(numbers));
            } else {
                System.out.println("Файл пуст.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат числа в файле: " + e.getMessage());
        }
    }

    public static int min(int[] numbers) {
        int minn = numbers[0];
        for (int n : numbers) {
            if (minn > n) {
                minn = n;
            }
        }
        return minn;
    }

    public static int max(int[] numbers) {
        int maxx = numbers[0];
        for (int n : numbers) {
            if (maxx < n) {
                maxx = n;
            }
        }
        return maxx;
    }

    public static int sum(int[] numbers) throws ArithmeticException {
        int summ = 0;
        for (int n : numbers) {
            try {
                summ = Math.addExact(summ, n);
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Возникло переполнение при вычислении суммы: " + e.getMessage());
            }
        }
        return summ;
    }

    public static long mult(int[] numbers) {
        long result = 1;
        for (int n : numbers) {
            result *= n;
        }
        return result;
    }

}
