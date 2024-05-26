package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Tube class represents three-dimensional Tube in 3D Cartesian coordinate
 * system
 * @author Eti Kenig and Gitty Shapira
 */
public class Tube extends RadialGeometry{
    final Ray axis;

    /**
     * constructor
     * @param axis
     * @param radius
     */
    public Tube(Ray axis, double radius) {
        super(radius);
        this.axis = axis;
    }

    @Override
    public Vector getNormal(Point point) {
        Vector v=axis.getDirection();
        Point p0=axis.getHead();

        //if vector between p0 to point is orthogonal to v(axis direction)
        if(!isZero(point.subtract(p0).dotProduct(v))){
            double t=v.dotProduct(point.subtract(p0));
            p0=p0.add(v.scale(t));
        }

        return point.subtract(p0).normalize();
    }
}
