package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for primitives.Point class
 *
 * @author Eti and Gitty
 */

class PointTest {
    public static final double DELTA = 0.00001;
    private Point p1 = new Point(1, 2, 3);
    private Point p2 = new Point(2, 4, 6);
    private Point p3 = new Point(2, 4, 5);


    /**
     * Test method for {@link primitives.Point#subtract(primitives.Point)}.
     */
    @Test
    void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        //TC01 check subtraction
        assertEquals(
                new Vector(1, 2, 3),
                p2.subtract(p1),
                "ERROR: (point2 - point1) does not work correctly"
        );
        // =============== Boundary Values Tests ==================
        //TC02 subtract the same point
        assertThrows(
                IllegalArgumentException.class,
                () -> p1.subtract(p1),
                "ERROR: (point - itself) does not throw an exception"
        );
    }

    /**
     * Test method for {@link primitives.Point#add(primitives.Vector)}.
     */
    @Test
    void testAdd() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-1, -2, -3);
        // ============ Equivalence Partitions Tests ==============
        assertEquals(p2, p1.add(v1), "ERROR: (point + vector) = other point does not work correctly");
        // =============== Boundary Values Tests ==================
        assertEquals(Point.ZERO, p1.add(v2), "ERROR: (point + vector) = center of coordinates does not work correctly");

    }

    /**
     * Test method for {@link primitives.Point#distance(primitives.Point)}.
     */
    @Test
    void testDistance() {
        // ============ Equivalence Partitions Tests ==============
        assertEquals(3, p1.distance(p3), DELTA, "ERROR: distance is wrong");
    }

    /**
     * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
     */
    @Test
    void testDistanceSquared() {
        // ============ Equivalence Partitions Tests ==============
        assertEquals(9,
                p1.distanceSquared(p3),
                DELTA,
                "ERROR: squared distance between points is wrong");
    }
}