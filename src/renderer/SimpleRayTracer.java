package renderer;

import static geometries.Intersectable.GeoPoint;
import static primitives.Util.alignZero;

import lighting.LightSource;
import primitives.*;
import scene.Scene;

import java.util.List;

/**
 * This class is an extended class of a ray tracer.
 */
public class SimpleRayTracer extends RayTracerBase {
    /**
     * Construct
     * @param scene
     */
    public SimpleRayTracer(Scene scene) {
        super(scene);
    }

    /**
     * @param ray
     * @return the color of the closest point
     */
    @Override
    public Color traceRay(Ray ray) {
        List <GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        if(intersections == null)
            return scene.background;
        return calcColor(ray.findClosestGeoPoint(intersections),ray);
    }

    /**
     *
     * @param point - GoePoint
     * @return the ambient light color
     */
    private Color calcColor(GeoPoint point, Ray ray) {
        return calcLocalEffects(point, ray).add(scene.ambientLight.getIntensity());
    }
    private Color calcLocalEffects(GeoPoint geoPoint, Ray ray) {
        Color color = geoPoint.geometry.getEmission();
        Vector v = ray.getDirection();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0)
            return color;
        Material material = geoPoint.geometry.getMaterial();
        for (LightSource lightSource : scene.lights) {
            Vector l = lightSource.getL(geoPoint.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) {
                Color iL = lightSource.getIntensity(geoPoint.point);
                Double3 diffusive = calcDiffuse(material, nl);
                Double3 specular = calcSpecular(material, n, l, nl, v);
                color = color.add(iL.scale(diffusive), iL.scale(specular));
            }

        }
        return color;
    }

    /**
     * Calculates the specular reflection component for a given material, surface normal, light vector, view vector, and the dot product of the surface normal and light vector.
     *
     * @param material The material of the surface.
     * @param n        The surface normal.
     * @param l        The light vector.
     * @param nl       The dot product of the surface normal and light vector.
     * @param v        The view vector.
     * @return The specular reflection component.
     */
    private Double3 calcSpecular(Material material, Vector n, Vector l, double nl, Vector v) {
        // Calculate the reflection vector using the formula: r = l - 2 * (nl * n)
        Vector r = l.subtract(n.scale(2 * nl));

        // Compute the dot product between the view vector and the reflection vector
        double minusVR = v.dotProduct(r) * -1;

        // Apply the specular reflection coefficient and shininess to the dot product
        double max = Math.max(0, minusVR);

        // Calculate the specular reflection component using the formula: kS * (max ^ nShininess)
        return material.kS.scale(Math.pow(max, material.shininess));
    }
    /**
     * Calculates the diffuse reflection component for a given material
     * and the dot product of the surface normal and light vector.
     *
     * @param material The material of the surface.
     * @param nl       The dot product of the surface normal and light vector.
     * @return The diffuse reflection component.
     */
    private Double3 calcDiffuse(Material material, double nl) {
        // Diffuse reflection is determined by scaling the diffuse coefficient with the
        // absolute value of the dot product of the surface normal and light vector
        return material.kD.scale(Math.abs(nl));
    }

}
