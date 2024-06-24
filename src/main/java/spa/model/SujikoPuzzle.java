
package spa.model;

import java.util.List;
import java.util.Scanner;

/**
 * Represents a Sujiko puzzle, consisting of a SujikoGrid, a name, and a mode.
 * Allows creating, editing, and viewing Sujiko puzzles.
 * 
 * @author Andra, Rares, Dimitrie, Mihnea
 */
public class SujikoPuzzle {
    private final SujikoGrid grid;
    /** The puzzle's (file) name. */
    private String name;

    /** The possible modes of a puzzle. */
    public enum Mode {
        /** When puzzle can be edited. */
        EDIT,
        /** When puzzle can be solved, but not edited. */
        SOLVE,
        /** When puzzle can only be viewed, but not changed. */
        VIEW
    }

    /** The puzzle's mode. */
    private Mode mode;

    /**
     * Constructs a SujikoPuzzle with the given scanner and name.
     *
     * @param scanner The Scanner used to read the puzzle grid.
     * @param name    The name of the puzzle.
     */
    public SujikoPuzzle(final Scanner scanner, final String name) {
        this.name = name;
        this.mode = Mode.VIEW;
        this.grid = SujikoGrid.getInstance();
        grid.readGrid(scanner);
    }
    
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this puzzle.  Only allowed in edit mode.
     *
     * @param name  the new name
     * @throws IllegalStateException  if not in edit mode
     * @pre puzzle is in edit mode
     */
    public void setName(String name) {
        if (mode != Mode.EDIT) {
            throw new IllegalStateException(this.getClass().getSimpleName()
                    + ".setName(): not in EDIT mode");
        }
        this.name = name;
    }
    
    public static String makeEmptyDescriptor() {
        return "Undefined Sujiko puzzle state";
    }
    
    /**
     * Gets the current mode of this puzzle.
     *
     * @return mode of this
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Sets the mode of this puzzle.
     *
     * @param mode the new mode
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    
    /**
     * Gets the SujikoGrid associated with the puzzle.
     *
     * @return The SujikoGrid.
     */
    public SujikoGrid getGrid() {
        return this.grid;
    }
    
    /**
     * Returns a string representation of the SujikoPuzzle.
     *
     * @return A string representation of the puzzle.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<DigitCell> row : this.grid.getCells()) {
            for (DigitCell cell : row) {
                sb.append(String.valueOf(cell.getDigit())).append(" ");
            }
            sb.append("\n");
        }
        sb.append("Sums: ");
        for (SumCell sumCell : this.grid.getSumCells()) {
            sb.append(String.valueOf(sumCell.getSum())).append(" ");
        }
        return sb.toString();
    }
    
    public void clear() {
        grid.clear();
    }
    
}
