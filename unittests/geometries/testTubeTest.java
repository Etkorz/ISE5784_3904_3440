package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Tubes
 * @author Gitty Shapira and Eti Kenig
 */
class testTubeTest {

    /**
     * Test method for
     * {@link Tube#getNormal(Point)}.
     */
    @Test
    void testGetNormal() {

        Tube tube=new Tube(new Ray(new Point(0,0,0),new Vector(0,0,1)),1);

        // ============ Equivalence Partitions Tests ==============
        // TC01 Simply test for Normal of Tube
        assertEquals(tube.getNormal(new Point(1,0,1)).normalize(),
                new Vector(1,0,0),
                "Normal is not orthogonal to the Tube"
        );

        // =============== Boundary Values Tests ==================
        //TC02 The Point is in front of the head fo the Ray
        assertEquals(tube.getNormal(new Point(1,0,0)).normalize(),
                new Vector(1,0,0),
                "The Point is in front of the head fo the Ray"
        );
    }
}