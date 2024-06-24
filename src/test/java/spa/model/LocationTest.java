package spa.model;

import spa.model.Location;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for {@code Location}.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
 */
public class LocationTest {

    /**
     * Test of getRow method, of class Location.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Location instance = new Location(1, 2);
        int expResult = 1;
        int result = instance.getRow();
        assertEquals(expResult, result, "Result");
    }

    /**
     * Test of getColumn method, of class Location.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Location instance = new Location(1, 2);
        int expResult = 2;
        int result = instance.getColumn();
        assertEquals(expResult, result, "Result");
    }

    /**
     * Test of shortString method, of class Location.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Location instance = new Location(1, 2);
        String expResult = "b 2";
        String result = instance.toString();
        assertEquals(expResult, result, "Result");
    }

    /**
     * Test of toString method, of class Location.
     */
    @Test
    public void testToStringLong() {
        System.out.println("toStringLong");
        Location instance = new Location(1, 2);
        String expResult = "{ row: 1, column: 2 }";
        String result = instance.toStringLong();
        assertEquals(expResult, result, "Result");
    }

    /**
     * Test of Location(Scanner) constructor of class Location.
     */
    @Test
    public void testLocationScanner() {
        System.out.println("Location(Scanner)");
        String expResult = "b 2";
        Scanner scanner = new Scanner(expResult);
        Location instance = new Location(scanner);
        String result = instance.toString();
        assertEquals(expResult, result, "toString");

        expResult = "z10";
        instance = new Location(new Scanner(expResult));
        result = instance.toString();
        assertEquals(expResult, result, "toString");
    }

}
