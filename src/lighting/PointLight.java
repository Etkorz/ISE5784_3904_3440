package lighting;

import primitives.*;

public class PointLight extends Light implements LightSource{

    private Point position;
    private double kC=1;
    private double kL=0;
    private double kQ=0;

    /**
     * Constructs a `PointLight` object with the specified intensity and position.
     *
     * @param intensity The color and intensity of the light source.
     * @param position The 3D position of the point light source in space.
     */
    public PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
    }

    /**
     * Sets the constant attenuation factor for this `PointLight`.
     *
     * @param kC The constant attenuation factor (non-negative value).
     * @return This `PointLight` object (for method chaining).
     */
    public PointLight setkC(double kC) {
        this.kC = kC;
        return this;
    }

    /**
     * Sets the linear attenuation factor for this `PointLight`.
     *
     * @param kL The linear attenuation factor (non-negative value).
     * @return This `PointLight` object (for method chaining).
     */
    public PointLight setkL(double kL) {
        this.kL = kL;
        return this;
    }

    /**
     * Sets the quadratic attenuation factor for this `PointLight`.
     *
     * @param kQ The quadratic attenuation factor (non-negative value).
     * @return This `PointLight` object (for method chaining).
     */
    public PointLight setkQ(double kQ) {
        this.kQ = kQ;
        return this;
    }

    /**
     * Calculates the intensity of the point light at a given point in space.
     *
     * The intensity of the light considers factors like the light's base intensity, constant attenuation,
     * linear attenuation, and quadratic attenuation.
     *
     * @param p The point in space where the light intensity is calculated.
     * @return The color representing the light intensity at the point.
     */
    @Override
    public Color getIntensity(Point p){
        double dist = position.distance(p);
        return getIntensity().scale(1/kC+kL*dist+kQ*kQ*dist);
    }

    /**
     * Calculates the direction vector from the point light source to a given point.
     *
     * This method provides the direction of the light rays emitted from the point light
     * towards the specified point in space.
     *
     * @param p The point in space relative to which the light direction is calculated.
     * @return The normalized direction vector pointing from the light source to the point.
     */
    @Override
    public Vector getL(Point p){
        return p.subtract(this.position).normalize();
    }
}
