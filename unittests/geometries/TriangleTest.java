package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Triangles
 * @author Gitty Shapira and Eti Kenig
 */

class TriangleTest {

    /**
     * Test method for
     * {@link Triangle#getNormal(Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        //TC01 Simply test for Normal of Triangle
        Triangle t1 = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
        double sqrt3 = Math.sqrt(1d / 3);
        Vector v1 = new Vector(sqrt3, sqrt3, sqrt3);
        Vector v2 = new Vector(-sqrt3, -sqrt3, -sqrt3);
        //Vector result=t1.getNormal(new Point(0,0,1));
        assertTrue(v1.equals(t1.getNormal(new Point(0, 0, 1))) ||
                        v2.equals(t1.getNormal(new Point(0, 0, 1))),
                "not good normal for Triangle"
        );
    }
}