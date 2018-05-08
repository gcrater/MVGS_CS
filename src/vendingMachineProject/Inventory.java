package vendingMachineProject;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Contains methods in regards to inventory of Chocolates. Keeps track of total
 * items in stock, subtracts number bought from correct chocolate's stock, keeps
 * track of stock per chocolate.
 * 
 * @author Gracie Crater
 * @date 5/1/2018
 */
public class Inventory {

    // key, value --> amount of each chocolate
    private static Map<Chocolate, Integer> chocoCount = new TreeMap<>();

    public Inventory() {
        setupRandomInventory();
    }

    /**
     * Returns count available for specified type of Chocolate.
     * 
     * @param choco
     *            - Chocolate type
     * @return chocoCount
     */
    public static Integer countChoco(Chocolate choco) {
        return chocoCount.get(choco);
    }

    /**
     * Returns if specififed chocolate is in stock.
     * 
     * @param choco
     * @param quantity
     * @return boolean - whether choco is in stock
     */
    public static boolean hasInStock(Chocolate choco, int quantity) {
        return (quantity <= countChoco(choco));
    }

    /**
     * Purchases chocolate, and subtract quantity from inventory
     * 
     * @param choco
     *            - Chocolate type
     * @param numBought
     *            - number to purchase
     * @return numBought
     */
    public static Integer purchase(Chocolate choco, int numBought) {
        Integer numAvailable = countChoco(choco);

        // prevent purchase more than available
        if (numBought > numAvailable) {
            numBought = numAvailable;
        }

        // update available count
        chocoCount.put(choco, numAvailable - numBought);

        return numBought;
    }

    /**
     * Randomly generates int's 0-10 to stock each chocolate. Limits the number of 0
     * in stock to 2 chocolates.
     */
    private void setupRandomInventory() {
        Random random = new Random();
        int countOutofStock = 0;
        int maxOutofStock = 2;
        for (Chocolate c : Chocolate.values()) {
            int countAvailable = random.nextInt(11);
            if (countAvailable == 0) {
                countOutofStock++;
                if (countOutofStock >= maxOutofStock) {
                    countAvailable = random.nextInt(11) + 1;
                }
            }
            chocoCount.put(c, countAvailable);
        }
    }

    /**
     * Calculates total items in stock.
     * 
     * @return total
     */
    public static int totalInventory() {
        int total = 0;
        for (Chocolate c : Chocolate.values()) {
            total += countChoco(c);
        }
        return total;
    }

    /**
     * Displays inventory of chocolates in order of ID, and corresponding quantity
     * in stock.
     */
    public static void displayInventory() {
        for (Chocolate c : Chocolate.orderByID()) {
            String temp = " (" + countChoco(c) + " available)";

            if (countChoco(c) == 0) {
                temp = " -- OUT OF STOCK!";
            }
            System.out.println(c.getPosition().toString() + " - " + c.getDescription() +
                    temp);
        }
        System.out.println();
    }

    /**
     * Returns if specified chocolate is out of stock.
     * 
     * @param choco
     * @return boolean - whether choco is out of stock
     */
    public boolean isOutofStock(Chocolate choco) {
        return countChoco(choco) == 0;
    }

}
