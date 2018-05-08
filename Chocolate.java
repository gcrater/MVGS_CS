package vendingMachineProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Encapsulates characteristics for each chocolate item.
 * Author: Gracie Crater
 * Date: 5/1/2018
 */

public enum Chocolate {
    REESES(0.75, "Reese's", 1000, new Coordinate('A', 1)),
    MMS(0.875, "M&M's", 1001, new Coordinate('A', 2)),
    HERSHEYS(0.675, "Hershey's", 1002, new Coordinate('A', 3)),
    MUSK3(0.55, "3 Musketeers", 1003, new Coordinate('B', 1)),
    MILKYWAY(0.575, "Milky Way", 1004, new Coordinate('B', 2)),
    KITKAT(0.875, "Kit Kat", 1005, new Coordinate('B', 3)),
    SNICKERS(0.575, "Snickers", 1006, new Coordinate('C', 1)),
    YORK(0.375, "York", 1007, new Coordinate('C', 2)),
    BUTTERFINGER(0.675, "Butterfinger", 1008, new Coordinate('C', 3));

    private double wholeSale;
    private double price;
    private String description;
    private int chocoID;
    private Coordinate position;

    private Chocolate(double wholeSale, String desc, int id, Coordinate pos) {
        this.wholeSale = wholeSale;
        this.price = wholeSale * 2; // price = 100% more than wholeSale for a profit
        this.description = desc;
        this.chocoID = id;
        this.position = pos;
    }

    /**
     * Creates a list of chocolates in order by their ID.
     * 
     * @return chocoList - list of chocolates
     */
    public static List<Chocolate> orderByID() {
        List<Chocolate> chocoList = new ArrayList<>();
        for (Chocolate c : Chocolate.values()) {
            chocoList.add(c);
        }

        // Compares chocolates by their ID
        Comparator<Chocolate> compare = new Comparator<Chocolate>() {

            @Override
            public int compare(Chocolate o1, Chocolate o2) {
                return new Integer(o1.getChocoID()).compareTo(new Integer(o2.getChocoID()));
            }
        };
        // sorts the list by ID
        Collections.sort(chocoList, compare);
        return chocoList;
    }

    /**
     * Returns chocolate at specified position.
     * 
     * @param pos
     *            - "id" for the chocolate
     * @return c - the chocolate at particular position
     */
    public static Chocolate findPosition(String pos) {
        for (Chocolate c : Chocolate.values()) {
            if (pos.equalsIgnoreCase(c.getPosition().toString())) {
                return c;
            }
        }
        return null;
    }

    public double getWholeSale() {
        return wholeSale;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getChocoID() {
        return chocoID;
    }

    public Coordinate getPosition() {
        return position;
    }

}
