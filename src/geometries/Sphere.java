package geometries;
import primitives.Point;
import primitives.Vector;

/**
 * Sphere class represents three-dimensional Sphere in 3D Cartesian coordinate
 * system
 * @author Eti Kenig and Gitty Shapira
 */
public class Sphere extends RadialGeometry{

    private final Point center;

    /**
     * constructor
     * @param radius
     * @param center
     */
    public Sphere(double radius, Point center) {
        super(radius);
        this.center = center;
    }

    /**
     * calculates and return normal
     * @param point
     * @return
     */
    @Override
    public Vector getNormal(Point point){
        Vector N=point.subtract(center);
        return N.normalize();
    }
}
