package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Geometries extends Intersectable {

    private final List<Intersectable> geometries = new LinkedList<>();

    /**
     * Default constructor
     */
    public Geometries() {
    }

    public Geometries(Intersectable... geometries) {
        this.add(geometries);
    }

    /**
     * add the Intersectable objects to the collection
     *
     * @param geometries- group of Intersectable objects to add to the collection
     */
    public void add(Intersectable... geometries) {

        Collections.addAll(this.geometries, geometries);
    }


    /**
     * return null temper
     *
     * @param ray-Ray
     * @return null
     */
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        List<GeoPoint> result = null;

        //for each geometry add is intersection points to the list
        for (var geometry : this.geometries) {
            List<GeoPoint> geometryResult = geometry.findGeoIntersections(ray);
            if (geometryResult != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }
                result.addAll(geometryResult);
            }
        }
        return result;
    }
}
