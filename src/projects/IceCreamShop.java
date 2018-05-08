package projects;

import java.text.NumberFormat;

/**
 * Create an ice cream store with given sales and hours for the shop. (Complete
 * without the web). Explore 2-D arrays.
 * 
 * @author Gracie Crater
 * @date 3/10/2018
 *
 */

public class IceCreamShop {

    enum Flavor {
        vanilla, chocolate, swirl
    }

    enum Weekday {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
    }

    // chart for sales (rows = days of week; columns = sales per flavor)
    static int[][] salesMatrix = { { 71, 63, 54 }, { 55, 40, 32 }, { 28, 19, 7 }, { 42, 25, 19 }, { 66, 58, 43 },
            { 112, 98, 57 }, { 207, 113, 98 } };

    public static void main(String[] args) {

        System.out.println("Welcome to the Truck....... the Ice Cream Truck.....");

        printFullSalesReport(salesMatrix);
        System.out.println();
        int totalCones = calcTotalSales(salesMatrix);
        System.out.println("* Total ice cream cones sold this week: " + totalCones);

        System.out.println("\n* Total flavor sales:");
        int vanilla = calcVanillaSales(salesMatrix);
        System.out.println("Vanilla:\t" + vanilla);
        int choc = calcChocSales(salesMatrix);
        System.out.println("Chocolate:\t" + choc);
        int swirl = calcSwirlSales(salesMatrix);
        System.out.println("Swirl: \t\t" + swirl);
        System.out.println();
        calcDailySales(salesMatrix);

        System.out.println();

        calcProfit(vanilla, choc, swirl, totalCones, salesMatrix);

    }

    /**
     * Prints full sales report (weekdays and flavors)
     * 
     * @param salesMatrix
     */
    private static void printFullSalesReport(int[][] salesMatrix) {
        System.out.println();

        System.out.println("Sales Report: ");
        System.out.println("--------------------------------------");

        System.out.println("Weekday      Vanilla   Choc.   Swirl");
        printSalesTable(salesMatrix);
        System.out.println();

    }

    /**
     * @param salesMatrix
     */
    private static void printSalesTable(int[][] salesMatrix) {

        for (int row = 0; row < salesMatrix.length; row++) {
            for (int col = 0; col < salesMatrix[0].length; col++) {

                if (col % 3 == 0) {
                    System.out.println();
                }

                if (col == 0) {

                    switch (row) {
                    case 0:
                        System.out.print("Sunday   " + "\t");
                        break;
                    case 1:
                        System.out.print("Monday   " + "\t");
                        break;
                    case 2:
                        System.out.print("Tuesday  " + "\t");
                        break;
                    case 3:
                        System.out.print("Wednesday" + "\t");
                        break;
                    case 4:
                        System.out.print("Thursday " + "\t");
                        break;
                    case 5:
                        System.out.print("Friday   " + "\t");
                        break;
                    case 6:
                        System.out.print("Saturday " + "\t");
                        break;
                    default:
                        System.out.print("Invalid day.");
                        break;
                    }

                }
                System.out.print(salesMatrix[row][col] + "\t");
            }
        }
    }

    /**
     * Calculate total ice cream cone sales for the week.
     * 
     * @param salesMatrix
     * @return totalCones
     */
    private static int calcTotalSales(int[][] salesMatrix) {
        int totalCones = 0;

        for (int row = 0; row < salesMatrix.length; row++) {
            for (int col = 0; col < salesMatrix[0].length; col++) {
                totalCones += salesMatrix[row][col];
            }
        }
        return totalCones;
    }

    /**
     * Calculate total sales of vanilla for the week.
     * 
     * @param salesMatrix
     * @return vanilla
     */
    private static int calcVanillaSales(int[][] salesMatrix) {
        int vanilla = 0;

        for (int row = 0; row < salesMatrix.length; row++) {
            for (int col = 0; col < salesMatrix[0].length; col++) {
                if (col == 0) {
                    vanilla += salesMatrix[row][col];
                }
            }
        }

        return vanilla;

    }

    /**
     * Calculate total sales of chocolate for the week.
     * 
     * @param salesMatrix
     * @return choc
     */
    private static int calcChocSales(int[][] salesMatrix) {

        int choc = 0;
        for (int row = 0; row < salesMatrix.length; row++) {
            for (int col = 0; col < salesMatrix[0].length; col++) {
                if (col == 1) {
                    choc += salesMatrix[row][col];
                }
            }
        }
        return choc;
    }

    /**
     * Calculate total sales of swirl for the week.
     * 
     * @param salesMatrix
     * @return swirl
     */
    private static int calcSwirlSales(int[][] salesMatrix) {
        int swirl = 0;
        for (int row = 0; row < salesMatrix.length; row++) {
            for (int col = 0; col < salesMatrix[0].length; col++) {
                if (col == 2) {
                    swirl += salesMatrix[row][col];
                }
            }
        }
        return swirl;

    }

    /**
     * Calculate and print total sales for each day.
     * 
     * @param salesMatrix
     */
    private static void calcDailySales(int[][] salesMatrix) {
        int sun = 0, mon = 0, tues = 0, wed = 0, thurs = 0, fri = 0, sat = 0;

        for (int row = 0; row < salesMatrix.length; row++) {
            for (int col = 0; col < salesMatrix[0].length; col++) {

                if (col == 0 || col == 1 || col == 2) {
                    switch (row) {
                    case 0:
                        if (row == 0) {
                            sun += salesMatrix[0][col];
                        }
                        break;
                    case 1:
                        if (row == 1) {
                            mon += salesMatrix[1][col];
                        }
                        break;
                    case 2:
                        if (row == 2) {
                            tues += salesMatrix[2][col];
                        }
                        break;
                    case 3:
                        if (row == 3) {
                            wed += salesMatrix[3][col];
                        }
                        break;
                    case 4:
                        if (row == 4) {
                            thurs += salesMatrix[4][col];
                        }
                        break;
                    case 5:
                        if (row == 5) {
                            fri += salesMatrix[5][col];
                        }
                        break;
                    case 6:
                        if (row == 6) {
                            sat += salesMatrix[6][col];
                        }
                        break;
                    default:
                        System.out.print("Invalid day.");
                        break;
                    }
                }

            }
        }

        System.out.println("* Total daily sales: ");
        System.out.println("Sunday: \t" + sun);
        System.out.println("Monday: \t" + mon);
        System.out.println("Tuesday:\t" + tues);
        System.out.println("Wednesday:\t" + wed);
        System.out.println("Thursday:\t" + thurs);
        System.out.println("Friday: \t" + fri);
        System.out.println("Saturday:\t" + sat);
    }

    /**
     * Calculate and print tills with and without tax deductions. Answers questions
     * on worksheet.
     * 
     * @param totalCones,
     *            salesMatrix
     */
    private static void calcProfit(int vanilla, int choc, int swirl, int totalCones, int[][] salesMatrix) {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(2);

        // calculate total tills (before deductions)
        double rawTill = totalCones * 1.95;

        // till + sales + restaurant tax = 7.5%
        double totalTill = rawTill + rawTill * (0.075);
        System.out.println("#3. How much $$ in tills altogether:  \t" + money.format(totalTill));

        // calculate amount sent to state fm sales tax (5%)
        double salesTax = rawTill * 0.05;
        System.out.println("#4. How much $$ send to state:  \t" + money.format(salesTax));

        // calculate amt sent to town
        double townTax = rawTill * 0.025;
        System.out.println("#5. How much $$ send to town:  \t\t" + money.format(townTax));

        // total tax
        double totalTax = salesTax + townTax;

        // after sending out sales tax, how much is left in the till?
        double postSalesTax = totalTill - salesTax;
        System.out.println(
                "#6. After sending out sales tax, how much is left in the till?  " + money.format(postSalesTax));

        // if management closes shop on Mondays -- how many sales are lost
        double mondayCones = salesMatrix[1][0] + salesMatrix[1][1] + salesMatrix[1][2];
        double mondaySales = mondayCones * 1.95;
        double mondaySalesWTax = mondaySales + mondaySales * 0.075;
        System.out
                .println("#7. If shop is closed on Mondays, ice cream sales lost = \t" + money.format(mondaySalesWTax));

        // fraction of sales represented by Monday (before tax deductions)
        double mondayFraction = mondaySalesWTax / totalTill;
        System.out.println(
                "#8. What fraction of total sales does Monday represent?  \t" + percent.format(mondayFraction));

        // money set aside for wholesales
        double wsCones = totalCones * 0.04;
        double wsVanilla = vanilla * 0.11;
        double wsChoc = choc * 0.09;
        double wsSwirl = swirl * 0.10;

        double wholesaleCost = wsCones + wsVanilla + wsChoc + wsSwirl;
        System.out.println("#9. Money set aside to pay the wholesales:   \t" + money.format(wholesaleCost));

        // profit after wholesales and taxes
        double profit = totalTill - totalTax - wholesaleCost;
        System.out.println("#10. Profit after paying wholesalers and taxes:  " + money.format(profit));

        // array holding # of hours open each day
        double totalHours = 0;
        double[] hoursOpen = { 8, 9, 9, 9, 9, 12.5, 14.5 };
        for (int i = 0; i < hoursOpen.length; i++) {
            totalHours += hoursOpen[i];
        }
        System.out.println("#11. Hours per week store is open:    \t\t" + totalHours);

        // profit per hour
        double profitHour = profit / totalHours;
        System.out.println("#12. Profit we make per hour open:   \t\t" + money.format(profitHour));

        // 75% of profit goes to pay for labor -- how much to pay our help
        double labor = (profit * 0.75) / totalHours;
        System.out
                .println("#13. 75% profit to pay workers, how much to pay workers per hour?   " + money.format(labor));

        // VA's min wage of $7.25 can we afford to hire
        int virginia = (int) (labor / 7.25);
        System.out.println("#14. People at Virginia's $7.25 rate we can afford to hire: \t" + virginia);

        // Maryland rate of $9.25 we can afford to hire
        int maryland = (int) (labor / 9.25);
        System.out.println("#15. People at Maryland's $9.25 rate can afford to hire: \t" + maryland);

        // DC's rate of $11.50 we can afford to hire
        int dc = (int) (labor / 11.50);
        System.out.println("#16. People at DC's $11.50 rate we can afford to hire: \t\t" + dc);

        // rate of $15 an hour
        int rateOf15 = (int) (labor / 15.00);
        System.out.println("#17. Rate of $15, we can afford to hire:  \t\t\t" + rateOf15);
    }
}
