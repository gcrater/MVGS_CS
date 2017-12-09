package Ch6;

public class TwoDArray {

    public static void main(String[] args) {
        int[][] table = new int[5][10];

        // Load the table with values
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                table[row][col] = row * 10 + col;
            }
        }

        // Print table
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                System.out.print(table[row][col] + "\t");
            }
            System.out.println();
        }

    }

}
