package geometries;
/**
 * RadialGeometry class implements the interface Geometry
 * @author Eti Kenig and Gitty Shapira
 */
public abstract class RadialGeometry implements Geometry {
    final double radius;

    /**
     * @param radius
     */
    protected RadialGeometry(double radius) {
        this.radius = radius;
    }
}
