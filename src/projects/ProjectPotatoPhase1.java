package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Print Liam's 'The Potato' poem to the terminal as a File IO, and prints the
 * word count to the user.
 * 
 * @author Gracie Crater
 * @version 2/5/2018
 */

public class ProjectPotatoPhase1 {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        System.out.println("Welcome to The Poem Analyzer!");
        File testFile = new File("C:/Users/Student/Desktop/COMP SCI_2/Projects/Project Potato/LiamPotatoPoem.txt");
        Scanner fileReader = new Scanner(testFile);
        System.out.println("** THE CONTENTS OF THIS FILE ARE BELOW: \n");

        int wordCount = 0, lineCount = 0;
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine().trim();
            System.out.println(line);
            Thread.sleep(1000);
            if ((lineCount > 0) && !(line.startsWith("---")) && !(line.isEmpty())) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            lineCount++;
        }
        System.out.println("\n'The Potato' has: " + wordCount + " words.");
        fileReader.close();
    }
}