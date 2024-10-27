import java.util.Scanner;

public class CesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void validateMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty.");
        }
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new IllegalArgumentException("Invalid character found: '" + c + "'. Message must contain only letters!");
            }
        }
    }

    public static String encrypt(String message, int shift) {

        StringBuilder result = new StringBuilder();

        for (char letter : message.toCharArray()) {
            int position = ALPHABET.indexOf(letter);

            if (position != -1) {
                int newPosition = (position + shift) % 26;
                if (newPosition < 0) {
                    newPosition += 26;
                }
                result.append(ALPHABET.charAt(newPosition));
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, -shift);
    }
}
