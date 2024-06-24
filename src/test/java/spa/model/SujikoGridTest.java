package spa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for class {@code SujikoGrid}.
 * @author vladandra22
 */
public class SujikoGridTest {
    /**
     * Test constructor using Singleton pattern,
     * readGrid, toString, getCells, getSumCells, and has.
     */
    @Test
    public void testSujikoGrid() {
        System.out.println("Sujiko Grid Constructor");
        List<List<DigitCell>> expMatrix = new ArrayList<List<DigitCell>>();

        List<DigitCell> row1 = new ArrayList<DigitCell>();
        row1.add(new DigitCell(new Location(0, 0), 0));
        row1.add(new DigitCell(new Location(0, 1), 4));
        row1.add(new DigitCell(new Location(0, 2), 0));
        expMatrix.add(row1);

        List<DigitCell> row2 = new ArrayList<DigitCell>();
        row2.add(new DigitCell(new Location(1, 0), 0));
        row2.add(new DigitCell(new Location(1, 1), 0));
        row2.add(new DigitCell(new Location(1, 2), 2));
        expMatrix.add(row2);

        List<DigitCell> row3 = new ArrayList<DigitCell>();
        row3.add(new DigitCell(new Location(2, 0), 3));
        row3.add(new DigitCell(new Location(2, 1), 0));
        row3.add(new DigitCell(new Location(2, 2), 0));
        expMatrix.add(row3);
        
        List<SumCell> expSumCells = new ArrayList<SumCell>();
        expSumCells.add(new SumCell(1, 18));
        expSumCells.add(new SumCell(2, 18));
        expSumCells.add(new SumCell(3, 19));
        expSumCells.add(new SumCell(4, 26));
        
        String expResult = "0 4 0\n" 
                + "0 0 2\n" 
                + "3 0 0\n" 
                + "18 18 19 26";
        SujikoGrid.getInstance().clearInstance();
        SujikoGrid instance = SujikoGrid.getInstance();
        instance.readGrid(new Scanner(expResult));
        System.out.println(instance.toString());
        assertAll(
                () -> assertEquals(expMatrix, instance.getCells(), "getCells"),
                () -> assertEquals(expSumCells, instance.getSumCells(), "getSumCells"),
                () -> assertTrue(instance.has(2, 2), "has")
        );
    }
}
