package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;
import java.util.Objects;

/**
 *
 */
public abstract class Intersectable {

    /**
     *Inner static class represent a geometry point with the geometry
     */
    public static class GeoPoint {

        /**
         *the geometry that hit
         */
        public Geometry geometry;

        /**
         *the point where the geometry hit
         */
        public Point point;

        /**
         *constructor whit parameters
         *
         * @param point the point to update the point
         * @param geometry the geometry to update the geometry
         */
        public GeoPoint(Point point, Geometry geometry) {
            this.point = point;
            this.geometry = geometry;
        }

        /**
         * Overrides the `equals` method from the `Object` class.
         *
         * Two `GeoPoint` objects are considered equal if:
         *   * They refer to the same object in memory (reference equality).
         *   * The argument is an instance of the `GeoPoint` class.
         *   * Both the `geometry` and `point` fields of both objects are equal.
         *
         * @param o The object to compare with.
         * @return true if the objects are considered equal, false otherwise.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof GeoPoint geoPoint))
                return false;
            return Objects.equals(geometry, geoPoint.geometry) && Objects.equals(point, geoPoint.point);
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }


    /**
     * find the intersection point between ray to graphic object
     *
     * @param ray
     * @return
     */
//    public List<Point> findIntersections(Ray ray){
//
//    }

    public List<Point> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null : geoList.stream().map(gp -> gp.point).toList();
    }


    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);

    /**
     * Finds the intersections between a given `Ray` object and one or more `GeoPoint` objects.
     *
     * @param ray The `Ray` object to find intersections with.
     * @return A `List` containing the `GeoPoint` objects that intersect with the `ray`. The list may be empty if there are no intersections.
     *
     * @see #findGeoIntersectionsHelper(Ray)
     */
    public final List<GeoPoint> findGeoIntersections(Ray ray){
        return findGeoIntersectionsHelper(ray);
    }
}
