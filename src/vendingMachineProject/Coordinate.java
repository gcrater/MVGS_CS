package vendingMachineProject;

/**
 * Holds position/ID.
 * 
 * @author Gracie Crater
 * @date 5/1/2018
 */
public class Coordinate {

    private char row;
    private int col;

    public Coordinate(char row, int col) {

        this.row = row;
        this.col = col;
    }

    public char getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return row + String.valueOf(col);
    }

}
