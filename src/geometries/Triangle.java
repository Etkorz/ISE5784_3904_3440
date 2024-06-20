package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.isZero;

public class Triangle extends Polygon {
    /**
     * Constructor that initialize the Triangle point
     *
     * @param p1 point p1
     * @param p2 point p2
     * @param p3 point p3
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    @Override
    public List<Point> findIntersections(Ray ray) {

        //get the head and direction of ray
        Point p0 = ray.getHead();
        Vector v = ray.getDirection();

        //get the vertices of the triangle
        Point p1 = vertices.get(0);
        Point p2 = vertices.get(1);
        Point p3 = vertices.get(2);

        //calculate the vector between the triangles vertices and ray
        Vector v1 = p1.subtract(p0);
        Vector v2 = p2.subtract(p0);
        Vector v3 = p3.subtract(p0);

        //normal the vector from above
        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v2.crossProduct(v3).normalize();
        Vector n3 = v3.crossProduct(v1).normalize();

        //calculate the dot products of the ray direction and the normal vector
        double nv1 = v.dotProduct(n1);//v*(v1Xv2)
        double nv2 = v.dotProduct(n2);//v*(v2Xv3)
        double nv3 = v.dotProduct(n3);//v*(v3Xv1)

        if (isZero(nv1) || isZero(nv2) || isZero(nv3))
            return null;

        if ((nv1 > 0 && nv2 > 0 && nv3 > 0) || (nv1 < 0 && nv2 < 0 && nv3 < 0))
            return plane.findIntersections(ray);

        return null;
    }
}
