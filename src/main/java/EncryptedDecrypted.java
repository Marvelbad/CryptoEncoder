import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class EncryptedDecrypted {

    @SneakyThrows
    public void encryptedDecrypted(boolean flag) {
        CaesarCipher cipher = new CaesarCipher();

        System.out.println(flag ? "Введите файл для его зашифровки: " : "Введите файл для его расшифровки: ");
        String src = ConsoleHelper.readString();

        System.out.println("Введите ключ: ");
        int key = ConsoleHelper.readInt();

        Path dst = ConsoleHelper.buildFileName(src, (flag ? "_encrypt" : "_decrypt"));

        String content = Files.readString(Path.of(src));
        Files.writeString(dst, flag ? cipher.encrypt(content, key) : cipher.decrypt(content, key));

        ConsoleHelper.printMessage(flag ? "Содержимое файла зашифровано: " : "Содержимое файла расшифровано: ");
    }
}
