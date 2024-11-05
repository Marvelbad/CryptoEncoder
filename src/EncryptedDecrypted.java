import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {
    public void encryptedDecrypted(boolean flag) {
        CaesarCipher cipher = new CaesarCipher();

        Scanner scanner = new Scanner(System.in);
        if (flag) {
            System.out.println("Введите файл для его зашифровки: ");
        } else {
            System.out.println("Введите файл для его расшифровки: ");
        }
        String src = scanner.nextLine();


        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес, куда записать результат: ");
        String dst = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {

            while (reader.ready()) {
                String strLine = reader.readLine();
                String result = null;
                if (flag) {
                    result = cipher.encrypt(strLine, key);
                } else {
                   result = cipher.decrypt(strLine, key);
                }


                writer.write(result);
                writer.newLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Содержимое файла зашифровано.");
    }
}
