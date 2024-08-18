package renderer;
import primitives.Vector;
import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

import java.util.List;

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

    public abstract Color adaptiveSuperSamplingRec(Point centerP, double Width, double Height, double minWidth, double minHeight, Point cameraLoc, Vector Vright, Vector Vup, List<Point> prePoints);

}
