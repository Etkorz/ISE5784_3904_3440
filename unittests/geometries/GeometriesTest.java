package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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
        // TC01: some but not all geometries are cut (3 points)
        List<Point> result = geometries.findIntersections(new Ray(new Point(0,2,5),new Vector(0,0,-1)));
        assertEquals(3,result.size(),"Wrong number of points");


        // =============== Boundary Values Tests ==================
        //TC02:list of geometries are empty(0 points)
        Geometries geometries1=new Geometries();
        result= geometries1.findIntersections(new Ray(new Point(-1,0,0),new Vector(3,1,2)));
        assertNull(result,"list of geometries are empty");

        //TC03:there is no geometries are cut(0 points)
        result=geometries.findIntersections(new Ray(new Point(-4,6,2),new Vector(1,0,0)));
        assertNull(result,"there is no geometries are cut");

        //TC04:only one geometry is cut (2 points)
        result=geometries.findIntersections(new Ray(new Point(-4,0,2),new Vector(1,0,0)));
        assertEquals(2,result.size(),"only one geometry is cut");

        //TC05:all geometries are cut (4 points)
        result=geometries.findIntersections(new Ray(new Point(0,1d/2,5),new Vector(0,0,-1)));
        assertEquals(4,result.size(),"all geometries are cut");
    }
}