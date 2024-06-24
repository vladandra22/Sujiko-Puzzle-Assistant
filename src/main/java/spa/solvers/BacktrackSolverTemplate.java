package spa.solvers;

import java.util.List;
import spa.command.Command;
import spa.command.SetCommand;
import spa.model.DigitCell;
import spa.model.Location;
import spa.model.SujikoGrid;
import spa.reasoning.Reasoner;

/**
 * A simple recursive backtracking solver for Kakuro Puzzles.
 * It uses puzzle.getMinNumber() and puzzle.getMaxNumber()
 * to obtain the range of `digits' to try in an empty cell.
 * <p>
 One reasoner strategy can be injected via the constructor.
 If null, it will be ignored; otherwise, it will be invoked
 before looking for an empty cell and trying all possible `digits'.
 <p>
 * It makes sense for client code to supply a fixpoint strategy.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
 */
public abstract class BacktrackSolverTemplate extends AbstractSolver {

    /** The strategy to apply before speculating; null if no reasoner. */
    protected Reasoner reasoner;

    /* Rep. invariant:
     *  reasoner != null ==> reasoner.puzzle == this.puzzle
     */

    /**
     * Constructs a backtracking solver for a given puzzle.
     *
     * @param grid the puzzle
     * @throws IllegalArgumentException  if {@code puzzle == null}
     * @pre {@code puzzle != null}
     */
    public BacktrackSolverTemplate(SujikoGrid grid, final Reasoner reasoner) {
        super(grid);
        this.reasoner = reasoner;
    }

// Auxiliary methods
    /**
     * Returns first empty cell, or null if no empty cells.
     * TODO: Could look for "better" empty cell.
     *
     * @return first empty cell, or null if no empty cells
     */
    protected DigitCell getEmptyCell() {
        for (final List<DigitCell> row : grid.getCells()) {
            for (final DigitCell cell : row) {
                if (cell.isEmpty()) {
                    return cell;
                }
            }
        }
        return null;
    }
    
     /*
    1. Puzzle is valid.
    2. Puzzle is solved.
    */

    protected abstract boolean isValidMove(DigitCell cell);
    
    protected abstract boolean isSolved();
      
    @Override
    public boolean solve() {
        DigitCell cell = getEmptyCell();
        if (cell == null) {
            return this.isSolved();
        } else {
            if (cell.isEmpty()) {
                for (int state = 1; state <= 9; state++) {
                    final Command command = new SetCommand(cell, state);
                    command.execute();     
                    if (this.isValidMove(cell)) {
                        commands.push(command);
                        if (solve()) {
                            return true;
                        }
                        commands.pop();
                    }  
                    command.revert();
                }
                return false;
            }
        }
        return true;
    }
}
