package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;


import java.util.List;

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

        assertTrue(v1.equals(t1.getNormal(new Point(0, 0, 1))) ||
                        v1Opposite.equals(t1.getNormal(new Point(0, 0, 1))),
                "not good normal for Triangle"
        );
    }

    @Test
    void testFindIntersections() {
        Triangle triangle=new Triangle(new Point(1,0,0),new Point(0,1,0),new Point(0,0,1));
        Plane plane=new Plane(new Point(1,0,0),new Point(0,1,0),new Point(0,0,1));
        List<Point> result;
        Point point=new Point(1,-1,-1);

        // ============ Equivalence Partitions Tests ==============
        //TC01 Intersection point Inside triangle(1 point)
        result= triangle.findIntersections(new Ray(new Point(-1,-1,-2),new Vector(1,1,2)));
        assertEquals(1, result.size(), "Wrong number of points");
        assertEquals(List.of(new Point(0,1,0)),
                result,
                "Intersection point Inside triangle");

        //TC02 Intersection point Outside triangle(0 points)
        assertNull(triangle.findIntersections(new Ray(point,new Vector(0,2,4))),
                "Intersection point Outside triangle");

        //TC03 Intersection point Outside triangle and against vertex(0 points)
        assertNull(triangle.findIntersections(new Ray(point,new Vector(-1,4,1))),
                "Intersection point Outside triangle and against vertex");


        // // =============== Boundary Values Tests ==================
        //** the ray begin before the plane
        //TC11 Intersection point on edge(0 points)
        assertNull(triangle.findIntersections(new Ray(point,new Vector(-1,3,1))),
                "Intersection point on edge");


        //TC12 Intersection point on vertex(0 points)
        assertNull(triangle.findIntersections(new Ray(point,new Vector(-2,1,1))),
                "Intersection point on vertex");


        //TC13 Intersection point on edge's continuation(0 points)
        assertNull(triangle.findIntersections(new Ray(point,new Vector(-4,1,1))),
                "Intersection point on edge's continuation");

    }
}