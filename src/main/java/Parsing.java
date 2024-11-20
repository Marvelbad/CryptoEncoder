import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Parsing {
    private static final String SPECIAL_CHARS = " ,.!?-";

    @SneakyThrows
    public void pars() {
        ConsoleHelper.writeMessage("Введите путь к файлу для расшифровки: ");
        String src = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите адрес к файлу для набора статистики: ");
        String stat = ConsoleHelper.readString();

        Map<Character, Integer> mapSrc = new HashMap<>();
        FileReader reader = new FileReader(src);
        BufferedReader buf = new BufferedReader(reader);
        while (buf.ready()) {
            String text = buf.readLine();
            for (char symbol : text.toCharArray()) {
                if (!mapSrc.containsKey(symbol)) {
                    mapSrc.put(symbol, 1);
                } else {
                    int value = mapSrc.get(symbol);
                    mapSrc.put(symbol, value + 1);
                }
            }
        }
    }
}
