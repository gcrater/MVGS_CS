package Ch6;

import java.util.ArrayList;

/**
 * Write a collection of sports as an ArrayList.
 * 
 * @author Gracie Crater
 * @version 12/1/17
 */
public class ArrayList_classwork {
    // different types of sports
    public static void main(String[] args) {

        String[] sportArray = new String[10];
        sportArray[0] = "baseball";
        sportArray[1] = "soccer";
        sportArray[2] = "football";
        sportArray[3] = "basketball";
        sportArray[4] = "swimming";
        sportArray[5] = "volleyball";
        sportArray[6] = "lacrosse";
        sportArray[7] = "cross country";
        sportArray[8] = "golf";

        System.out.println(sportArray);

        ArrayList<String> sports = new ArrayList<>();
        sports.add("baseball");
        sports.add("soccer");
        sports.add("football");

        System.out.println(sports);
        sports.remove("football");
        System.out.println("TOO MANY CONCUSSIONS!");
        System.out.println(sports);

    }
}
