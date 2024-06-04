package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Cylinder class represents three-dimensional Cylinder in 3D Cartesian coordinate
 * system
 * @author Eti Kenig and Gitty Shapira
 */
public class Cylinder extends Tube{

    private final double height;

    /**
     * constructor
     * @param axis
     * @param radius
     * @param height
     */
    public Cylinder(Ray axis, double radius, double height) {
        super(axis, radius);
        this.height = height;
    }

    public Vector getNormal(Point point) {
        return null;
    }
}
