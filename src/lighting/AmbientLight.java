package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight extends Light {

    public static AmbientLight NONE = new AmbientLight(Color.BLACK, Double3.ZERO);

    /**
     * Constructs an `AmbientLight` object with the specified color and attenuation factor.
     *
     * @param ia The ambient light color.
     * @param ka The ambient light attenuation factor.
     */
    public AmbientLight(Color ia, Double3 ka) {

        super(ia.scale(ka));
    }

    /**
     * Constructs a new AmbientLight object with the given color and attenuation factor.
     * the constructor sets the intensity to be IA x kA
     *
     * @param IA the color of the ambient light
     * @param kA the attenuation factor for the light as a double value
     */
    public AmbientLight(Color IA, Double kA) {
        super(IA.scale(kA));
    }
}
