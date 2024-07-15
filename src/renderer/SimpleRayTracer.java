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
     * calculate the local effects of light on a point
     *
     * @param geoPoint  the point
     * @param ray the ray being trace
     * @return the color of the point taking only local effects into account
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
////     * calculate the global effects (transparency and reflection) of light on a point
////     *
////     * @param gp    the point
////     * @param ray   the ray that intersects the point
////     * @param level the recursive level
////     * @param k     the attenuation factor
////     * @return the Color of the global effects on the point
////     */
    private Color calcGlobalEffects(GeoPoint gp, Ray ray, int level, Double3 k) {
        Color color = Color.BLACK;
        Vector v = ray.getDirection();
        Vector n = gp.geometry.getNormal(gp.point);
        Material material = gp.geometry.getMaterial();
        return calcGlobalEffect(constructReflectedRay(gp.point, v, n), level, k, material.getkR())
                .add(calcGlobalEffect(constructRefractedRay(gp.point, v, n), level, k, material.getkT()));
    }


/**
 //     * calculate the global effects (transparency and reflection) of light on a point
 //     *
 //     * @param ray   the ray that intersects the point
 //     * @param kx    the attenuation factor of material
 //     * @param level the recursive level
 //     * @param k     the reduced attenuation factor
 //     * @return the Color of the global effects on the point
 //     */
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
 //     * Calculates the color at a given geometric intersection point considering local lighting effects and potentially global effects such as transparency or reflection.
 //     *
 //     * @param gp     The geometric point at which to calculate the color.
 //     * @param ray    The ray that intersected with the geometry at the intersection point.
 //     * @param level  The current recursion level for handling transparency or reflection effects.
 //     * @param k      The accumulated coefficient (e.g., transparency or reflection coefficient) up to the current recursion level.
 //     * @return The calculated color at the intersection point, considering local lighting effects and global effects up to the specified recursion level.
 //     */
    private Color calcColor(GeoPoint gp, Ray ray, int level, Double3 k) {
        Geometry geometry = gp.geometry;
        Color color = geometry.getEmission().add(calcLocalEffect(gp, ray));
        return level == 1 ? color :
                color.add(calcGlobalEffects(gp, ray, level, k));
    }

    /**
     * Calculates the color at a given geometric point considering ambient light, emission from the geometry, and local lighting effects.
     * This method uses recursive ray tracing to handle transparency and reflection up to a specified recursion level.
     *
     * @param point  The geometric point at which to calculate the color.
     * @param ray The ray that intersected with the geometry at the geometric point.
     * @return The calculated color at the geometric point, taking into account ambient light, emission, local lighting effects (diffuse and specular reflections), and recursive effects of transparency or reflection.
     */
    private Color calcColor(GeoPoint point, Ray ray) {
        return calcColor(point, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K).add(scene.getAmbientLight().getIntensity());
    }

   private Color calcDiffuse(Double3 kd, Vector l, Vector n, Color lightIntensity) {

        double nl = n.dotProduct(l);
        double abs_nl = Math.abs(nl);
        Double3 amount = kd.scale(abs_nl);
        return lightIntensity.scale(amount);
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
 //     * finds the closest intersection to ray's head with ray
 //     *
 //     * @param ray the ray
 //     * @return the intersection or null of there are no intersections
 //     */
    private GeoPoint findClosestIntersection(Ray ray) {
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        return intersections == null||intersections.isEmpty() ? null : ray.findClosestGeoPoint(intersections);
    }

/**
 //     * A "non-shading" test method between a point and the light source
 //     * If the list of cuts received is not empty - we will go through the list and if we come across more cuts
 //     * Closer to the top of the beam than the distance between the point and the light source - we will return false
 //     *
 //     * @param gp the geometrical point to check for shading
 //     * @param light the light source to check against
 //     * @param l the vector from the point to the light source
 //     * @param n the normal vector at the point
 //     * @param nl the dot product of the normal vector and the light vector
 //     * @return {@code true} if the point is unshaded (not in shadow), {@code false} otherwise
 //     */
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
 //     * construct refraction(transparency) ray from light intersection with a point
 //     *
 //     * @param gp  the point
 //     * @param ray the ray intersected the point
 //     * @param n   the normal to the geometry from the point
 //     * @return refraction ray
 //     */
    private Ray constructRefractedRay(Point point,Vector v, Vector n) {
        return new Ray(point,v, n);
    }

    /**
     * construct reflection ray from light intersection with a point
     *
     * @param gp  the point
     * @param ray the ray intersected the point
     * @param n   the normal to the geometry from the point
     * @return reflection ray
     */
    private Ray constructReflectedRay(Point gp, Vector v, Vector n) {

        double nv = v.dotProduct(n);
        if(nv == 0)
            return null;

        Vector r = v.subtract(n.scale(nv * 2));

        return new Ray(gp, r, n);
    }

    /*
     * The function returns the transparency of the point, which is the product of the transparency of the point's geometry
     * and the transparency of all the geometries between the point and the light source
     *
     * @param gp The point on the geometry that we're currently shading.
     * @param l the vector from the point to the light source
     * @param n the normal vector of the point
     * @param ls the light source
     * @return The transparency of the point.
     */
    private Double3 transparency(GeoPoint gp, LightSource light, Vector l, Vector n) {
        Vector lightDir = l.scale(-1); // Vector from the point to the light source

        Ray lightRay = new Ray(gp.point,lightDir, n); // Ray from the offset point towards the light source

        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay); // Find intersections along the ray

        if (intersections == null) {
            return Double3.ONE;}

            Double3 ktr=Double3.ONE;
            for (GeoPoint gp2 : intersections) {
                ktr=ktr.product(gp2.geometry.getMaterial().kT);
                if(ktr.lowerThan(MIN_CALC_COLOR_K))
                    return Double3.ZERO;
            }

        return ktr;
    }
}
