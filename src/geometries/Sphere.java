package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;


import java.util.List;

import static java.lang.Math.sqrt;
import static primitives.Util.alignZero;

/**
 * Sphere class represents three-dimensional Sphere in 3D Cartesian coordinate
 * system
 *
 * @author Eti Kenig and Gitty Shapira
 */
public class Sphere extends RadialGeometry {

    private final Point center;

    /**
     * constructor
     *
     * @param center
     * @param radius
     */
    public Sphere(Point center, double radius) {
        super(radius);
        this.center = center;
    }

    /**
     * calculates and return normal
     *
     * @param point
     * @return
     */
    @Override
    public Vector getNormal(Point point) {
        return point.subtract(center).normalize();
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        //get the head and direction of ray
        Point p0 = ray.getHead();
        Vector v = ray.getDirection();

        //if the head is in the center, return the point where the ray exist the sphere
        if (center.equals(p0))
            return List.of(new GeoPoint(ray.getPoint(radius), this));

        //u=center-p0
        Vector u = center.subtract(p0);
        //tm=v*u
        double tm = alignZero(v.dotProduct(u));
        //d is the distance between tm to v
        double d = alignZero(sqrt(u.lengthSquared() - tm * tm));

        double th = alignZero(sqrt(radius * radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        // if there is no intersection between the ray and the sphere, return null
        if (d >= radius || t1 <= 0 && t2 <= 0)
            return null;

        // return both intersection points
        if (t1 > 0 && t2 > 0) {
            Point P1 = ray.getPoint(t1);
            Point P2 = ray.getPoint(t2);
            return List.of(new GeoPoint(P1, this), new GeoPoint(P2, this));
        }

        // if t1 is less than or equal to 0, return P2 as the intersection point
        if (t1 <= 0) {
            Point P2 = ray.getPoint(t2);
            return List.of(new GeoPoint(P2, this));
        }

        // if t2 is less than or equal to 0, return P1 as the intersection point
        if (t2 <= 0) {
            Point P1 = ray.getPoint(t1);
            return List.of(new GeoPoint(P1, this));
        }
        return null;
    }
}
