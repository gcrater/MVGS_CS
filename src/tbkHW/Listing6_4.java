package tbkHW;

import java.util.Scanner;

public class Listing6_4 {

    public static void main(String[] args) {

        System.out.println("Enter lots of numbers between 1 and 100 " + "(Enter 0 as last number to quit): ");
        Scanner scan = new Scanner(System.in);

        int rangeTo10 = 0;
        int rangeTo20 = 0;
        int rangeTo30 = 0;
        int rangeTo40 = 0;
        int rangeTo50 = 0;
        int rangeTo60 = 0;
        int rangeTo70 = 0;
        int rangeTo80 = 0;
        int rangeTo90 = 0;
        int rangeTo100 = 0;

        while (scan.hasNextInt()) {
            int input = scan.nextInt();

            if (input == 0) {
                break;
            }

            if ((input > 0) && (input <= 10)) {
                rangeTo10++;
            }
            else if ((input > 10) && (input <= 20)) {
                rangeTo20++;
            }
            else if ((input > 20) && (input <= 30)) {
                rangeTo30++;
            }
            else if ((input > 30) && (input <= 40)) {
                rangeTo40++;
            }
            else if ((input > 40) && (input <= 50)) {
                rangeTo50++;
            }
            else if ((input > 50) && (input <= 60)) {
                rangeTo60++;
            }
            else if ((input > 60) && (input <= 70)) {
                rangeTo70++;
            }
            else if ((input > 70) && (input <= 80)) {
                rangeTo80++;
            }
            else if ((input > 80) && (input <= 90)) {
                rangeTo90++;
            }
            else if ((input > 90) && (input <= 100)) {
                rangeTo100++;
            }
        }

        System.out.println();
        printStars(rangeTo10, "1 - 10  ");
        printStars(rangeTo20, "11 - 20 ");
        printStars(rangeTo30, "21 - 30 ");
        printStars(rangeTo40, "31 - 40 ");
        printStars(rangeTo50, "41 - 50 ");
        printStars(rangeTo60, "51 - 60 ");
        printStars(rangeTo70, "61 - 70 ");
        printStars(rangeTo80, "71 - 80 ");
        printStars(rangeTo90, "81 - 90 ");
        printStars(rangeTo100, "91 - 100");

        System.out.println("\nTa-da! Your histogram is complete!");
    }

    private static void printStars(int counter, String range) {
        System.out.print(range + " | ");
        for (int i = 0; i < counter; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

}
