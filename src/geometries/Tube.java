package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

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
        return null;
    }
}
