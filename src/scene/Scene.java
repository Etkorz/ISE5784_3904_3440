package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.Color;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    public String name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = AmbientLight.NONE;
    public Geometries geometries = new Geometries();
    public int softShade = 5;
    public List<LightSource> lights = new ArrayList<>();

    public Scene(String name) {
        this.name = name;
    }

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

    /**
     * Sets the list of light sources for this scene.
     *
     * @param lights The list of `LightSource` objects representing the light sources in the scene.
     * @return This `Scene` object (for method chaining).
     */
    public Scene setLights(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }

    public Scene setSoftShade(int shade){
        this.softShade=shade;
        return this;
    }

    public Color getBackground() {
        return background;
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public Geometries getGeometries() {
        return geometries;
    }

    public String getName() {
        return name;
    }

    public List<LightSource> getLights() {
        return lights;
    }
    public int getSoftShade() {return softShade;}
}
