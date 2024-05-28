package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Spheres
 *
 * @author Gitty Shapira and Eti Kenig
 */
class SphereTest {

    /**
     * Test method for
     * {@link Sphere#getNormal(Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01 Simply test for Normal of Sphere
        Sphere sphere = new Sphere(new Point(0, 0, 0), 1.0);
        assertEquals(new Vector(0, 0, 1),
                sphere.getNormal(new Point(0, 0, 1)),
                "not good normal for Sphere"
        );
    }
}