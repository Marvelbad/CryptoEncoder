import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CesarCipher cipher = new CesarCipher();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter message to encrypt: ");
            String message = scanner.nextLine();

            cipher.validateMessage(message);

            System.out.println("Enter shift value: ");
            int shiftValue = scanner.nextInt();
            scanner.nextLine();

            String encryptedMessage = cipher.encrypt(message, shiftValue);
            System.out.println("Encrypted message: " + encryptedMessage);

            String decryptedMessage = cipher.decrypt(encryptedMessage, shiftValue);
            System.out.println("Decrypted message: " + decryptedMessage);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number for shift value!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}