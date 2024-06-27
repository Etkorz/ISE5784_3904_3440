package primitives;

import java.util.Objects;

/**
 * Represents a point in three-dimensional space.
 *
 * @author Eti Kenig and Gitty Shapira
 */
public class Point {
    /**
     * A constant representing the origin (0, 0, 0).
     */
    public static final Point ZERO = new Point(Double3.ZERO);

    final Double3 xyz; // Coordinates of the point

    /**
     * Constructs a Point with the specified x, y, and z coordinates.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @param z The z-coordinate of the point.
     */
    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    /**
     * Constructs a Point with the specified Double3 object.
     *
     * @param xyz The Double3 object representing the coordinates of the point.
     */
    public Point(Double3 xyz) {
        this.xyz = xyz;
    }

    /**
     * Computes the vector from this point to another point.
     *
     * @param p1 The point to subtract from this point.
     * @return The vector pointing from this point to the other point.
     */
    public Vector subtract(Point p1) {
        return new Vector(this.xyz.subtract(p1.xyz));
    }

    /**
     * Computes the point obtained by adding a vector to this point.
     *
     * @param v1 The vector to add to this point.
     * @return The point resulting from adding the vector to this point.
     */
    public Point add(Vector v1) {
        return new Point(this.xyz.add(v1.xyz));
    }

    /**
     * Computes the Euclidean distance between this point and another point.
     *
     * @param p1 The other point.
     * @return The distance between this point and the other point.
     */
    public double distance(Point p1) {
        return Math.sqrt(this.distanceSquared(p1));
    }

    /**
     * Computes the squared Euclidean distance between this point and another point.
     *
     * @param p1 The other point.
     * @return The squared distance between this point and the other point.
     */
    public double distanceSquared(Point p1) {
        double dx = this.xyz.d1 - p1.xyz.d1;
        double dy = this.xyz.d2 - p1.xyz.d2;
        double dz = this.xyz.d3 - p1.xyz.d3;

        // Squared distance formula (L2 norm) in 3D
        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * Checks if this Point is equal to another object.
     *
     * @param o The object to compare with this Point.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return Objects.equals(xyz, point.xyz);
    }

    /**
     * Returns a string representation of this Point.
     *
     * @return A string representation of this Point.
     */
    @Override
    public String toString() {
        return "Point{" +
                "xyz=" + xyz +
                '}';
    }

    /**
     * @return the value of x-axis
     */
    public double getX() {
        return xyz.d1;
    }

    /**
     * @return the value of y-axis
     */
    public double getY() {
        return xyz.d2;
    }

    /**
     * @return the value of z-axis
     */
    public double getZ() {
        return xyz.d3;
    }
}

