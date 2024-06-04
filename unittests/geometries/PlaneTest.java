package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
//
// import static primitives.Util.isZero;

/**
 * Test Plane
 *
 * @author Gitty Shapira and Eti Kenig
 */
class PlaneTest {

    /**
     * Test method for
     * {@link geometries.Plane#Plane(Point, Point, Point)}.
     */
    @Test
    void testConstructor() {

        // =============== Boundary Values Tests ==================
        //TC01 first and second point are the same
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(1, 0, 0), new Point(1, 0, 0), new Point(0, 0, 0)),
                "Point1 and Point2 are the same"
        );

        //TC02 three points on one line
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(1, 0, 0), new Point(2, 0, 0), new Point(6, 0, 0)),
                "all three points on one line"
        );
    }

    /**
     * Test method for
     * {@link Plane#getNormal(Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        //TC01 simple test
        Plane pl = new Plane(
                new Point(1, 0, 0),
                new Point(0, 1, 0),
                new Point(0, 0, 1)
        );

        // sqrt3 = Math.sqrt(1d/3);
        Vector v1 = new Vector(1, 1, 1).normalize();
        Vector v1Opposite = v1.scale(-1).normalize();

        Vector result = pl.getNormal(new Point(0, 0, 1));
        assertTrue(result.equals(v1) || result.equals(v1Opposite),
                "not good normal for plane"
        );
    }

    @Test
    void testFindIntersections() {
    }
}