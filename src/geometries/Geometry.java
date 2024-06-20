package geometries;
import primitives.Point;
import primitives.Vector;
/**
 * Geometry interface represents a geometric body
 * @author Eti Kenig and Gitty Shapira
 */
public interface Geometry extends Intersectable {
    /**
     * @param point
     * @return
     */
    public Vector getNormal(Point point);
}
