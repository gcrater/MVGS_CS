package tbkHW;

import java.util.Scanner;

/**
 * Print out user-specified number of lines of Pascal's Triangle
 * 
 * @author Gracie Crater
 * @version 2/26/2018
 */
public class PascalsTriangle {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Blaise's Geometric Shop!");
        System.out.print("How many layers would you like on your Pascal Cake? ");

        int layers = scan.nextInt();
        System.out.println("\nOne Pascal Cake with " + layers + " layers coming right your way!!");
        System.out.println();

        printTriangle(layers);

        System.out.println();
        System.out.println("Tada! Thanks for stopping by Blaise's Geometric Bakery!");
    }

    /**
     * Recursive method calls upon itself to store/create/build the Pascal Triangle.
     * 
     * @param num1
     * @param num2
     * @return int
     */
    private static int buildTriangle(int num1, int num2) {
        if (num2 == 0) {
            return 1;
        }
        else if (num2 == num1) {
            return 1;
        }
        else {
            int pascal = buildTriangle(num1 - 1, num2 - 1) + buildTriangle(num1 - 1, num2);
            return pascal;
        }
    }

    /**
     * Method uses nested for loops to print out every value that is stored/built
     * inside the recursive 'buildTriangle' method.
     * 
     * @param layers
     */
    private static void printTriangle(int layers) {
        for (int i = 0; i < layers; i++) {
            for (int k = 0; k <= i; k++) {
                System.out.print(buildTriangle(i, k) + "  ");
            }
            System.out.println();
        }
    }
}
