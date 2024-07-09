package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

import static primitives.Util.alignZero;

public class SpotLight extends PointLight{


    private final Vector direction;

    /**
     * Constructs a `SpotLight` object with the specified intensity, position, and direction.
     *
     * A `SpotLight` is a type of point light that emits light in a cone-shaped region. The
     * `direction` vector defines the center of the light cone, while the light intensity falls off
     * outside this cone based on inner and outer cone angles (typically set using separate methods).
     *
     * @param intensity The color and intensity of the light source.
     * @param position The 3D position of the spot light source in space.
     * @param direction The normalized direction vector specifying the center of the light cone.
     */
    public SpotLight(Color intensity, Point position, Vector direction) {
        super(intensity, position);
        this.direction = direction.normalize();
    }

    /**
     * Sets the constant attenuation factor for this `SpotLight` and returns the modified `SpotLight` object.
     *
     * @param kC The constant attenuation factor (non-negative value).
     * @return This `SpotLight` object after setting the attenuation factor (for method chaining).
     */
    @Override
    public SpotLight setkC(double kC){
        return (SpotLight) super.setkC(kC);
    }

    /**
     * Sets the linear attenuation factor for this `SpotLight` and returns the modified `SpotLight` object.
     *
     * @param kL The linear attenuation factor (non-negative value).
     * @return This `SpotLight` object after setting the attenuation factor (for method chaining).
     */
    @Override
    public SpotLight setkL(double kL){
        return (SpotLight) super.setkL(kL);
    }

    /**
     * Sets the quadratic attenuation factor for this `SpotLight` and returns the modified `SpotLight` object.
     *
     * @param kQ The quadratic attenuation factor (non-negative value).
     * @return This `SpotLight` object after setting the attenuation factor (for method chaining).
     */
    @Override
    public SpotLight setkQ(double kQ){
        return (SpotLight) super.setkQ(kQ);
    }

    /**
     * Calculates the intensity of the spotlight at a given point in space, considering directionality.
     *
     * @param p The point in space where the light intensity is calculated.
     * @return The color representing the light intensity at the point, considering directionality.
     */
    @Override
    public Color getIntensity(Point p) {
       return super.getIntensity(p).scale(Math.max(0, direction.dotProduct(getL(p))));

    }

    /**
     * Returns the normalized direction vector from the point `p` to the light source.
     *
     * @param p The point from which to calculate the direction
     * @return The normalized direction vector
     */
    @Override
    public Vector getL(Point p) {
        return super.getL(p).normalize(); // Returns the direction from the point to the light source
    }
}
