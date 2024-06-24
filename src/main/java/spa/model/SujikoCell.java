
package spa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Represents an abstract cell in the Sujiko puzzle grid.
 * Provides methods for accessing and modifying group information.
 * @author Andra, Rares, Dimitrie, Mihnea
 */
public abstract class SujikoCell {
    private int group;
    
    /** Whether the cell was read from the file or not. */
    private boolean blocked = false;
    
    /**
     * Default constructor for SujikoCell.
     */
    public SujikoCell() {}
    
    /**
     * Constructs a SujikoCell with the specified group.
     *
     * @param group The group to which the cell belongs.
     */
    public SujikoCell(int group) {
        this.group = group;
    }
    
    /**
     * Gets the group to which the cell belongs.
     *
     * @return The group number.
     */
    public int getGroup() {
        return this.group;
    }
    
    /**
     * Sets the group for the cell.
     *
     * @param group The new group number to be set.
     */
    public void setGroup(int group) {
        this.group = group;
    }
    
    /**
     * Checks if the cell is blocked, i.e., read from the file.
     *
     * @return true if the cell is blocked, false otherwise.
     */
    public boolean getBlocked() {
        return this.blocked;
    }
    
    /**
     * Sets the blocked status for the cell.
     *
     * @param blocked Whether the cell is blocked or not.
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    
    /**
    * Determines positions used by certain group.
    */
    public List<Location> getLocations() {
        switch (group) {
            case 1:
                return new ArrayList<>(Arrays.asList(new Location(0, 0), 
                        new Location(0, 1),
                        new Location(1, 0),
                        new Location(1, 1)));
            case 2:
                return new ArrayList<>(Arrays.asList(new Location(0, 1), 
                        new Location(0, 2),
                        new Location(1, 1),
                        new Location(1, 2)));
            case 3:
                return new ArrayList<>(Arrays.asList(new Location(1, 0), 
                        new Location(1, 1),
                        new Location(2, 0),
                        new Location(2, 1)));
            case 4:
                return new ArrayList<>(Arrays.asList(new Location(1, 1), 
                        new Location(1, 2),
                        new Location(2, 1),
                        new Location(2, 2)));
            default:
                // TODO add throw error here.
                return new ArrayList<>(); 
        }
    }
    
    public abstract boolean isEmpty();
}
