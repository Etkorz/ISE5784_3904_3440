package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * An abstract class representing a basic Ray Tracer.
 * Contains the scene being traced and an abstract method for tracing a ray.
 *
 * @author Eti Kenig and Gitty Shapira
 */
public abstract class RayTracerBase {
    protected Scene scene;

    /**
     * Constructs a RayTracerBase object with the specified scene.
     *
     * @param scene
     */
    public RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * Traces the specified ray and returns the color of the closest intersection.
     *
     * @param ray
     * @return
     */
    public abstract Color traceRay(Ray ray);
}
