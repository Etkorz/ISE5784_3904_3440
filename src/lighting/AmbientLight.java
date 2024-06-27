package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {

    private final Color intensity;

    public static AmbientLight NONE = new AmbientLight(Color.BLACK, Double3.ZERO);

    public AmbientLight(Color ia, Double3 ka){
        this.intensity = ia.scale(ka);
    }

    public AmbientLight(Color ia, Double ka){
        this.intensity = ia.scale(ka);
    }

    public Color getIntensity(){ return this.intensity; }
}
