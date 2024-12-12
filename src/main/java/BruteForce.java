import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class BruteForce {
    private static final int MAX_WORD_LENGTH = 28;
    private static final String WORD_SEPARATOR_REGEX = "\\s";
    private static final int SIZE_TEXT = 80;

    @SneakyThrows
    public void bruteForce() {
        ConsoleHelper.printMessage("Enter file path: ");
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_bruteForce");

        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            ArrayList<String> encryptedList = new ArrayList<>();
            StringBuilder fullText = new StringBuilder();
            while (reader.ready()) {
                String line = reader.readLine();
                encryptedList.add(line);
                fullText.append(line).append(System.lineSeparator());
            }


            for (int i = 0; i < caesarCipher.getAlphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(fullText.toString(), i);

                if (isValidate(decrypt)) {
                    for (String str : encryptedList) {
                        String strEncrypt = caesarCipher.decrypt(str, i);
                        writer.write(strEncrypt);
                        writer.newLine();
                    }

                    ConsoleHelper.printMessage("Успешная расшифровка с ключом: " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidate(String text) {
        String[] words = text.split(WORD_SEPARATOR_REGEX);
        for (String word : words) {
            if (word.length() > MAX_WORD_LENGTH) {
                return false;
            }
        }

        boolean isValidate = false;

        if (text.matches(".*[.!?,]+ .*")) {
            isValidate = true;
        }

        while (isValidate) {
            ConsoleHelper.printMessage("Фрагмент расшифрованного текста:");
            ConsoleHelper.printMessage(text.length() > SIZE_TEXT ? text.substring(0, 80) + "..." : text);  // refactor SIZE_TEXT name!

            ConsoleHelper.printMessage("Текст выглядит правильно? (Yes/No):");
            String answer = ConsoleHelper.readString().trim();

            if (answer.equalsIgnoreCase("yes")) return true;
            else if (answer.equalsIgnoreCase("no")) isValidate = false;
            else ConsoleHelper.printMessage("Пожалуйста, введите только Yes или No!");
        }
        return false;
    }
}