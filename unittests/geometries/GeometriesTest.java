package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTest {

    @Test
    void testFindIntersections() {
        //build list of geometries
        Sphere sphere= new Sphere(new Point(1,0,0),4.0);
        Triangle triangle=new Triangle(new Point(-1,0,0), new Point(1,0,0), new Point(0,1,0));
        Plane plane= new Plane(new Point(1,0,0),new Vector(0,0,1));
        Geometries geometries=new Geometries(sphere,triangle,plane);

        // ============ Equivalence Partitions Tests ==============
        // TC01: some but not all geometries cut (3 points)


        // =============== Boundary Values Tests ==================
        //TC02:
        //TC03:
        //TC04:
        //TC05:
    }
}