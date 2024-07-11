package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {


    private final Vector direction;

    /**
     * Constructs a `DirectionalLight` object with the specified intensity and direction.
     *
     * @param intensity The color and intensity of the light source.
     * @param direction The normalized direction vector specifying the direction of the parallel light rays.
     */
    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction.normalize();
    }

    /**
     * Returns the light intensity for a given point, which is always the same for a directional light.
     *
     * @param p The point in space (ignored for directional lights).
     * @return The color representing the light intensity of the directional light.
     */
    @Override
    public Color getIntensity(Point p) {
        return getIntensity();
    }

    /**
     * Returns the direction vector of the parallel light rays emitted by this directional light.
     * <p>
     * param p The point in space (ignored for directional lights).
     *
     * @return The normalized direction vector representing the direction of the parallel light rays.
     */
    @Override
    public Vector getL(Point p) {
        return direction.normalize();
    }

    /**
     * Calculates the distance from the light source to a given point.
     *
     * @param p the point to calculate the distance to
     * @return the distance from the light source to the given point, always {@code Double.POSITIVE_INFINITY}
     */
    @Override
    public double getDistance(Point p) {
        return Double.POSITIVE_INFINITY;
    }
}

