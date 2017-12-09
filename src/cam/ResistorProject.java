package cam;

/**
 * This program takes three inputted values for the colors of bands that would be found on a resistor and computes the corresponding resistor value.  
 * It also gives the user a range of acceptable values based off of the tolerance band that is chosen
 * 
 * @author Cameron Collart 
 * @version 11/14/17
 */

import java.util.Scanner;

public class ResistorProject {
    public static void main(String[] args) {

        System.out.println(
                "Welcome! This program will take your inputted values for resistor bands, \n and give you its resistance value and range in ohms!");
        System.out.println();
        System.out.println("Color values:\n 0 = Black\n 1 = Brown\n 2 = Red\n 3 = Orange\n 4 = Yellow\n "
                + "5 = Green\n 6 = Blue\n 7 = Violet\n 8 = Grey\n 9 = White");

        Scanner input = new Scanner(System.in);

        String color;
        int ohmval;

        String sentinel = "y";
        while (sentinel.equalsIgnoreCase("y")) {

            System.out.println("Please input a number 0-9 for color 1:");
            int color1 = input.nextInt();
            switch (color1) {
            case 0:
                color = "black";
                break;
            case 1:
                color = "brown";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "orange";
                break;
            case 4:
                color = "yellow";
                break;
            case 5:
                color = "green";
                break;
            case 6:
                color = "blue";
                break;
            case 7:
                color = "violet";
                break;
            case 8:
                color = "grey";
                break;
            case 9:
                color = "white";
                break;
            default:
                System.out.println("Please enter a valid color");
            }

            color1 *= 10;

            System.out.println("Please input a number 0-9 for color 2:");
            int color2 = input.nextInt();
            while (color2 < 0 || color2 > 9) {

                System.out.println("Please enter a valid color:");
                color2 = input.nextInt();
            }
            switch (color2) {
            case 0:
                color = "black";
                break;
            case 1:
                color = "brown";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "orange";
                break;
            case 4:
                color = "yellow";
                break;
            case 5:
                color = "green";
                break;
            case 6:
                color = "blue";
                break;
            case 7:
                color = "violet";
                break;
            case 8:
                color = "grey";
                break;
            case 9:
                color = "white";
                break;
            default:
                System.out.println("Please enter a valid color");
            }
            System.out.println("Please input a number 0-9 for color 3:");
            int color3 = input.nextInt();
            while (color3 < 0 || color3 > 9) {

                System.out.println("Please enter a valid color:");
                color3 = input.nextInt();
            }
            switch (color3) {
            case 0:
                color = "black";
                break;
            case 1:
                color = "brown";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "orange";
                break;
            case 4:
                color = "yellow";
                break;
            case 5:
                color = "green";
                break;
            case 6:
                color = "blue";
                break;
            case 7:
                color = "violet";
                break;
            case 8:
                color = "grey";
                break;
            case 9:
                color = "white";
                break;
            default:
                System.out.println("Please enter a valid color");
            }

            ohmval = (color1 + color2);
            double resistVal = ohmval * Math.pow(10, color3);

            if (resistVal >= 1000 && resistVal <= 999999) {
                double newResistVal = resistVal / 1000;
                System.out.println("\nResistor Value: " + newResistVal + " kΩ");
            }
            if (resistVal >= 1000000 && resistVal <= 99999999) {
                double newResistVal = resistVal / 1000000;
                System.out.println("Resistor Value: " + newResistVal + " MΩ");
            }
            if (resistVal >= 1000000000) {
                double newResistVal = resistVal / 1000000000;
                System.out.println("Resistor Value: " + newResistVal + " GΩ");
            }

            System.out.println();
            System.out.println("Tolerance values:\n 0 = None\n 1 = Silver(±10%)\n 2 = Gold(±5%) \n");
            System.out.println("Please enter a value for your tolerance band: ");
            int tolerance = input.nextInt();

            while (tolerance < 0 || tolerance > 2) {
                System.out.println("Please enter a valid color:");
                tolerance = input.nextInt();
            }

            double minVal, maxVal, newMinVal = 0, newMaxVal = 0;

            if (tolerance == 0) { // refine range values for no color
                minVal = resistVal - resistVal * 0.2;
                maxVal = resistVal + resistVal * 0.2;

                // minimum for kilo-ohms
                if (minVal >= 1000 && minVal <= 999999) {
                    newMinVal = minVal / 1000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " kΩ --> ");
                }
                // max for kilos
                if (maxVal >= 1000 && maxVal <= 999999) {
                    newMaxVal = maxVal / 1000;
                    System.out.println(newMaxVal + " kΩ.");
                }

                // min for mega-ohms
                if (maxVal >= 1000000 && maxVal <= 99999999) {
                    newMinVal = minVal / 1000000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " MΩ --> ");
                }
                // max for mega
                if (maxVal >= 1000000 && maxVal <= 99999999) {
                    newMaxVal = maxVal / 1000000;
                    System.out.println(newMaxVal + " MΩ.");
                }

                // min for gega-ohms
                if (minVal >= 1000000000) {
                    newMinVal = minVal / 1000000000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " GΩ --> ");
                }
                // max for mega
                if (minVal >= 1000000000) {
                    newMaxVal = maxVal / 1000000000;
                    System.out.println(newMaxVal + " GΩ.");
                }
            }

            if (tolerance == 1) {
                minVal = resistVal - resistVal * 0.1;
                maxVal = resistVal + resistVal * 0.1;

                // minimum for kilo-ohms
                if (minVal >= 1000 && minVal <= 999999) {
                    newMinVal = minVal / 1000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " kΩ --> ");
                }
                // max for kilos
                if (maxVal >= 1000 && maxVal <= 999999) {
                    newMaxVal = maxVal / 1000;
                    System.out.println(newMaxVal + " kΩ.");
                }

                // min for mega-ohms
                if (maxVal >= 1000000 && maxVal <= 99999999) {
                    newMinVal = minVal / 1000000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " MΩ --> ");
                }
                // max for mega
                if (maxVal >= 1000000 && maxVal <= 99999999) {
                    newMaxVal = maxVal / 1000000;
                    System.out.println(newMaxVal + " MΩ.");
                }

                // min for gega-ohms
                if (minVal >= 1000000000) {
                    newMinVal = minVal / 1000000000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " GΩ --> ");
                }
                // max for mega
                if (minVal >= 1000000000) {
                    newMaxVal = maxVal / 1000000000;
                    System.out.println(newMaxVal + " GΩ.");
                }
            }

            if (tolerance == 2) {
                minVal = resistVal - resistVal * 0.05;
                maxVal = resistVal + resistVal * 0.05;

                // minimum for kilo-ohms
                if (minVal >= 1000 && minVal <= 999999) {
                    newMinVal = minVal / 1000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " kΩ --> ");
                }
                // max for kilos
                if (maxVal >= 1000 && maxVal <= 999999) {
                    newMaxVal = maxVal / 1000;
                    System.out.println(newMaxVal + " kΩ.");
                }

                // min for mega-ohms
                if (maxVal >= 1000000 && maxVal <= 99999999) {
                    newMinVal = minVal / 1000000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " MΩ --> ");
                }
                // max for mega
                if (maxVal >= 1000000 && maxVal <= 99999999) {
                    newMaxVal = maxVal / 1000000;
                    System.out.println(newMaxVal + " MΩ.");
                }

                // min for gega-ohms
                if (minVal >= 1000000000) {
                    newMinVal = minVal / 1000000000;
                    System.out.print("The range that your tolerance value gives you is: " + newMinVal + " GΩ --> ");
                }
                // max for mega
                if (minVal >= 1000000000) {
                    newMaxVal = maxVal / 1000000000;
                    System.out.println(newMaxVal + " GΩ.");
                }
            }
            System.out.println("\nWould you like to find another resistor value? (y/n)");
            sentinel = input.next();
        }

    }
}
