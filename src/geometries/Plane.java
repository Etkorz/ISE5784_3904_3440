package geometries;

import primitives.Double3;
import primitives.Ray;
import primitives.Vector;
import primitives.Point;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Plain class represents two-dimensional plain in 3D Cartesian coordinate
 * system
 *
 * @author Eti Kenig and Gitty Shapira
 */
public class Plane implements Geometry {

    private final Point q;
    private final Vector normal;

    /**
     * constructor plane from 3 points
     *
     * @param v0 point v0
     * @param v1 point v1
     * @param v2 point v2
     */
    public Plane(Point v0, Point v1, Point v2) {
        Vector vector1 = v0.subtract(v1);//vector between v0 to v1
        Vector vector2 = v1.subtract(v2);// vector between v1 to v2
        this.normal = vector1.crossProduct(vector2).normalize();
        this.q = v0;
    }

    /**
     * constructor
     *
     * @param q      point in the meddle of the camara
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
     * calculates and return normal
     *
     * @param point {@link Point} external to the shape
     * @return vector normal to the plane
     */
    @Override
    public Vector getNormal(Point point) {
        return normal;
    }

    /**
     * calculates and returns the intersection points between the ray and plane
     *
     * @param ray
     * @return list of intersection points
     */
    @Override
    public List<Point> findIntersections(Ray ray) {

        Point P0 = ray.getHead();
        Vector v = ray.getDirection();
        Vector n = normal;

        double nv = n.dotProduct(v);

        // If the ray parallel to the plane - there are no intersections
        if (isZero(nv)) {
            return null;
        }

        // If the p0 is the reference point - there are no intersections
        if (q.equals(P0)) {
            return null;
        }

        // Calculate the intersection point
        Vector QP0 = q.subtract(ray.getHead());
        double numer = normal.dotProduct(QP0);
        double t = alignZero(numer / nv);

        // If the intersection point is behind the origin of the ray, there are no intersections
        if (t <= 0)
            return null;

        ;
        // If t>0 the ray intersects the plane
        if (t > 0) {
            return List.of(P0.add(v.scale(t)));
        }

        // Else - there are no intersections
        return null;

    }

}

