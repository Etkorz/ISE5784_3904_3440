package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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
        Point point1 = new Point(-1, 0, -2);
        Point point2 = new Point(-1, 0, 0);
        Plane plane = new Plane(new Point(-2, 0, 0), new Vector(0, 0, 2));
        // ============ Equivalence Partitions Tests ==============

        //TC01 Ray intersects the plane
        List<Point> result01= plane.findIntersections(new Ray(point1, new Vector(1,0,0)));
        assertEquals(1, result01.size(), "wrong number of intersections");
        assertEquals(List.of(new Point(-1, 2.25, 0)), result01, "Ray intersect the plane");

        //TC02 Ray does not intersect the plane
        assertNull(plane.findIntersections(new Ray(new Point(-1,0,2), new Vector(0, 9, 4))),
                "wrong number of intersections");

        // =============== Boundary Values Tests ==================
        // **** Group: Ray is parallel to the plane
        // TC03: ray is included in the plane
        assertNull(plane.findIntersections(new Ray(point2, new Vector(1, 0, 0))), "Ray is included in plane");
        // TC04: ray is not included in the plane
        assertNull(plane.findIntersections(new Ray(point1, new Vector(1, 0, 0))), "Ray is not included in plane");
        // **** Group: Ray is orthogonal to the plane
        //TC05: Ray starts before the plane
        List<Point>result02 = plane.findIntersections(new Ray(point1, new Vector(0, 0, 2)));
        assertEquals(1, result02.size(), "wrong number of points");
        assertEquals(List.of(point2), result02, "Ray starts before the plane");
        //TC06: Ray starts at the plane
        assertNull(plane.findIntersections(new Ray(point1, new Vector(0, 0, 2))), "Ray starts at the plane");
        //TC07: Ray starts after plane
        assertNull(plane.findIntersections(new Ray(new Point(-1, 0, 1), new Vector(0, 0, 1))), "Ray starts after the plane");
        // **** Group: special cases
        // TC08: Ray begins at the plane
        assertNull(plane.findIntersections(new Ray(point2, new Vector(1, 1, 1))),
                "Ray starts in plane and isn't orthogonal or parallel to the plane");
        // TC09: Ray begins in the same point that appears as the reference point of plane
        assertNull(plane.findIntersections(new Ray(new Point(-2, 0, 0), new Vector(1, 1, 1))), "Ray starts at Q0");

    }

}