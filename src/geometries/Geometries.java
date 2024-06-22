package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

    private final List<Intersectable> intersectableList = new LinkedList<>();

    /**
     * Default constructor
     */
    public Geometries() {}

    public Geometries(Intersectable... geometries) {
        this.add(geometries);
    }

    /**
     *add the Intersectable objects to the collection
     *
     * @param geometries- group of Intersectable objects to add to the collection
     */
    public void add(Intersectable... geometries){

        Collections.addAll(intersectableList, geometries);
    }


    /**
     *return null temper
     * @param ray-Ray
     * @return null
     */
    public List<Point> findIntersections(Ray ray) {

        List<Point> result = null;

        //for each geometry add is intersection points to the list
        for (var item : this.intersectableList) {
            List<Point> geometryResult= item.findIntersections(ray);
            if (geometryResult != null) {
                if (result==null) {
                    result = new LinkedList<>();
                }
                result.addAll(geometryResult);
            }
        }
        return result;
//        int amount = 0;
//        List<Point> lstIntersection;
//
//        // Iterate over all the geometries in this composite object.
//        for (Intersectable geometry : this.intersectableList) {
//            lstIntersection = geometry.findIntersections(ray);
//            if (lstIntersection != null)
//                amount += lstIntersection.size();
//        }
//
//        // If there are no intersection points, return null.
//        if (amount == 0)
//            return null;
//
//        // Collect all the intersection points in a list.
//        List<Point> lstAllIntersections = new LinkedList<Point>();
//        for (Intersectable geometry : this.intersectableList) {
//            lstIntersection = geometry.findIntersections(ray);
//            if (lstIntersection != null)
//                lstAllIntersections.addAll(lstIntersection);
//        }
//
//        // Return the list of intersection points.
//        return lstAllIntersections;
    }

}
