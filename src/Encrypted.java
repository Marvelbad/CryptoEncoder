import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Encrypted {
    public void encrypt() {
        CaesarCipher cipher = new CaesarCipher();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите файл для его зашифровки: ");
        String src = scanner.nextLine();


        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес, куда записать результат: ");
        String dst = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {

            while (reader.ready()) {
                String strLine = reader.readLine();

                String encrypt = cipher.encrypt(strLine, key);

                writer.write(encrypt);
                writer.newLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Содержимое файла зашифровано.");
    }
}
