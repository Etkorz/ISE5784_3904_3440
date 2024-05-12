package primitives;

import java.util.Objects;

/**
 * Represents a ray in three-dimensional space, defined by a starting point (head) and a direction vector.
 * @author Eti Kenig and Gitty Shapira
 */
public class Ray {
    final Point head; // Starting point of the ray
    final Vector direction; // Direction vector of the ray

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
}
