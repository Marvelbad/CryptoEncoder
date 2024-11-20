import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Parsing {
    private static final String SPECIAL_CHARS = " ,.!?-";

    @SneakyThrows
    public void parse() {
        ConsoleHelper.writeMessage("Введите путь к файлу для расшифровки: ");
        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите адрес к файлу для набора статистики: ");
        String stat = ConsoleHelper.readString();

        Map<Character, Integer> mapSrc = analyzeFile(src);
        Map<Character, Integer> mapStat = analyzeFile(stat);
    }

    @SneakyThrows
    private Map<Character, Integer> analyzeFile(String filePath) {
        Map<Character, Integer> charMap = new HashMap<>();
        try (BufferedReader buf = new BufferedReader(new FileReader(filePath))) {
            while (buf.ready()) {
                String text = buf.readLine();
                for (char symbol : text.toCharArray()) {
                    if (Character.isLetterOrDigit(symbol) || SPECIAL_CHARS.contains(String.valueOf(symbol))) {

                        if (!charMap.containsKey(symbol)) {
                            charMap.put(symbol, 1);
                        } else {
                            int value = charMap.get(symbol);
                            charMap.put(symbol, value + 1);
                        }
                    }
                }
            }
        }
        return charMap;
    }
}
