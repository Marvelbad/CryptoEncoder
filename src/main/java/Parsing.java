import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Parsing {

    @SneakyThrows
    public void parse() {
        ConsoleHelper.printMessage("Введите путь к файлу для расшифровки: ");
        String src = ConsoleHelper.readString();


        ConsoleHelper.printMessage("Введите адрес к файлу для набора статистики: ");
        String stat = ConsoleHelper.readString();

        Path dst = ConsoleHelper.buildFileName(src, "_parsing");

        Map<Character, Integer> mapSrc = fillMapWithValues(src);
        Map<Character, Integer> mapStat = fillMapWithValues(stat);

        List<Map.Entry<Character, Integer>> listSrc = mapToList(mapSrc);
        List<Map.Entry<Character, Integer>> listStat = mapToList(mapStat);

        Map<Character, Character> decryptedMap = new HashMap<>();
        for (int i = 0; i < listSrc.size(); i++) {
            decryptedMap.put(listSrc.get(i).getKey(), listStat.get(i).getKey());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = Files.newBufferedWriter((dst))) {

            while (reader.ready()) {
                StringBuilder builder = new StringBuilder();
                String someText = reader.readLine();
                char[] chars = someText.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    Character decryptedChar = decryptedMap.get(aChar);
                    builder.append(decryptedChar);
                }
                writer.write(builder.toString());
            }
        }
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


    private List<Map.Entry<Character, Integer>> mapToList(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);

        Comparator<Map.Entry<Character, Integer>> comparator = Map.Entry.comparingByValue();

        list.sort(comparator.reversed());
        return list;
//        return map.entrySet().stream().sorted(Map.Entry.<Character,Integer>comparingByValue().reversed()).toList();
    }

}
