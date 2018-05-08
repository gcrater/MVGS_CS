package hw_classwork;

import java.util.Scanner;

/**
 * Encrypt and decrypt a message with shift given by user.
 * 
 * @author Gracie Crater @ date 4/12/2018
 *
 */
public class Encryption {
    public static Scanner scan = new Scanner(System.in);
    public static final String PHRASE = "THis is TEst # 99! Why can't you get it right?";

    public static void main(String[] args) {
        System.out.print("Welcome to the Encryptor!");

        String yesNo = "yes";

        while (yesNo.contains("y")) {

            System.out.print("\nPlease enter a message: ");
            String message = scan.nextLine();
            System.out.println();
            System.out.print("Now, enter a whole number (0-26): ");
            int shift = scan.nextInt() % 26;

            System.out.println();

            String encrypted = encrypt(message, shift);
            printEncryption(message, encrypted, shift);
            System.out.println();
            System.out.print("Would you like to encrypt another message? [yes/no]");
            yesNo = scan.next();

            // System.out.println(yesNo);

            if (yesNo.contains("n")) {
                System.out.println("\nUser has requested to exit.");
                return;
            }

            scan.nextLine();

        }

    }

    /**
     * 
     * @param message
     * @param shift
     * @return encryptedMessage
     */
    private static String encrypt(String message, int shift) {
        String encryptedMessage = "";
        char current;

        for (int i = 0; i < message.length(); i++) {
            current = message.charAt(i); // the current character being processed
            if (current != ' ') {
                current += shift;
                char shiftedChar = (char) current; // cast ascii value back to a char
                encryptedMessage += shiftedChar; // build new message with all new shifted chars
            }
            if (current == ' ') {
                encryptedMessage += " ";
            }
        }
        return encryptedMessage;
    }

    /**
     *
     * @param message
     * @param encryptedMessage
     * @param shift
     */

    private static void printEncryption(String message, String encryptedMessage, int shift) {

        System.out.print("Message to be encrypted: " + message + "\n");
        System.out.println();
        System.out.print("Encrypted message: " + encryptedMessage);
        System.out.println();
        System.out.print("Shift applied: " + shift);
        System.out.println();
    }

}
