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
     *empty constructor
     */
    public Geometries() {}

    public Geometries(Intersectable... geometries) {
        this();
        add(this);
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
        for (var item : intersectableList) {
            List<Point> geometryResult= item.findIntersections(ray);
            if (geometryResult != null) {
                if (result==null) {
                    result = new LinkedList<>();
                }
                result.addAll(geometryResult);
            }
        }
        return result;
    }
}
