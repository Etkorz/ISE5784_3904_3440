package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Plain class represents two-dimensional plain in 3D Cartesian coordinate
 * system
 *
 * @author Eti Kenig and Gitty Shapira
 */
public class Plane extends Geometry {

    private final Point q;
    private final Vector normal;

    /**
     * constructor to initialize Plane according to 3 given Points on the Plane
     *
     * @param point1
     * @param point2
     * @param point3
     */
    public Plane(Point point1, Point point2, Point point3) {
        this.q = point1;
        if (point1.equals(point2) || point2.equals(point3) || point3.equals(point1))
            throw new IllegalArgumentException("Two of the three points are identical");

        Vector vector1 = point1.subtract(point2); // vector between point1 and point2
        Vector vector2 = point2.subtract(point3); // vector between point2 and point3

        if (vector1.normalize().equals(vector2.normalize()))
            throw new IllegalArgumentException("all three points are on one line");

        // a vector that is orthogonal to two vectors on the plane is orthogonal to the plane.
        this.normal = vector1.crossProduct(vector2).normalize();
    }

    /**
     * constructor to initialize plane with point and normal
     *
     * @param q      point in the middle of the camara
     * @param normal vector of the normal (normalized automatic)
     */
    public Plane(Point q, Vector normal) {
        this.q = q;
        this.normal = normal.normalize();
    }

    /**
     * getter for normal
     *
     * @return vector normal to the plane
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     * getter for normal
     *
     * @param point {@link Point} external to the shape
     * @return vector normal to the plane
     */
    @Override
    public Vector getNormal(Point point) {
        return this.getNormal();
    }

    /**
     * calculates and returns the intersection points between the ray and plane
     *
     * @param ray
     * @return
     */
    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        Point P0 = ray.getHead();
        Vector v = ray.getDirection();
        Vector n = normal;

        double nv = n.dotProduct((v));

        // If the ray parallel to the plane - there are no intersections
        if (isZero(nv)) {
            return null;
        }

        // If the p0 is the reference point - there are no intersections
        if (q.equals(P0)) {
            return null;
        }

        double numerator = n.dotProduct(q.subtract(P0)); // numerator = n*Q0P0

        // In this case P0 is on the plane - there are no intersections
        if (isZero(numerator)) {
            return null;
        }
        double t = alignZero(numerator / nv); // t = numerator/nv

        Point intersectionPoint = ray.getPoint(t);

        // If t>0 the ray intersects the plane
        if (t > 0) {
            return List.of(new Intersectable.GeoPoint(intersectionPoint, this));
        }

        // Else - there are no intersections
        return null;
    }

}

