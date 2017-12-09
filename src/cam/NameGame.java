package cam;

/**
 * Write a description of class NameGame here.
 * 
 * @author (Cameron Collart) 
 * @version (11/1/2017)
 */
import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String cons = "bcdfghjklmnpqrstvwxyz";
        String vowels = "aeiou";
        char nameChar;

        for (;;) { // infinite for loop
            System.out.println();
            System.out.print("Enter your name:");
            String name = scan.nextLine();
            boolean vowelPresent = false;
            String suffix = "";

            for (int i = 0; i < name.length(); i++) {
                nameChar = name.charAt(i);
                if (vowels.contains(String.valueOf(nameChar))) {
                    vowelPresent = true;
                }

                if (vowelPresent) {
                    suffix += nameChar;
                }
            }

            System.out.println(name + ", " + name + ", bo-b" + suffix);
            System.out.println("Banana-fana fo-f" + suffix);
            System.out.println("Fee-fi-mo-m" + suffix);
            System.out.println(name.toUpperCase() + "!");

            if (name.startsWith("m") || name.startsWith("M")) {
            }

            else if (name.startsWith("b") || name.startsWith("B")) {
                suffix = name.substring(1);
                System.out.println(name + ", " + name + ", bo-" + suffix);
                System.out.println("Banana-fana fo-f" + suffix);
                System.out.println("Fee-fi-mo-m" + suffix);
                System.out.println(name.toUpperCase() + "!");
            }

            else if (name.startsWith("f") || name.startsWith("F")) {
                suffix = name.substring(1);
                System.out.println(name + ", " + name + ", bo-b" + suffix);
                System.out.println("Banana-fana fo-" + suffix);
                System.out.println("Fee-fi-mo-m" + suffix);
                System.out.println(name.toUpperCase() + "!");
            }
            System.out.println("play again? [yes/no]"); // change this message to whatever question you want
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
}