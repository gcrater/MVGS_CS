package projects;

import java.util.Scanner;

public class Prompt {
    private static Scanner scan = new Scanner(System.in);

    /**
     * Asks a question and returns the response.
     * 
     * @param question
     * @return String
     */
    public static String ask(String question) {
        System.out.print(question);
        System.out.println();
        return scan.nextLine();
    }

    /**
     * Asks a question and returns a boolean (true if yes).
     * 
     * @param question
     * @return boolean
     */
    public static boolean askYesNo(String question) {
        String answer = ask(question);
        return answer.equalsIgnoreCase("yes");
    }
}
