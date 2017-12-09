package tbkHW;

import java.util.Random;

/**
 * Project 2.4 (p.112), allow hardcoding (or random number generator to produce
 * the temp) as input, rather than taking user input.
 * 
 * @author (Gracie)
 * @version (9/21/17)
 */

public class TempConverter {
    public static void main(String[] args) {
        final int BASE = 32;
        final double CONVERSION_FACTOR = 5.0 / 9.0;

        Random rand = new Random();
        int fahrenheitTemp = rand.nextInt(201);

        double celsiusTemp;

        celsiusTemp = CONVERSION_FACTOR * (fahrenheitTemp + BASE);
        Math.round(celsiusTemp);

        System.out.println(
                "Celsius Temperature: " + celsiusTemp + " degrees" + " = " + Math.round(celsiusTemp) + " degrees");

        System.out.println("Fahrenheit Temperature: " + fahrenheitTemp + " degrees");
        System.out.println();
    }
}
