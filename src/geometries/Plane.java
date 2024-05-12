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
     * constructor
     * @param v0
     * @param v1
     * @param v3
     */
    public Plane(Point v0, Point v1, Point v3){
        this.normal = null;
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
     * @return
     */
    public Vector getNormal() {
        return normal;
    }

    @Override
    public Vector getNormal(Point point) {
        return normal;
    }

}
