package Projects;

import java.util.Scanner;

public class ResistorProgram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Join the Resistance!");
        System.out.println();

        while (true) {

            System.out.println("Here is the list of colors you can choose from: ");
            System.out.println("black, brown, red, orange, yellow,");
            System.out.println("green, blue, violet, grey, white");
            System.out.println();

            System.out.print("Enter color: "); // user inputs colors
            String color1 = scan.nextLine();
            String colNum1 = colorToValue(color1);

            System.out.print("Enter a second color: ");
            String color2 = scan.nextLine();
            String colNum2 = colorToValue(color2);

            System.out.print("Enter a third color: ");
            String color3 = scan.nextLine();
            String colNum3 = colorToValue(color3);

            double resistorVal = calculateResistor(colNum1, colNum2, colNum3);

            System.out.println("Choose one of the following colors: "); // color for tolerance band
            System.out.println("gold, silver, or no color");
            System.out.println();
            System.out.print("Enter color: ");
            String color4 = scan.nextLine();

            double tolPercent = calcTolerance(color4); // calculates tolerance percentage

            // 2 elements, minimum at [0] and maximum at [1] -- calculates possible ranges
            double[] range = calcToleranceRange(resistorVal, tolPercent);

            System.out.println();

            String refinedResistorValue = refineValue(resistorVal); // gives a nice number
            String refinedMin = refineValue(range[0]);
            String refinedMax = refineValue(range[1]);

            System.out.println("Resistor value: " + refinedResistorValue);
            System.out.println("Possible resistor ranges: " + refinedMin + " - " + refinedMax);

            System.out.println("\nWould you like to build another resistor? [yes/no]");
            String yesNo = scan.nextLine();

            if (yesNo.equalsIgnoreCase("no")) { // allows user to continue thru while loop
                System.out.println("User requested to exit.");
                break;
            }
            System.out.println();
        }
    }

    private static String refineValue(double value) { // just return the value as-is if it's < 1k
        // @param = messy resistor or tolerance value
        // @return = refined value with abbreviation and ohm symbol appended

        String result = String.valueOf(value);

        if (value > 1000000000) {
            result = value / 1000000000 + " GΩ"; // giga
        }
        else if (value > 1000000) {
            result = value / 1000000 + " MΩ"; // mega
        }
        else if (value > 1000) {
            result = value / 1000 + " kΩ"; // kilo
        }
        return result;
    }

    private static String colorToValue(String colorInput) { // assign band value to corresponding colors
        // @param = color input by user
        // @return = corresponding band value to chosen color
        String colorNum = "";
        String bandNum = "";

        switch (colorInput) {

        case "black":
            colorNum = "Black";
            bandNum = "0";
            break;
        case "brown":
            colorNum = "Brown";
            bandNum = "1";
            break;
        case "red":
            colorNum = "Red";
            bandNum = "2";
            break;
        case "orange":
            colorNum = "Orange";
            bandNum = "3";
            break;
        case "yellow":
            colorNum = "Yellow";
            bandNum = "4";
            break;
        case "green":
            colorNum = "Green";
            bandNum = "5";
            break;
        case "blue":
            colorNum = "Blue";
            bandNum = "6";
            break;
        case "violet":
            colorNum = "Violet";
            bandNum = "7";
            break;
        case "grey":
            colorNum = "Grey";
            bandNum = "8";
            break;
        case "white":
            colorNum = "White";
            bandNum = "9";
            break;
        default:
            colorNum = "Input";
            bandNum = "invalid.";
            break;
        }
        System.out.println(colorNum + " = " + bandNum); // informs user of value per color
        System.out.println();
        return bandNum;
    }

    private static double calculateResistor(String colNum1, String colNum2, String colNum3) {
        // @param = the 3 colors chosen by user
        // @return = returns the calculated messy resistor value

        String baseStr = colNum1 + colNum2; // append first two color values
        int base = Integer.parseInt(baseStr); // turn String into int for base
        int power = Integer.parseInt(colNum3); // turn string into int for power

        double resistorVal = base * (Math.pow(10, power)); // formula

        System.out.println(baseStr + " * 10 ^ " + colNum3 + " = " + resistorVal);
        System.out.println();
        return resistorVal;
    }

    private static double calcTolerance(String color4) {
        // @param = color input from user
        // @return = percentage for corresponding tolerance band color
        double tolPercent = 0;
        String tolRangePrint = "";

        switch (color4) {
        case "gold":
            tolPercent = .05;
            tolRangePrint = "+/- 5%";
            break;
        case "silver":
            tolPercent = .1;
            tolRangePrint = "+/- 10%";
            break;
        case "no color":
            tolPercent = .2;
            tolRangePrint = "+/- 20%";
            break;
        }
        System.out.println("The tolerance range for " + color4 + " is: " + tolRangePrint);
        return tolPercent;
    }

    private static double[] calcToleranceRange(double resistorVal, double tolPercent) {
        // @param = the messy resistor value and percentage of specific tolerance band
        // @return = min and max range values calculated with percentage
        double deviance = resistorVal * tolPercent;
        double minimum = resistorVal - deviance;
        double maximum = resistorVal + deviance;

        // return an array of length 2, with minimum at [0] and maximum at [1]
        return new double[] { minimum, maximum };
    }
}
