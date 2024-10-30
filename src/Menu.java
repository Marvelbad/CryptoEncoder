import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Выберите действия, введя его номер:\s
                    3. Подобрать ключ с помощью brute force:\s
                    4. Расшифровать текст с помощью статистического анализа:\s
                    1. Зашифровать текст:\s
                    2. Расшифровать текст:\s
                    5. Выход из программы:\s
                    """);

            String answer = scanner.nextLine();

            switch (answer) {
                case "1" -> System.out.printf("1. Зашифровать текст: ");
                case "2" -> System.out.printf("2. Расшифровать текст: ");
                case "3" -> System.out.printf("3. Расшифровать текст: ");
                case "4" -> System.out.printf("4. Расшифровать текст: ");
                case "5" -> {
                    return;
                }
            }
        }


    }


}