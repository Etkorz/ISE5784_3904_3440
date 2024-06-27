package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;

public class Scene {
    public String name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = AmbientLight.NONE;
    public Geometries geometries = new Geometries();

    public Scene(String name) { this.name = name; }

    // Method to set the background color and return the scene
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    // Method to set the ambient light and return the scene
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    // Method to set the geometries and return the scene
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
