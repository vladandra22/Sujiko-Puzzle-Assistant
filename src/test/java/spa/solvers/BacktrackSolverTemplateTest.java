package spa.solvers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import spa.model.SujikoGrid;
import spa.model.SujikoPuzzle;

/**
 * Test cases for {@link BacktrackSolverTemplate}.
 *
 */
public class BacktrackSolverTemplateTest {

    private SujikoPuzzle puzzle;
    private SujikoGrid grid;

    /**
     * Todo add javadoc.
     */
    @BeforeEach
    public void setUp() {
        String startGrid = "0 4 0\n" 
                + "0 0 2\n" 
                + "3 0 0\n" 
                + "18 18 19 26";
        puzzle = new SujikoPuzzle(new Scanner(startGrid), "Test");
        grid = puzzle.getGrid();
    }

    /**
     * Test of solve method, of class BacktrackSolverTemplate.
     */
    @Test
    public void testSolveWithoutReasoner() {
        System.out.println("solve w/o reasoner");
        BacktrackSolverTemplate instance = new ConcreteSujikoSolver(grid, null);
        boolean expResult = true;
        System.out.println(grid.toString());
        boolean result = instance.solve();
        System.out.println(grid.toString());
        assertAll(
                () -> assertEquals(expResult, result, "return value"),
                () -> assertTrue(instance.isSolved(), "puzzle solved"),
                () -> assertEquals(6, instance.getCommands().size(), "commands size")
        );
    }
}
