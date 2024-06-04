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
        Vector v1 = new Vector(1, 1, 1).normalize();
        Vector v1Opposite = v1.scale(-1).normalize();
        //Vector result=t1.getNormal(new Point(0,0,1));
        assertTrue(v1.equals(t1.getNormal(new Point(0, 0, 1))) ||
                        v1Opposite.equals(t1.getNormal(new Point(0, 0, 1))),
                "not good normal for Triangle"
        );
    }
}