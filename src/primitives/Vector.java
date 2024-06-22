package primitives;

/**
 * Represents a vector in three-dimensional space.
 * @author Eti Kenig and Gitty Shapira
 */
public class Vector extends Point {

    /**
     * Constructs a Vector with the specified x, y, and z coordinates.
     *
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z-coordinate of the vector.
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        isVectorZero(this.xyz);
    }

    /**
     * Constructs a Vector with the specified Double3 object.
     *
     * @param xyz The Double3 object representing the coordinates of the vector.
     */
    public Vector(Double3 xyz) {
        super(xyz);
        isVectorZero(xyz);
    }

    /**
     * Checks if the given vector is zero.
     *
     * @param xyz The Double3 object representing the coordinates of the vector.
     * @throws IllegalArgumentException if the given vector is zero.
     */
    private void isVectorZero(Double3 xyz) {
        if (xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("The given vector is zero");
    }

    /**
     * Adds another vector to this vector and returns the result.
     *
     * @param v The vector to add.
     * @return The sum of this vector and the given vector.
     */
    @Override
    public Vector add(Vector v) {
        return new Vector(this.xyz.add(v.xyz));
    }

    /**
     * @param scalar The scalar value to multiply with.
     * @return The scaled vector.
     */
    public Vector scale(double scalar) {
        if (Util.isZero(scalar)) {
            throw new IllegalArgumentException("Cannot create zero vector");
        }
        return new Vector(this.xyz.scale(scalar));
    }

    /**
     * Calculates the dot product of this vector and the given vector.
     *
     * @param v3 The vector to compute the dot product with.
     * @return The dot product of the two vectors.
     */
    public double dotProduct(Vector v3) {
        return this.xyz.d1 * v3.xyz.d1 + this.xyz.d2 * v3.xyz.d2 + this.xyz.d3 * v3.xyz.d3;
    }

    /**
     * Calculates the cross product of this vector and the given vector.
     *
     * @param v2 The vector to compute the cross product with.
     * @return The cross product vector.
     */
    public Vector crossProduct(Vector v2) {
        double x = this.xyz.d2 * v2.xyz.d3 - this.xyz.d3 * v2.xyz.d2;
        double y = this.xyz.d3 * v2.xyz.d1 - this.xyz.d1 * v2.xyz.d3;
        double z = this.xyz.d1 * v2.xyz.d2 - this.xyz.d2 * v2.xyz.d1;
        return new Vector(x, y, z);
    }

    /**
     * Calculates the squared length of this vector.
     *
     * @return The squared length of this vector.
     */
    public double lengthSquared() {
        return this.dotProduct(this);
    }

    /**
     * Calculates the length of this vector.
     *
     * @return The length of this vector.
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * Returns a normalized version of this vector.
     *
     * @return The normalized vector.
     */
    public Vector normalize() {
        return new Vector(this.xyz.reduce(this.length()));
    }

    /**
     * Returns a string representation of this vector.
     *
     * @return A string representation of this vector.
     */
    @Override
    public String toString() {
        return "Vector{" +
                "xyz=" + xyz +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
