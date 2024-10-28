import java.util.Scanner;

public class CesarCipher {
    private static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void validateMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new IllegalArgumentException("Oops! Found invalid character: '" + c + "'. Please use only letters (A-Z, a-z) and spaces.");
            }
        }
    }

    public String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();

        for (char letter : message.toCharArray()) {
            if (Character.isLowerCase(letter)) {
                int position = LOWERCASE_ALPHABET.indexOf(letter);
                if (position != -1) {
                    int newPosition = (position + shift) % 26;
                    if (newPosition < 0) {
                        newPosition += 26;
                    }
                    result.append(LOWERCASE_ALPHABET.charAt(newPosition));
                }
            } else if (Character.isUpperCase(letter)) {
                int position = UPPERCASE_ALPHABET.indexOf(letter);
                if (position != -1) {
                    int newPosition = (position + shift) % 26;
                    if (newPosition < 0) {
                        newPosition += 26;
                    }
                    result.append(UPPERCASE_ALPHABET.charAt(newPosition));
                }
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

    public String decrypt(String message, int shift) {
        return encrypt(message, -shift);
    }
}