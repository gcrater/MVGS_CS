package vendingMachineProject;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Perfoms actions regarding money -- calculates cost foro specified number of
 * chocolates, returns precise change in dollars and coins, calculates total
 * money in register.
 * 
 * @author Gracie Crater
 * @date 5/1/2018
 *
 */
public class Register {
    private static final BigDecimal ZERO = new BigDecimal(0);
    private static final BigDecimal DOLLAR = new BigDecimal(1);
    private static final BigDecimal QUARTER = new BigDecimal(.25);
    private static final BigDecimal DIME = new BigDecimal(.1);
    private static final BigDecimal NICKEL = new BigDecimal(.05);
    private static final BigDecimal PENNY = new BigDecimal(0.01);
    private static BigDecimal totalMoney = ZERO;

    /**
     * Allows user to purchase specified number of chocolates. Calculates total
     * price, takes user's money input and calculates change.
     * 
     * @param choco
     * @param quantity
     * @param moneyInput
     * @return change for user
     */
    public Change purchase(Chocolate choco, int quantity, double moneyInput) {
        double totalPrice = choco.getPrice() * quantity;

        BigDecimal preciseMoneyInput = new BigDecimal(moneyInput).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal preciseTotalPrice = new BigDecimal(totalPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal preciseChange = subtract(preciseMoneyInput, preciseTotalPrice);

        if (preciseMoneyInput.compareTo(preciseTotalPrice) < 0) {
            preciseChange = preciseMoneyInput;
        }
        totalMoney = totalMoney.add(preciseTotalPrice).setScale(2, BigDecimal.ROUND_HALF_UP);

        return makeChange(preciseChange.doubleValue());
    }

    /**
     * Calculates total money in register.
     * 
     * @return total money
     */
    public double getTotalMoney() {
        return totalMoney.doubleValue();
    }

    /**
     * Calculates and returns precise change to the user. Gives total amount of
     * money, and counts number of coins to return.
     * 
     * @param change
     * @return Change in terms of how many coins.
     */
    private Change makeChange(double change) {
        int dollars = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;

        // BigDecimal gets accurate decimal amounts to the hundredths place.
        BigDecimal totalChange = new BigDecimal(change).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal preciseChange = new BigDecimal(change).setScale(2, BigDecimal.ROUND_HALF_UP);

        while (preciseChange.doubleValue() > 0) {

            while (preciseChange.doubleValue() >= 1) {
                if (subtract(preciseChange, DOLLAR).compareTo(ZERO) >= 0) {
                    preciseChange = subtract(preciseChange, DOLLAR);
                    dollars++;
                }
            }

            while (preciseChange.doubleValue() >= 0.25) {
                if (subtract(preciseChange, QUARTER).compareTo(ZERO) >= 0) {
                    preciseChange = subtract(preciseChange, QUARTER);
                    quarters++;
                }
            }
            while (preciseChange.doubleValue() >= 0.10) {
                if (subtract(preciseChange, DIME).compareTo(ZERO) >= 0) {
                    preciseChange = subtract(preciseChange, DIME);
                    dimes++;
                }
            }
            while (preciseChange.doubleValue() >= 0.05) {
                if (subtract(preciseChange, NICKEL).compareTo(ZERO) >= 0) {
                    preciseChange = subtract(preciseChange, NICKEL);
                    nickels++;
                }
            }
            while (preciseChange.doubleValue() >= 0.01) {
                if (subtract(preciseChange, PENNY).compareTo(ZERO) >= 0) {
                    preciseChange = subtract(preciseChange, PENNY);
                    pennies++;
                }
            }

        }

        return new Change(totalChange.doubleValue(), dollars, quarters, dimes, nickels, pennies);

    }

    /**
     * Precisely rounds off for neat money formatting.
     * 
     * @param from
     * @param amount
     * @return precisely formatted number (change amount)
     */
    private BigDecimal subtract(BigDecimal from, BigDecimal amount) {
        return from.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}

class Change {
    private int dollars, quarters, dimes, nickels, pennies;
    private double change;

    public Change(double change, int dollars, int quarters, int dimes, int nickels, int pennies) {
        this.change = change;
        this.dollars = dollars;
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

    public int getDollars() {
        return dollars;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public double getChangeAmt() {
        return change;
    }

    // prints/"gives" change to user in terms of total amount, and in coins
    @Override
    public String toString() {
        String result = "Your change is: $" + new DecimalFormat("#0.00").format(change);
        result += "\n# Dollars: " + getDollars();
        result += "\n# Quarters: " + getQuarters();
        result += "\n# Dimes: " + getDimes();
        result += "\n# Nickels: " + getNickels();
        result += "\n# Pennies: " + getPennies();
        return result;
    }

}