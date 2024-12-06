import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class EncryptedDecrypted {

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {
        CaesarCipher cipher = new CaesarCipher();

        Scanner scanner = new Scanner(System.in);
        System.out.println(flag ? "Введите файл для его зашифровки: " : "Введите файл для его расшифровки: ");
        String src = scanner.nextLine();


        System.out.println("Введите ключ: ");
        int key = Integer.parseInt(scanner.nextLine());

        Path dst = ConsoleHelper.buildFileName(src, (flag ? "_encrypt" : "_decrypt"));

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            while (reader.ready()) {
                String strLine = reader.readLine();
                String result = flag ? cipher.encrypt(strLine, key) : cipher.decrypt(strLine, key);

                writer.write(result);
                writer.newLine();
            }
        }

        ConsoleHelper.printMessage(flag ? "Содержимое файла зашифровано: " : "Содержимое файла расшифровано: ");
    }
}
