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
                int[] numbers = new int[numbersStr.length];
                for (int i = 0; i < numbersStr.length; i++) {
                    numbers[i] = Int.parseInt(numbersStr[i]);
                }
                System.out.println("Минимальное число: " + min(numbers));
                System.out.println("Максимальное число: " + max(numbers));
                System.out.println("Сумма всех чисел: " + sum(numbers));
                System.out.println("Произведение всех чисел: " + mult(numbers));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
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

    public static int sum(int[] numbers) {
        int summ = 0;
        for (int n : numbers) {
            try {
                summ = Math.addExact(summ, n);
            } catch (ArithmeticException e) {
                System.out.println("Возникло переполнение при вычислении суммы: " + e);
            }
        }
        return summ;
    }

    public static int mult(int[] numbers) {
        long m = 1;
        for (int n : numbers) {
            try {
                m = Math.multiplyExact(m, n);
            } catch (ArithmeticException e) {
                System.out.println("Возникло переполнение при вычислении произведения: " + e);
            }
        }
        return m;
    }
}
