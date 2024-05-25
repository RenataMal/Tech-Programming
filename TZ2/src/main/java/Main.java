import java.io.*;
import java.util.Scanner;

//C:\Users\Рената Малеванная\IdeaProjects\TZ2\src\test.txt
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();
        try (FileReader file = new FileReader(filePath);
             BufferedReader buffile = new BufferedReader(file)) {
            String line = buffile.readLine();
            if (line != null) {
                String[] numbersStr = line.split(" ");
                long[] numbers = new long[numbersStr.length];
                for (int i = 0; i < numbersStr.length; i++) {
                    numbers[i] = Long.parseLong(numbersStr[i]);
                }
                System.out.println("Минимальное число: " + _min(numbers));
                System.out.println("Максимальное число: " + _max(numbers));
                System.out.println("Сумма всех чисел: " + _sum(numbers));
                System.out.println("Произведение всех чисел: " + _mult(numbers));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static long _min(long[] numbers) {
        long minn = numbers[0];
        for (long n : numbers) {
            if (minn > n) {
                minn = n;
            }
        }
        return minn;
    }

    public static long _max(long[] numbers) {
        long maxx = numbers[0];
        for (long n : numbers) {
            if (maxx < n) {
                maxx = n;
            }
        }
        return maxx;
    }

    public static long _sum(long[] numbers) {
        long summ = 0;
        for (long n : numbers) {
            try {
                summ = Math.addExact(summ, n);
            } catch (ArithmeticException e) {
                System.out.println("Возникло переполнение при вычислении суммы: " + e);
                System.exit(1);
            }
        }
        return summ;
    }

    public static long _mult(long[] numbers) {
        long m = 1;
        for (long n : numbers) {
            try {
                m = Math.multiplyExact(m, n);
            } catch (ArithmeticException e) {
                System.out.println("Возникло переполнение при вычислении произведения: " + e);
                System.exit(1);
            }
        }
        return m;
    }
}
