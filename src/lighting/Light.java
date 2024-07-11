package lighting;

import primitives.Color;

/**
 *
 */
abstract class Light {

    //the power of a light source
    protected Color intensity;

    /**
     * constructor
     *
     * @param intensity the intensity color
     */
    protected Light(Color intensity) {
        this.intensity = intensity;
    }

    /**
     * getter
     *
     * @return the intensity color
     */
    public Color getIntensity() {
        return intensity;
    }
}
