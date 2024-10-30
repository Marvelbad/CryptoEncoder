import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Encrypted {
    public static void encrypt() {
        CaesarCipher cipher = new CaesarCipher();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите файл для его зашифровки: ");
        String src = scanner.nextLine();


        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес, куда записать результат: ");
        String dst = scanner.nextLine();

        try (FileReader fileReader = new FileReader(src)) {
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
