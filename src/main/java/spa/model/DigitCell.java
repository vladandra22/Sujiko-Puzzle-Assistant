
package spa.model;

import java.util.ArrayList;

/**
 * Represents a cell in the Sujiko puzzle grid containing a digit value.
 * Extends the SujikoCell class.
 * @author Andra, Rares, Dimitrie, Mihnea
 */
public class DigitCell extends SujikoCell {
    private Location location;
    private int digit;
    private ArrayList<Integer> groups;
    
    /**
     * Constructs a DigitCell with the specified location and digit value.
     *
     * @param location The location of the DigitCell.
     * @param digit    The digit value to be stored in the DigitCell.
     */
    public DigitCell(Location location, int digit) {
        this.location = location;
        this.digit = digit;
    }
    
    /**
     * Gets the digit value stored in the DigitCell.
     *
     * @return The digit value.
     */
    public int getDigit() {
        return this.digit;
    }
    
    /**
     * Sets the digit value for the DigitCell.
     *
     * @param digit The new digit value to be set.
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }
    
    /**
     * Clears the digit value in the DigitCell, setting it to 0.
     */
    public void clear() {
        this.setDigit(0);
    }
    
    /**
     * Gets the location of the DigitCell in the puzzle grid.
     *
     * @return The location of the DigitCell.
     */
    public Location getLocation() {
        return this.location;
    } 
    
    /**
     * Checks if the DigitCell is empty (digit value is 0).
     *
     * @return true if the DigitCell is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.digit == 0;
    }
    
    /**
     * Converts the DigitCell's digit value to a string.
     *
     * @return The string representation of the digit value.
     */
    public String toString() {
        return String.valueOf(this.digit);
    }
    
    /**
     * Checks if the DigitCell belongs to group 1.
     *
     * @return true if in group 1, false otherwise.
     */
    private boolean checkGroup1() {
        int row = this.location.getRow();
        int col = this.location.getColumn();
        return row <= 1 && col <= 1;
    }
    
    /**
     * Checks if the DigitCell belongs to group 2.
     *
     * @return true if in group 2, false otherwise.
     */
    private boolean checkGroup2() {
        int row = this.location.getRow();
        int col = this.location.getColumn();
        return row <= 1 && (col >= 1 && col <= 2);
    }
    
    /**
     * Checks if the DigitCell belongs to group 3.
     *
     * @return true if in group 3, false otherwise.
     */
    private boolean checkGroup3() {
        int row = this.location.getRow();
        int col = this.location.getColumn();
        return (row >= 1 && row <= 2) && col <= 1;
    }
    
    /**
     * Checks if the DigitCell belongs to group 4.
     *
     * @return true if in group 4, false otherwise.
     */
    private boolean checkGroup4() {
        int row = this.location.getRow();
        int col = this.location.getColumn();
        return (row >= 1 && row <= 2) && (col >= 1 && col <= 2);
    }
    
    /**
     * Determines the groups to which the DigitCell belongs based on its location.
     *
     * @return ArrayList of group numbers to which the DigitCell belongs.
     */
    public ArrayList<Integer> determineGroup() {
        this.groups = new ArrayList<>();
        if (checkGroup1()) {
            groups.add(1);
        }
        if (checkGroup2()) {
            groups.add(2);
        }
        if (checkGroup3()) {
            groups.add(3);
        }
        if (checkGroup4()) {
            groups.add(4);
        }
        return groups;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DigitCell cell = (DigitCell) obj;
        return this.getDigit() == cell.getDigit() 
                && this.getLocation().getRow() == cell.getLocation().getRow()
                && this.getLocation().getColumn() == cell.getLocation().getColumn();
    }
}
