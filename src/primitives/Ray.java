package primitives;

import geometries.Intersectable.GeoPoint;

import java.util.List;
import java.util.Objects;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;


/**
 * Represents a ray in three-dimensional space, defined by a starting point (head) and a direction vector.
 *
 * @author Eti Kenig and Gitty Shapira
 */
public class Ray {
    final Point head; // Starting point of the ray
    final Vector direction; // Direction vector of the ray

    private static final double DELTA = 0.1;

    /**
     * Constructs a Ray with the specified head point and direction vector. The direction vector is normalized.
     *
     * @param head      The starting point of the ray.
     * @param direction The direction vector of the ray.
     */
    public Ray(Point head, Vector direction) {
        this.head = head;
        this.direction = direction.normalize();
    }


    /**
     * Constructs a Ray object with the given parameters.
     * The ray is defined by a starting point (head), a direction vector, and a surface normal vector.
     *
     * @param head The starting point of the ray as a Point object.
     * @param direction The direction vector of the ray as a Vector object.
     * @param normal The surface normal vector as a Vector object.
     */
    public Ray(Point head, Vector direction, Vector normal) {

        // Calculate the dot product between the surface normal and the direction vector of the ray
        double nv = alignZero(normal.dotProduct(direction));
        if(isZero(nv))
            this.head = head;
        else
            this.head = head.add(normal.scale(nv > 0 ? DELTA : -DELTA));
        this.direction= direction;
    }


    /**
     * Checks if this Ray is equal to another object.
     *
     * @param o The object to compare with this Ray.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray ray)) return false;
        return Objects.equals(head, ray.head) && Objects.equals(direction, ray.direction);
    }

    /**
     * Returns a string representation of this Ray.
     *
     * @return A string representation of this Ray.
     */
    @Override
    public String toString() {
        return "Ray{" +
                "head=" + head +
                ", direction=" + direction +
                '}';
    }

    /**
     * getter
     *
     * @return direction of ray
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * getter
     *
     * @return head the base point of ray
     */
    public Point getHead() {
        return head;
    }

    public Point getPoint(double t) {
        if (isZero(t))
            return head;
        return head.add(direction.scale(t));

    }

    /**
     * finds the closest point to ray's base point.
     *
     * @param points
     * @return
     */
    public Point findClosestPoint(List<Point> points) {
        return points == null || points.isEmpty() ? null
                : findClosestGeoPoint(points.stream().map(p -> new GeoPoint(p, null)).toList()).point;
    }

    public GeoPoint findClosestGeoPoint(List<GeoPoint> points) {
        GeoPoint closest = null;
        double closestDistance = Integer.MAX_VALUE;
        if (points == null || points.isEmpty())
            return null;
        for (GeoPoint point : points) {
            if (point.point.distanceSquared(head) < closestDistance) {
                closest = point;
                closestDistance = point.point.distanceSquared(head);
            }
        }
        return closest;
    }
}
