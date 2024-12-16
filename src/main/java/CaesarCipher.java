public class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    /**
     * Метод шифроания Цезаря где используются строка и ключ
     * @param message - текст для зашифровки
     * @param key - число на которое нужно сделать сдвиг по ALPHABET
     * @return - результирующее значение в виде строк
     */
    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char letter : message.toCharArray()) {
            int position = ALPHABET.indexOf(letter);
            if (position >= 0) {
                int newPosition = (position + key) % ALPHABET.length();
                result.append(ALPHABET.charAt(newPosition + (newPosition < 0 ? ALPHABET.length() : 0)));
            }
        }
        return result.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }

    public int getAlphabetLength() {
        return ALPHABET.length();
    }
}