import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Files;

public class Parsing {

    @SneakyThrows
    public void parse() {
        ConsoleHelper.writeMessage("Введите путь к файлу для расшифровки: ");
        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите адрес к файлу для набора статистики: ");
        String stat = ConsoleHelper.readString();

        Map<Character, Integer> mapSrc = fillMapWithValues(src);
        Map<Character, Integer> mapStat = fillMapWithValues(stat);

        ConsoleHelper.writeMessage("Расшифрованный текст:");
    }

    @SneakyThrows
    private Map<Character, Integer> fillMapWithValues(String path) {
        Map<Character, Integer> map = new HashMap<>();
        try (BufferedReader buf = new BufferedReader(new FileReader(path))) {
            while (buf.ready()) {
                String text = buf.readLine();
                for (char symbol : text.toCharArray()) {
                    if (!map.containsKey(symbol)) {
                        map.put(symbol, 1);
                    } else {
                        int value = map.get(symbol);
                        map.put(symbol, value + 1);
                    }
                }
            }
        }
        return map;
    }


}
