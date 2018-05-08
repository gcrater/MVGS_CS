package projects;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Allows user to create and name a file -- if the name is valid and unique in
 * the directory.
 * 
 * @author Gracie Crater
 * @version 2/8/2018
 */
public class ProjectPotatoPhase2 {

    static Scanner scan = new Scanner(System.in);
    static File file;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to The Poem Creator!");

        boolean createPoem = askYesNo("Would you like to create a poem? [yes/no]  ");
        if (!createPoem) {
            System.out.println("Goodbye!!");
            return;
        }

        while (true) {

            boolean valid = createFile();

            // if file name contains invalid characters, create another file
            if (!valid) {
                System.out.println("File name contains invalid characters.");
                continue;
            }

            // if file does exist already -- allow user to create another file
            if (file == null) {
                System.out.println("File already exists.");
                boolean yesNo = askYesNo("Would you like to create another file? [yes/no] ");

                if (!yesNo) {
                    System.out.println("I shall walk you to the exit...");
                    return;
                }
                continue;
            }
            // create empty file that doesn't exist
            else {
                if (file.createNewFile()) {
                    System.out.println(file.getAbsolutePath() + " created successfully!");
                }
                else {
                    System.out.println("Unable to create file.");
                }
            }
            return;
        }
    }

    /**
     * Asks for a file name, checks if name has valid characters and if it exists,
     * and creates it.
     * 
     * @return boolean
     */
    private static boolean createFile() {
        String fileName = ask("Please enter a file name: ");
        System.out.println("The name of your file is: '" + fileName + "'");

        boolean valid = isValidName(fileName);

        if (valid) {
            file = new File(
                    "C:/Users/Student/Desktop/COMP SCI_2/Projects/Project Potato/Phase 2/files_created_by_phase2/"
                            + fileName + ".txt");

            // .exists() checks if file exists (at that path)
            if (file.exists()) {
                // set file to null if exists so there's no reference
                file = null;
            }
        }
        // return boolean to test in main
        return valid;
    }

    /**
     * Validate that the provided file name is numbers and letters only (case
     * insensitive).
     * 
     * @param fileName
     * @return boolean
     */
    private static boolean isValidName(String fileName) {
        // character classes only allow letters and numbers (\d = any number, \w = any
        // letter); (?i) = case insensitive
        return fileName.matches("(?i)[\\d\\w]+");
    }

    /**
     * Asks a question and returns the response.
     * 
     * @param question
     * @return String
     */
    private static String ask(String question) {
        System.out.println(question);
        System.out.println();
        return scan.nextLine();
    }

    /**
     * Asks a question and returns a boolean (true if yes).
     * 
     * @param question
     * @return boolean
     */
    private static boolean askYesNo(String question) {
        String answer = ask(question);
        return answer.equalsIgnoreCase("yes");
    }

}
