
package spa.model;

import java.util.List;

/**
 * Represents a cell in the Sujiko puzzle grid that holds a sum value.
 * Extends the SujikoCell class.
 * 
 * @author Andra, Rares, Dimitrie, Mihnea
 */
public class SumCell extends SujikoCell {
    private int sum = 0;
    
    /**
     * Constructs a SumCell with the specified group and sum value.
     *
     * @param group The group to which the SumCell belongs.
     * @param sum   The sum value to be stored in the SumCell.
     */
    public SumCell(int group, int sum) {
        super(group);
        this.sum = sum;
    }
    
    /**
     * Checks if the SumCell is empty.
     *
     * @return true if the SumCell is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.sum == 0;
    }
    
    /**
     * Returns a string representation of the sum value.
     *
     * @return A string representation of the sum value.
     */
    public String toString() {
        return String.valueOf(this.sum);
    }
    
    /**
     * Sets a new sum value for the SumCell.
     *
     * @param sum The new sum value to be set.
     */
    public void setSum(int sum) {
        this.sum = sum;
    }
    
    /**
     * Gets the current sum value of the SumCell.
     *
     * @return The sum value of the SumCell.
     */
    public int getSum() {
        return this.sum;
    }
    
    /**
     * Determines if a given number can be placed in the SumCell's group such that 
     * the sum condition is satisfied.
     *
     * @param number The number to be checked.
     * @param grid   The SujikoGrid containing the puzzle.
     * @return true if the number can be placed to satisfy the sum condition, false otherwise.
     */
    public boolean canAchieveSum(int number, SujikoGrid grid) {
        int currSum = 0;
        int emptyCells = 0;
        boolean[] used = new boolean[10];
        List<Location> locations = this.getLocations();
        for (Location location : locations) {
            DigitCell cell = grid.getCell(location);
            if (cell.isEmpty()) {
                emptyCells++;
            } else {
                int digit = cell.getDigit();
                currSum += digit;
                used[digit] = true;
            }
        }
        
        int cpyEmptyCells = emptyCells;
        int minSum = 0;
        int maxSum = 0;
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                if (emptyCells > 0) {
                    minSum += i;
                    emptyCells--;
                } else {
                    break;
                }
            }
        }
       
        emptyCells = cpyEmptyCells;
        for (int i = 9; i >= 1; i--) {
            if (!used[i]) {
                if (emptyCells > 0) {
                    maxSum += i;
                    emptyCells--;
                } else {
                    break;
                }
            }
        }
        
        return currSum + minSum <= this.sum && this.sum <= currSum + maxSum;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SumCell cell = (SumCell) obj;
        return this.getSum() == cell.getSum()
                && this.getGroup() == cell.getGroup();
    }
}
