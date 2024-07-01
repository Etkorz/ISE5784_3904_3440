package lighting;


import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 *LightSource class represents a light source in the scene
 */
public interface LightSource {

    /**
     * Calculates the intensity of the ambient light at a given point.
     *
     * For an `AmbientLight`, the intensity is typically constant throughout the scene and doesn't depend on the position of the point.
     *
     * @param p The point to calculate the intensity at.
     * @return The ambient light intensity as a `Color` object.
     */
    public Color getIntensity(Point p);

    /**
     * Calculates the direction of the ambient light at a given point.
     *
     * Since ambient light is typically considered uniform and doesn't have a specific direction, this method might always return a specific default direction vector.
     *
     * @param p The point (ignored for ambient light).
     * @return The direction vector of the ambient light.
     */
    public Vector getL(Point p);

}
