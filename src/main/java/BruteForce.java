import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;

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

//Проблема переноса строки! Пофиксить!!!!!!!!! с 21 по 37 строки!!!!
        try (BufferedReader reader = new BufferedReader(new FileReader(src))) {
            StringBuilder fullText = new StringBuilder();
            while (reader.ready()) {
                String line = reader.readLine();
                fullText.append(line).append("\n");
            }
            String entireText = fullText.toString();
            for (int i = 0; i < caesarCipher.getAlphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(entireText, i);
                if (isValidate(decrypt)) {
                    //Files.writeString(dst, decrypt);
                    ConsoleHelper.printMessage("Успешная расшифровка с ключом: " + i);
                    return;
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
            if (answer.equalsIgnoreCase("no")) isValidate = false;
            ConsoleHelper.printMessage("Пожалуйста, введите только Yes или No!");
        }
        return false;
    }
}