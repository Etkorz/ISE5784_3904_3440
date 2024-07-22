package renderer;

import static geometries.Intersectable.GeoPoint;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

import static java.lang.Math.*;

import geometries.Geometry;
import lighting.LightSource;
import primitives.*;
import scene.Scene;

import java.util.List;

/**
// * This class is an extended class of a ray tracer.
// */
public class SimpleRayTracer extends RayTracerBase {

    /**
     * The initial coefficient for transparency or reflection calculations.
     * This constant is used as the starting value for the accumulated coefficient in recursive color calculations.
     */
    private static final Double3 INITIAL_K = Double3.ONE;

    //Stopping conditions in transparency recursion
    private static final int MAX_CALC_COLOR_LEVEL = 10;

    //Stopping conditions in reflection recursion
    private static final double MIN_CALC_COLOR_K = 0.001;

    //Rayhead offset size for shading rays
    private static final double EPS = 0.1;

    /**
     * Construct
     *
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
        GeoPoint intersections =findClosestIntersection(ray);
        if (intersections == null)
            return scene.background;
        return calcColor(intersections, ray);
    }

    /**
     * Calculates the local lighting effect for a given geometric point.
     *
     * @param geoPoint  the geometric point to calculate the effect for
     * @param ray       the ray intersecting the geometric point
     * @return          the color of the geometric point considering local lighting effects
     */
    private Color calcLocalEffect(GeoPoint geoPoint, Ray ray) {

        Vector v = ray.getDirection();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0)
            return Color.BLACK;
        int nShininess = geoPoint.geometry.getMaterial().getShininess();
        Double3 kd = geoPoint.geometry.getMaterial().getkD();
        Double3 ks = geoPoint.geometry.getMaterial().getkS();
        Color color = Color.BLACK;
        for (LightSource lightSource : scene.getLights()) {
            Vector l = lightSource.getL(geoPoint.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) {
                Double3 ktr = transparency(geoPoint,lightSource, l, n );
                if (!ktr.product(INITIAL_K).lowerThan(MIN_CALC_COLOR_K)) {
                    Color iL = lightSource.getIntensity(geoPoint.point).scale(ktr);
                    color = color.add(
                            calcDiffuse(kd, n, l,iL),
                            (calcSpecular(ks, l, n,v, nShininess, iL)));
                }
            }
        }
        return color;
    }

    /**
     * Calculates the global effects (reflection and refraction) of light on a given point in the scene.
     *
     * @param gp The point on the geometry where the light effect is being calculated.
     * @param ray The ray that intersects the geometry at the gp.
     * @param level The recursion level for reflection and refraction calculations.
     * @param k The attenuation factor for global effects.
     * @return The color resulting from the global lighting effects on the gp.
     */
    private Color calcGlobalEffects(GeoPoint gp, Ray ray, int level, Double3 k) {
        Color color = Color.BLACK;
        Vector v = ray.getDirection();
        Vector n = gp.geometry.getNormal(gp.point);
        Material material = gp.geometry.getMaterial();
        return calcGlobalEffect(constructReflectedRay(gp.point, v, n), level, k, material.getkR())
                .add(calcGlobalEffect(constructRefractedRay(gp.point, v, n), level, k, material.getkT()));
    }


    /**
     * Calculates the global effect (either reflection or refraction) of a given ray on the scene.
     *
     * @param ray The ray for which the global effect is being calculated.
     * @param level The recursion level for the calculation.
     * @param k The cumulative attenuation factor for global effects.
     * @param kx The specific attenuation factor for the current effect (reflection or refraction).
     * @return The color resulting from the global effect of the ray on the scene.
     */
    private Color calcGlobalEffect(Ray ray,int level,  Double3 k, Double3 kx) {
        Double3 kkx = k.product(kx);
        if (kkx.lowerThan(MIN_CALC_COLOR_K)) return Color.BLACK;
        GeoPoint gp = findClosestIntersection(ray);
        if (gp == null )
            return scene.background.scale(kx);
    return isZero(gp.geometry.getNormal(gp.point).dotProduct(ray.getDirection())) ? Color.BLACK :
            calcColor(gp, ray, level - 1, kkx).scale(kx);
    }

    /**
     * Calculates the color at a given point in the scene, considering both local and global lighting effects.
     *
     * @param gp The point on the geometry where the color is being calculated.
     * @param ray The ray that intersects the geometry at the gp.
     * @param level The recursion level for reflection and refraction calculations.
     * @param k The cumulative attenuation factor for global effects.
     * @return The color resulting from the combined local and global lighting effects at the gp.
     */
    private Color calcColor(GeoPoint gp, Ray ray, int level, Double3 k) {
        Geometry geometry = gp.geometry;
        Color color = geometry.getEmission().add(calcLocalEffect(gp, ray));
        return level == 1 ? color :
                color.add(calcGlobalEffects(gp, ray, level, k));
    }

    /**
     * Calculates the color at a given point in the scene, considering local and global lighting effects,
     * and adds the ambient light.
     *
     * @param point The point on the geometry where the color is being calculated.
     * @param ray The ray that intersects the geometry at the point.
     * @return The color resulting from the combined local and global lighting effects at the point,
     *         including ambient light.
     */
    private Color calcColor(GeoPoint point, Ray ray) {
        return calcColor(point, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(scene.getAmbientLight().getIntensity());
    }

    /**
     * Calculates the diffuse component of the light at a given point on a surface.
     *
     * @param kd The diffuse reflection coefficient of the material.
     * @param l The direction vector from the point to the light source.
     * @param n The normal vector at the point on the surface.
     * @param lightIntensity The intensity of the light hitting the point.
     * @return The color resulting from the diffuse reflection at the point.
     */
   private Color calcDiffuse(Double3 kd, Vector l, Vector n, Color lightIntensity) {

        double nl = n.dotProduct(l);
        double abs_nl = Math.abs(nl);
        Double3 amount = kd.scale(abs_nl);
        return lightIntensity.scale(amount);
    }

    /**
     * Calculates the specular component of the light at a given point on a surface.
     *
     * @param ks The specular reflection coefficient of the material.
     * @param l The direction vector from the point to the light source.
     * @param n The normal vector at the point on the surface.
     * @param v The direction vector from the point to the viewer.
     * @param nShininess The shininess exponent of the material.
     * @param lightIntensity The intensity of the light hitting the point.
     * @return The color resulting from the specular reflection at the point.
     */
    private Color calcSpecular(Double3 ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {

        double nl = n.dotProduct(l);
        Vector r = l.add(n.scale(-2 * nl));
        double minusVR = -alignZero(r.dotProduct(v));

        if (minusVR <= 0) {
            return Color.BLACK;
        }
        Double3 amount = ks.scale(Math.pow(minusVR, nShininess));

        return lightIntensity.scale(amount);
    }

    /**
     * Finds the closest intersection point of a given ray with the geometries in the scene.
     *
     * @param ray The ray for which the closest intersection is being calculated.
     * @return The closest intersection point, or null if no intersection is found.
     */
    private GeoPoint findClosestIntersection(Ray ray) {
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        return intersections == null||intersections.isEmpty() ? null : ray.findClosestGeoPoint(intersections);
    }

    /**
     * Checks if a point on a geometry is unshaded by any other geometry for a given light source.
     *
     * @param gp The point on the geometry where shading is being checked.
     * @param light The light source being checked for shading.
     * @param l The direction vector from the point to the light source.
     * @param n The normal vector at the point on the surface.
     * @param nl The dot product of the normal vector and the light direction vector.
     * @return True if the point is unshaded by any other geometry, false otherwise.
     */
    private boolean unshaded(GeoPoint gp, LightSource light, Vector l, Vector n, double nl) {
        Vector lightDirection = l.scale(-1);
        Ray lightRay = new Ray(gp.point, lightDirection, n);
        // double maxDistance = light.getDistance(gp.point);
        List<GeoPoint> intersections = scene.getGeometries().findGeoIntersections(lightRay);
        if (intersections == null || intersections.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Constructs a refracted ray from a given point on a surface.
     *
     * @param point The point on the surface where the refraction occurs.
     * @param v The direction vector of the incoming ray.
     * @param n The normal vector at the point on the surface.
     * @return The refracted ray starting from the given point in the direction of the incoming ray.
     */
    private Ray constructRefractedRay(Point point,Vector v, Vector n) {

        return new Ray(point,v, n);
    }

    /**
     * Constructs a reflected ray from a given point on a surface.
     *
     * @param gp The point on the surface where reflection occurs.
     * @param v The direction vector of the incident ray.
     * @param n The normal vector at the point on the surface.
     * @return The reflected ray starting from the given point in the direction of reflection,
     *         or null if the incident ray is parallel to the surface (dot product of v and n is zero).
     */
    private Ray constructReflectedRay(Point gp, Vector v, Vector n) {

        double nv = v.dotProduct(n);
        if(nv == 0)
            return null;

        Vector r = v.subtract(n.scale(nv * 2));

        return new Ray(gp, r, n);
    }

    /**
     * Calculates the transparency factor (ktr) for a given point on a surface towards a light source.
     *
     * @param gp The point on the surface where transparency is being calculated.
     * @param light The light source towards which transparency is being evaluated.
     * @param l The direction vector from the point to the light source.
     * @param n The normal vector at the point on the surface.
     * @return The transparency factor (ktr) indicating the attenuation of light due to transparency,
     *         ranging from 0 (completely opaque) to 1 (fully transparent).
     */
    private Double3 transparency(GeoPoint gp, LightSource light, Vector l, Vector n) {
        // Create a ray from the intersection point towards the light source
        Vector lightDirection = l.scale(-1); // from point to light source

        Point point = gp.point;
        Ray lightRay = new Ray(point, lightDirection, n);

        //double maxDistance = light.getDistance(point);
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);

        // If there are no intersections, return full transparency
        if (intersections == null)
            return Double3.ONE;

        Double3 ktr = Double3.ONE;

        for (GeoPoint geo : intersections) {
            // Check if the intersection point is closer to the light source than the current point
            if (point.distance(geo.point) < light.getDistance(point)) {
                // Multiply the transparency factor by the kT value of the intersected geometry
                ktr = geo.geometry.getMaterial().getkT().product(ktr);
            }

            // If the transparency factor is zero, no light can pass through
            if (ktr.equals(Double3.ZERO)) {
                return Double3.ZERO;
            }
        }
        return ktr;
    }
}
