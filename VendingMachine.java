package vendingMachineProject;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Allows user to purchase a snack and receive change.
 * Author: Gracie Crater
 * Date: 5/1/2018
 */
public class VendingMachine {
    private static Register register = new Register();
    private static Inventory inventory = new Inventory();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Cocoa-Loco!");

        while (true) {
            System.out.println("Please select a chocolate by its position. ");
            System.out.println();
            Inventory.displayInventory();
            Chocolate selectedChoco = selectChoco();
            int quantity = selectQuantity(selectedChoco);

            double moneyCollected = collect(quantity * selectedChoco.getPrice());
            Inventory.purchase(selectedChoco, quantity);

            Change change = register.purchase(selectedChoco, quantity, moneyCollected);
            System.out.println(change.toString());
            System.out.println();
            System.out.println("Total money in machine: $" +
                    new DecimalFormat("#0.00").format(register.getTotalMoney()));
            System.out.println();

            System.out.println("Would you like to make another purchase? [yes/no]");
            String yesNo = scan.nextLine();

            if (yesNo.contains("n")) {
                System.out.println("Enjoy your " + selectedChoco.getDescription() + "!");
                System.out.println();
                System.out.println("Total money in machine: $" +
                        new DecimalFormat("#0.00").format(register.getTotalMoney()));
                System.out.println("Total inventory left in stock: " + Inventory.totalInventory());
                break;
            }

        }
    }

    /**
     * Allows user to choose a snack based on position.
     * 
     * @return choco - chocolate selected by user
     */
    private static Chocolate selectChoco() {
        Chocolate choco = null;

        while (choco == null) {
            System.out.print("Enter snack position: ");
            String pos = scan.nextLine();
            System.out.println();

            choco = Chocolate.findPosition(pos);
            if (choco == null) {
                System.out.println("No item exists with that id. Please try again.");
                continue;
            }

            if (inventory.isOutofStock(choco)) {
                System.out.println("I'm sorry. " + choco.getDescription() +
                        " is sold out. Please select another item.");
                choco = null;
                continue;
            }
        }

        return choco;
    }

    /**
     * Allows user to input quantity of selected chocolate to purchase.
     * 
     * @param choco
     *            - chocolate selected by user
     * @return quantity - quantity input by user
     */
    private static int selectQuantity(Chocolate choco) {
        int quantity = 0;

        while (true) {
            System.out.print("Enter quantity: ");
            quantity = Integer.parseInt(scan.nextLine());

            if (quantity <= 0) {
                System.out.println("Invalid quantity. Input at least 1.");
            }
            else if (!Inventory.hasInStock(choco, quantity)) {
                System.out.println("We don't have " + quantity + " " + choco.getDescription() + " in stock.");
                System.out.println(
                        "There are " + Inventory.countChoco(choco) + " " + choco.getDescription() + " in stock.");
                System.out.println();
            }
            else {
                break;
            }
        }
        System.out.println("You selected " + quantity + " " + choco.getDescription() + ".");
        System.out.println();
        System.out.println(
                "Please enter at least $" + new DecimalFormat("#0.00").format((quantity * choco.getPrice())) + ".");
        System.out.println();
        return quantity;
    }

    /**
     * Collects money from the user. User must input at least the amount of the
     * price of their items.
     * 
     * @param minimum
     *            - the price for user's desired items
     * @return moneyCollected - money inserted by user
     */
    private static double collect(double minimum) {
        double moneyCollected = 0;

        while (moneyCollected <= 0) {
            System.out.print("How much money are you inserting?  ");
            System.out.println();
            moneyCollected = Double.parseDouble(scan.nextLine());

            if (moneyCollected < minimum) {
                System.out.println("You must provide at least $" + new DecimalFormat("#0.00").format(minimum));
                moneyCollected = 0;
            }
        }

        return moneyCollected;

    }

}
