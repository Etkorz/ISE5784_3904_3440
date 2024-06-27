package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GeometriesTest {

    @Test
    void testFindIntersections() {
        //build list of geometries

        Geometries geometries = new Geometries(
                new Sphere(
                        new Point(1, 0, 0), 1),
                new Triangle(
                        new Point(0, 2, 0),
                        new Point(2, 0, 0),
                        new Point(-2, 0, 0)
                ),
                new Plane(
                        new Point(2, 0, 0),
                        new Point(0, 2, 0),
                        new Point(0, 0, 2)
                )
        );

        // ============ Equivalence Partitions Tests ==============
        // TC01: some but not all geometries are cut (3 points)
        List<Point> result = geometries.findIntersections(new Ray(new Point(1, -2, 0.5), new Vector(0, 7, 1.5)));
        assertEquals(3, result.size(), "Wrong number of points");


        // =============== Boundary Values Tests ==================
        //TC02:list of geometries are empty(0 points)
        Geometries geometries1 = new Geometries();
        result = geometries1.findIntersections(new Ray(new Point(1, 0, 0), new Vector(2, 0, 0)));
        assertNull(result, "list of geometries are empty");

        //TC03:there is no geometries are cut(0 points)
        result = geometries.findIntersections(new Ray(new Point(1, -2, 0.5), new Vector(-5, 0, -0.5)));
        assertNull(result, "there is no geometries are cut");

        //TC04:only one geometry is cut (2 points)
        result = geometries.findIntersections(new Ray(new Point(1, -2, 0.5), new Vector(-1, -1, 5.5)));
        assertEquals(1, result.size(), "only one geometry is cut");

        //TC05:all geometries are cut (4 points)
        result = geometries.findIntersections(new Ray(new Point(-2, 0, -3), new Vector(6, 1, 6)));
        assertEquals(4, result.size(), "all geometries are cut");
    }

    @Test
    void testAdd() {
    }
}