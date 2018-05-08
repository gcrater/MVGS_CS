package Ch5;

import java.util.Scanner;

/**
 * Utilize method to calculate a slope from 4 parameters, and call the method
 * from main.
 * 
 * @author Gracie Crater
 * @version 1/30/2018
 */
public class SlopeCalculator {
    public static void main(String[] args) {
        System.out.println("Slope formula = (Δy) / (Δx) ");

        try {
            System.out.print("Enter 'x1' value: ");
            int x1 = getValue();
            System.out.print("Enter 'y1' value: ");
            int y1 = getValue();
            System.out.print("Enter 'x2' value: ");
            int x2 = getValue();
            System.out.print("Enter 'y2' value: ");
            int y2 = getValue();
            double slope = getSlope(x1, y1, x2, y2);
        }
        catch (Exception e) {
            System.out.println("Oops!");
        }

    }

    private static int getValue() {
        Scanner scan = new Scanner(System.in);

        int value = scan.nextInt();
        return value;
    }

    private static double getSlope(int x1, int y1, int x2, int y2) {
        double m = (double) (y2 - y1) / (double) (x2 - x1);
        System.out.println("The slope is: " + m);
        return m;
    }
}
