
package spa.model;

import java.util.Arrays;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@code SujikoCell}.
 * @author vladandra22
 */
public class SujikoCellTest {
    
    /**
     * Test constructor, getDigit().
     */
    @Test
    public void testConstructor() {
        String grid = "0 4 0\n" 
                + "0 0 2\n" 
                + "3 0 0\n" 
                + "18 18 19 26";
        SujikoGrid.getInstance().clearInstance();
        SujikoGrid instance = SujikoGrid.getInstance();
        instance.readGrid(new Scanner(grid));
        DigitCell expDigitCell = new DigitCell(new Location(2, 2), 0);
        SumCell expSumCell = new SumCell(4, 26);
        assertAll(
                () -> assertEquals(0, expDigitCell.getDigit(), "getDigit"),
                () -> assertEquals(26, expSumCell.getSum(), "getSum"),
                () -> assertEquals(true, expDigitCell.isEmpty(), "isEmpty")
        );
    }
    
    /**
     * Test DigitCell functionalities.
     */
    @Test
    public void testDigitCell() {
        String grid = "0 4 0\n" 
                + "0 0 2\n" 
                + "3 0 0\n" 
                + "18 18 19 26";
        SujikoGrid.getInstance().clearInstance();
        SujikoGrid instance = SujikoGrid.getInstance();
        instance.readGrid(new Scanner(grid));
        DigitCell expDigitCell = new DigitCell(new Location(2, 2), 0);
        assertAll(
                () -> assertEquals(new Location(2, 2), expDigitCell.getLocation(), "getLocation"),
                () -> assertEquals("0", expDigitCell.toString(), "toString"),
                () -> assertEquals(Arrays.asList(4), 
                        expDigitCell.determineGroup(), "determineGroup")
        );
    }
    
    /**
     * Test SujikoCell functionalities.
     */
    @Test 
    public void testSujikoCell() {
        String grid = "0 4 0\n" 
                + "0 0 2\n" 
                + "3 0 0\n" 
                + "18 18 19 26";
        SujikoGrid.getInstance().clearInstance();
        SujikoGrid instance = SujikoGrid.getInstance();
        instance.readGrid(new Scanner(grid));
        SumCell expSumCell = new SumCell(4, 26);
        assertAll(
                () -> assertEquals(false, expSumCell.isEmpty(), "isEmpty"),
                () -> assertEquals(true, expSumCell.canAchieveSum(1, instance), "canAchieveSum")
        );
    }
    
}
