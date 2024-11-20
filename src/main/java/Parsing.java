import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Parsing {

    @SneakyThrows
    public void pars() {
        ConsoleHelper.writeMessage("Enter file path to decrypt: ");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите адрес к файлу для набоора статистики: ");
        String stat = ConsoleHelper.readString();

        Map<Character, Integer> mapSrc = new HashMap<>();
        FileReader reader = new FileReader(src);
        BufferedReader buf = new BufferedReader(reader);
        while (buf.ready()) {
            String text = buf.readLine();
            char[] symbols = text.toCharArray();
            for (char sym : symbols) {
                if (!mapSrc.containsKey(sym)) {
                    mapSrc.put(sym, 1);
                } else {
                    int value = mapSrc.get(sym);
                    mapSrc.put(sym, value + 1);
                }
            }
        }
//сделать все то же самое с stat!!!!!
    }
}
