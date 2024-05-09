package geometries;

import primitives.Vector;
import primitives.Point;

public class Plane implements Geometry {

    private final Point q;
    private final Vector normal;

    public Plane(Point v0, Point v1, Point v3){
        this.normal = null;
        this.q = v0;
    }

    public Plane(Point q, Vector normal) {
        this.q = q;
        this.normal = normal.normalize();
    }

    public Vector getNormal() {
        return normal;
    }

    @Override
    public Vector getNormal(Point point) {
        return normal;
    }

}
