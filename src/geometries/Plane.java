package geometries;

import primitives.Vector;
import primitives.Point;
/**
 * Plain class represents two-dimensional plain in 3D Cartesian coordinate
 * system
 * @author Eti Kenig and Gitty Shapira
 */
public class Plane implements Geometry {

    private final Point q;
    private final Vector normal;

    /**
     * constructor plane from 3 points
     * @param v0
     * @param v1
     * @param v2
     */
    public Plane(Point v0, Point v1, Point v2){
        Vector vector1=v0.subtract(v1);//vector between v0 to v1
        Vector vector2=v1.subtract(v2);// vector between v1 to v2
        this.normal = vector1.crossProduct(vector2).normalize();
        this.q = v0;
    }

    /**
     * constructor
     * @param q
     * @param normal
     */
    public Plane(Point q, Vector normal) {
        this.q = q;
        this.normal = normal.normalize();
    }

    /**
     * getter for normal
     * @return vector normal to the plane
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     *calculates and return normal
     * @param point
     * @return vector normal to the plane
     */
    @Override
    public Vector getNormal(Point point) {
        return normal;
    }

}
