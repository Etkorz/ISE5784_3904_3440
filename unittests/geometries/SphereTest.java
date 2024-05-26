package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Spheres
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
        Sphere sph= new Sphere(1.0, new Point(0,0,0));
        assertEquals(new Vector(0,0,1),
                sph.getNormal(new Point(0,0,1)),
                "not good normal for Sphere"
        );
    }
}