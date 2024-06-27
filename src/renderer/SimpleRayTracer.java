package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;
import geometries.Intersectable.GeoPoint;

import java.util.List;

/**
 * The SimpleRayTracer class represents a basic implementation of the abstract class RayTracerBase.
 * It provides a method to trace a ray in the scene.
 *
 * @author Eti Kenig and Gitty Shapira
 */
public class SimpleRayTracer extends RayTracerBase {
    /**
     * Constructs a RayTracerBasic object with the given scene.
     *
     * @param scene the scene to trace rays in
     */
    public SimpleRayTracer(Scene scene) {

        super(scene);
    }

    /**
     * Trace the ray and returns the color of the closest body that the ray hits
     *
     * @param ray to trace
     * @return color
     */
    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> points = scene.geometries.findGeoIntersections(ray);
        return points == null ? scene.background : calcColor(ray.findClosestGeoPoint(points));

    }

    /**
     * return the color of the lighting
     *
     * @param gp color
     * @return color of point
     */
    private Color calcColor(GeoPoint gp) {
        return scene.ambientLight.getIntensity()
                .add(gp.geometry.getEmission());
    }


}
