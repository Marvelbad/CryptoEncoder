import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {
    private static final int MAX_WORD_LENGTH = 28;
    private static final String WORD_SEPARATOR_REGEX = "\\s";

    @SneakyThrows
    public void bruteForce() {
        ConsoleHelper.writeMessage("Enter file path: ");
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_bruteForce");

        CaesarCipher caesarCipher = new CaesarCipher();


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
                    ConsoleHelper.writeMessage("Успешная расшифровка с ключом: " + i);
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
        return true;
    }
}