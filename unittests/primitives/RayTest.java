package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    @Test
    void testGetPoint() {

        // ============ Equivalence Partitions Tests ==============
        // TC01 for negative distance
        Ray rayNegative = new Ray(new Point(2, 2, 2), new Vector(1, 0, 0));
        Point pointNegative = rayNegative.getPoint(-3);
        assertEquals(new Point(-1, 2, 2), pointNegative, "Negative distance test failed");

        // TC02 for positive distance
        Ray rayPositive = new Ray(new Point(2, 2, 2), new Vector(1, 0, 0));
        Point pointPositive = rayPositive.getPoint(5);
        assertEquals(new Point(7, 2, 2), pointPositive, "Positive distance test failed");

        // =============== Boundary Values Tests ==================
        // TC03 for zero distance
        Ray rayZero = new Ray(new Point(2, 2, 2), new Vector(1, 0, 0));
        Point pointZero = rayZero.getPoint(0);
        assertEquals(new Point(2, 2, 2), pointZero, "Zero distance test failed");
    }
}