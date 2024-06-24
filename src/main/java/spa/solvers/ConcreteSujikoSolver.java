
package spa.solvers;

import java.util.ArrayList;
import java.util.List;
import spa.model.DigitCell;
import spa.model.Location;
import spa.model.SujikoGrid;
import spa.model.SumCell;
import spa.reasoning.Reasoner;

/**
 * Concrete implementation of the Sujiko puzzle solver using the Backtracking algorithm.
 * Extends the BacktrackSolverTemplate class.
 * 
 * @author Andra, Rares, Dimitrie, Mihnea
 */
public class ConcreteSujikoSolver extends BacktrackSolverTemplate { 

    /**
     * Constructs a ConcreteSujikoSolver with the given SujikoGrid and Reasoner.
     *
     * @param grid     The SujikoGrid to be solved.
     * @param reasoner The reasoner to be used for solving.
     */
    public ConcreteSujikoSolver(SujikoGrid grid, Reasoner reasoner) {
        super(grid, reasoner);
    }
    
    /**
     * Checks if placing a digit in the specified cell is a valid move.
     *
     * @param cell The DigitCell to be checked.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    protected boolean isValidMove(DigitCell cell) {
        if (!isUniqueInGrid(cell)) {
            return false;
        }
        return satisfiesCircles(cell);
    }
    
    /**
     * Checks if the Sujiko puzzle is solved.
     *
     * @return true if the puzzle is solved, false otherwise.
     */
    @Override
    protected boolean isSolved() {
        for (SumCell sumCell : this.grid.getSumCells()) {
            int sumForCell = 0;
            List<Location> locations = sumCell.getLocations();
            for (Location location : locations) {
                DigitCell cell = grid.getCell(location);
                int digit = cell.getDigit();
                sumForCell += digit;
            }
            if (sumForCell != sumCell.getSum()) {
                return false;
            }
        }
        return true;
    }
     
    /**
     * Checks if placing a digit in the specified cell makes it unique in the grid.
     *
     * @param cell The DigitCell to be checked.
     * @return true if the digit is unique in the grid, false otherwise.
     */
    protected boolean isUniqueInGrid(DigitCell cell) {
        int digit = cell.getDigit();
        for (List<DigitCell> row : grid.getCells()) {
            for (DigitCell matrixCell : row) {
                if (matrixCell.getLocation() != cell.getLocation() 
                        && matrixCell.getDigit() == digit) {
                    return false; 
                }
            }
        }
        return true;
    }
    
    /**
     * Checks if placing a digit in the specified cell satisfies the circles condition.
     *
     * @param cell The DigitCell to be checked.
     * @return true if the circles condition is satisfied, false otherwise.
     */
    protected boolean satisfiesCircles(DigitCell cell) {
        ArrayList<Integer> groupsCell = cell.determineGroup();
        for (SumCell sumCell : grid.getSumCells()) { 
            if (groupsCell.contains(sumCell.getGroup())) {
                if (!sumCell.canAchieveSum(cell.getDigit(), grid)) {
                    return false;
                }
            }
        }
        return true;
    }
}
