import java.util.Scanner;

public class People {
    public static int getNumberOfGuests() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?(Введите число)");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number < 1) {
                    System.out.println("Вы ввели некорректное значение");
                    continue;
                } else if (number == 1) {
                    System.out.println("Не имеет смысла делить на 1");
                    continue;
                }
                return number;
            } else {
                System.out.println("Введите цифру!");
                scanner.next();
            }

        }
    }
}
