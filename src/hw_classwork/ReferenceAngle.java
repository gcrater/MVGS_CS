package hw_classwork;

import java.util.Scanner;

/**
 * Convert an input of degrees (integers only) and generated an output the
 * reference angle. (For review, the reference angle is the angle formed with
 * the terminal side and the horizontal. You need to account for wraparound
 * (degrees > 360 as well as to account for negative angles).
 * 
 * @author Gracie Crater
 * @version 4/9/2018
 */
public class ReferenceAngle {
    public static void main(String[] args) {

        {
            String answer = "yes";
            while (answer.equalsIgnoreCase("yes")) {
                int theta;
                Scanner scan = new Scanner(System.in);
                theta = scan.nextInt();
                int refAngle;
                int subCircle = theta % 360;

                if (theta < 0) {
                    theta = Math.abs(theta);
                }
                while (theta > 360) {

                    theta -= 360;
                }

                if (theta >= 0 && theta <= 90) {
                    refAngle = theta;
                    System.out.println(refAngle);
                }
                else if (theta >= 90 && theta <= 180) {
                    refAngle = 180 - theta;
                    System.out.println(refAngle);
                }
                else if (theta >= 180 && theta <= 270) {
                    refAngle = theta - 180;
                    System.out.println(refAngle);
                }
                else if (theta >= 270 && theta <= 360) {
                    refAngle = 360 - theta;
                    System.out.println(refAngle);
                }
                System.out.println("Would you like to enter another angle? (type yes or no)");
                answer = scan.next();
            }
        }
    }
}
