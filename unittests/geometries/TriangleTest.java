package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Triangles
 *
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

        assertTrue(v1.equals(t1.getNormal(new Point(0, 0, 1))) ||
                        v1Opposite.equals(t1.getNormal(new Point(0, 0, 1))),
                "not good normal for Triangle"
        );
    }

    @Test
    void testFindIntersections() {
        Triangle tr = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
        Plane pl = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
        Ray ray;

        // ============ Equivalence Partitions Tests ==============
        // TC01: Intersection point inside triangle
        ray = new Ray(new Point(1, 1, 1), new Vector(-1, -1, -1));
        assertEquals(List.of(new Point(1d / 3, 1d / 3, 1d / 3)), tr.findIntersections(ray), "Bad intersection");

        // TC02: Intersection point outside triangle
        ray = new Ray(new Point(0, 0, -1), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(1, 1, -1)), pl.findIntersections(ray), "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC03: Intersection point outside triangle and against vertex
        ray = new Ray(new Point(0, 0, 2), new Vector(-1, -1, 0));
        assertEquals(List.of(new Point(-0.5, -0.5, 2)), pl.findIntersections(ray), "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // =============== Boundary Values Tests ==================
        // TC11: Intersection point on vertex
        ray = new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0, 1, 0)), pl.findIntersections(ray), "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC12: Intersection point on edge
        ray = new Ray(new Point(-1, -1, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0.5, 0.5, 0)), pl.findIntersections(ray), "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC13: Intersection point on edge continuation
        ray = new Ray(new Point(-2, 0, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(-0.5, 1.5, 0)), pl.findIntersections(ray), "Wrong intersection with plane");
        assertNull(tr.findIntersections(ray), "Bad intersection");

    }
}