package projects;

import java.util.ArrayList;

/*
 * Brief program demonstrating knowledge of ArrayLists and methods.
 * @author Gracie Crater
 * @date 4/23/2018
 */
public class ArrayListDemo_hw {

    public static void main(String[] args) {

        ArrayList exoticSports = new ArrayList();
        // add() method
        exoticSports.add("kabaddi");
        exoticSports.add("baseball");
        exoticSports.add("toe wrestling");
        exoticSports.add("zorbing");
        exoticSports.add("bossaball");
        exoticSports.add("parkour");
        exoticSports.add("bog snorkelling");

        // toString() method call (implicit)
        System.out.println(exoticSports);

        // the other add() method
        exoticSports.add(4, "ferret-legging");

        // get() method
        System.out.println(exoticSports.get(4));

        // remove() method
        exoticSports.remove(5);

        // set() method & iteration over ArrayList
        for (int i = 0; i < exoticSports.size(); i++) {
            if (i == 5) {
                exoticSports.set(i, "sepak takraw");
            }
        }

        exoticSports.add("chess boxing");

        System.out.println(exoticSports);
    }

}
