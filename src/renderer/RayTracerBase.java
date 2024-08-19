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

    /**
     * Recursively performs adaptive supersampling to improve the rendering quality by reducing aliasing.
     *
     * @param centerP        The center point of the current pixel area being sampled.
     * @param Width          The width of the current pixel area.
     * @param Height         The height of the current pixel area.
     * @param minWidth       The minimum width for adaptive sampling recursion.
     * @param minHeight      The minimum height for adaptive sampling recursion.
     * @param cameraLoc      The location of the camera.
     * @param Vright         The right vector of the camera's coordinate system.
     * @param Vup            The up vector of the camera's coordinate system.
     * @param prePoints      The list of previously computed corner points, used to avoid recalculating the same ray.
     *
     * @return The color of the pixel after adaptive supersampling.
     */
    public abstract Color adaptiveSuperSamplingRec(Point centerP, double Width, double Height, double minWidth, double minHeight, Point cameraLoc, Vector Vright, Vector Vup, List<Point> prePoints);

}
