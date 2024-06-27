package primitives;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void testFindClosestPoint() {
        Ray ray = new Ray(new Point(-1, 0, 0), new Vector(0, 0, 2));

        // ============ Equivalence Partitions Tests ==============
        // TC01: The closest Point is in the middle of the list
        assertEquals(new Point(-1, 0, 1),
                ray.findClosestPoint(
                        List.of(new Point(-1, 0, 3),
                                new Point(-1, 0, 1),
                                new Point(-1, 0, 5))),
                "failed to find the closest point");

        // =============== Boundary Values Tests ==================
        // TC02: Empty List
        assertNull(ray.findClosestPoint(List.of()));

        // TC03: The first Point in the list is the closest
        assertEquals(new Point(-1, 0, 1),
                ray.findClosestPoint(
                        List.of(new Point(-1, 0, 1),
                                new Point(-1, 0, 3),
                                new Point(-1, 0, 5))),
                "failed to recognize the first Point as the closest");

        // TC04: The last Point in the list is the closest
        assertEquals(new Point(-1, 0, 1),
                ray.findClosestPoint(
                        List.of(new Point(-1, 0, 3),
                                new Point(-1, 0, 5),
                                new Point(-1, 0, 1))),
                "failed to recognize the last Point as the closest");
    }
}