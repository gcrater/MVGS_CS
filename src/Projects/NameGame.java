package Projects;

import java.util.Scanner;

/**
 * Name Game song by Shirley Ellis to manipulate name of user and regenerate a
 * new name. There isn't any name that I can't rhyme!
 * 
 * @author (Gracie Crater)
 * @version (10/24/17)
 */
public class NameGame {
    static final String VOWELS = "AEIOUaeiou";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I say let's play a name game based on the Shirley Ellis song!"); // description of purpose
        System.out.println("I betcha I can make a rhyme out of anybody's name...");

        while (true) {
            System.out.println();
            System.out.println("Do you think I can make a rhyme out of your name? [y/n]");
            String yesNo = scan.nextLine();

            if (yesNo.equalsIgnoreCase("y")) {
                System.out.println("There isn't any name that I can't rhyme!");
                System.out.println();
            }
            else {
                System.out.println("I'll take a challenge!");
            }

            System.out.println("What's your name?"); // ask user their name
            String name = scan.nextLine();
            System.out.println();

            String newName = manipulateName(name); // call method to remove vowels

            printSong(name, newName); // print song using original + altered names

            System.out.println("Would you like to run again? [y/n]"); // quits
            yesNo = scan.nextLine();

            if (yesNo.equalsIgnoreCase("n")) {
                break; // user doesn't want to continue, breaks out of infinite loop
            }
        }

    }

    private static String manipulateName(String name) {
        String newName = "";
        boolean vowelSeen = false;
        for (char c : name.toCharArray()) { // cycles thru each character
            if (!vowelSeen) {
                vowelSeen = VOWELS.contains(String.valueOf(c));
            }

            if (vowelSeen) {
                newName += c; // once vowel is 'seen' , build new name
            }
        }
        return newName;
    }

    private static void printSong(String name, String newName) {

        System.out.println(name);
        System.out.println(name);

        String lowerName = name.toLowerCase(); // name to lowercase so if statements don't shortcircuit
        String lowerNewName = newName.toLowerCase();

        if (lowerNewName.equalsIgnoreCase("itch")) {
            System.out.println("Bo b" + newName.replace('i', '*')); // no profanity!!!
        }
        else if (lowerName.startsWith("b")) {
            System.out.println("Bo " + newName); // B rule
        }
        else {
            System.out.println("Bo b" + newName); // default rule
        }

        if (lowerNewName.startsWith("uck") || lowerNewName.startsWith("aggot")) { // no profanity!!!
            System.out.println("Banana fana fo f" + newName.replaceAll("u|a", "*")); // if profanity, replace 'u' OR 'a'
                                                                                     // with '*'
        }
        else if (lowerName.startsWith("f")) {
            System.out.println("Banana fana fo " + newName); // F rule
        }
        else {
            System.out.println("Banana fana fo f" + newName); // default rule
        }

        if (lowerName.startsWith("m")) {
            System.out.println("Me my mo " + newName); // M rule
        }
        else {
            System.out.println("Me my mo m" + newName); // default
        }

        System.out.println(name);
        System.out.println();
    }
}
