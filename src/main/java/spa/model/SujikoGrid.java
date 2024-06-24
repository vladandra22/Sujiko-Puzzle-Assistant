
package spa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implement SujikoGrid using Singleton Design pattern.
 * @author Andra, Rares, Dimitrie, Mihnea
 */
public class SujikoGrid {
    private static SujikoGrid instance = null;
    
    /** The grid of cells as a list of rows. */
    private List<List<DigitCell>> matrix;
    
    /** The sum cells. */
    private List<SumCell> sumCells;
    
    
    private SujikoGrid() {
        matrix = new ArrayList<>();
        sumCells = new ArrayList<>();
    }
    
    /**
     * Retrieves the singleton instance of the SujikoGrid class.
     *
     * @return The singleton instance of SujikoGrid.
     */
    public static SujikoGrid getInstance() {
        if (instance == null) {
            instance = new SujikoGrid();
        }
        return instance;
    }
    
    /**
     * Clears the singleton instance of the SujikoGrid class.
     */
    public void clearInstance() {
        instance = null;
    }
    
    /**
     * Reads the Sujiko puzzle grid from the given scanner.
     *
     * @param scanner The Scanner used to read the puzzle grid.
     */
    public void readGrid(final Scanner scanner) {
        for (int i = 0; i < 3; i++) {
            String[] digitValues = scanner.nextLine().split(" ");
            List<DigitCell> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int digitValue = Integer.parseInt(digitValues[j]);
                Location cellLocation = new Location(i, j);
                DigitCell cell = new DigitCell(cellLocation, digitValue);
                cell.setBlocked(!cell.isEmpty());
                row.add(cell);
            }
            matrix.add(row);
        }
        String[] sums = scanner.nextLine().split(" ");
        for (int i = 0; i < 4; i++) {
            int sumValue = Integer.parseInt(sums[i]);
            SumCell sumCell = new SumCell(i + 1, sumValue);
            sumCells.add(sumCell);
        }
        scanner.close();
    }
    
    /**
     * Returns a string representation of the matrix and sum cells.
     *
     * This method generates a string representation of the matrix and the sum cells
     * contained in the object. Each row of the matrix is represented as a space-separated
     * sequence of digits, and each sum cell is represented as its sum value.
     * The rows are separated by newline characters.
     *
     * @return A string representation of the matrix and sum cells.
     */
    @Override
    public String toString() {
        String s = "";
        for (List<DigitCell> row : this.matrix) {
            for (DigitCell cell : row) {
                s += String.valueOf(cell.getDigit()) + " ";
            }
            s += "\n";
        }
        System.out.println("");
        for (SumCell sumCell : this.sumCells) {
            s += String.valueOf(sumCell.getSum()) + " ";
        }
        s += "\n";
        return s;
    }
    
    /**
     * Sets the digit value for the cell at the specified location.
     *
     * @param location The location of the cell to be set.
     * @param digit    The digit value to be set.
     */
    public void setCell(Location location, int digit) {
        int row = location.getRow();
        int col = location.getColumn();
        List<DigitCell> targetRow = matrix.get(row);
        DigitCell newCell = new DigitCell(location, digit);
        targetRow.set(col, newCell);
    }
    
    /**
     * Retrieves the DigitCell at the specified location.
     *
     * @param location The location of the DigitCell to be retrieved.
     * @return The DigitCell at the specified location.
     */
    public DigitCell getCell(Location location) {
        int row = location.getRow();
        int col = location.getColumn();
        List<DigitCell> targetRow = matrix.get(row);
        return targetRow.get(col);
    }
    
    public List<List<DigitCell>> getCells() {
        return matrix;
    }
    
    public List<SumCell> getSumCells() {
        return sumCells;
    }
    
    /**
     * Checks if the specified indices are within the bounds of the grid.
     *
     * @param rowIndex    The row index to check.
     * @param columnIndex The column index to check.
     * @return true if the indices are within bounds, false otherwise.
     */
    public boolean has(int rowIndex, int columnIndex) {
        return 0 <= rowIndex && rowIndex < 3
                && 0 <= columnIndex && columnIndex < 3;
    }
       
    /**
     * Clears the non-blocked cells in the Sujiko grid.
     */
    public void clear() {
        for (List<DigitCell> row : this.matrix) {
            for (DigitCell cell : row) {
                if (!cell.getBlocked()) {
                    cell.clear();
                }
            }
        }
    }
}
