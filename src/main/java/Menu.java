import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    Выберите действия, введя его номер:\s
                    1. Зашифровать текст:\s
                    2. Расшифровать текст:\s
                    3. Подобрать ключ с помощью brute force:\s
                    4. Расшифровать текст с помощью статистического анализа:\s
                    5. Выход из программы:\s
                    """);

            String answer = ConsoleHelper.readString();

            switch (answer) {
                case "1" -> new EncryptedDecrypted().encryptedDecrypted(true);
                case "2" -> new EncryptedDecrypted().encryptedDecrypted(false);
                case "3" -> new BruteForce().bruteForce();
                case "4" -> new Parsing().parse();
                case "5" -> {
                    return;
                }
            }
        }
    }
}