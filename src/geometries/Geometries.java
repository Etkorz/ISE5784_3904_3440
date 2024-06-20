package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

private final List<Intersectable> intersectableList = new LinkedList<>();

    /**
     *empty constructor
     */
    public Geometries() {

    }

    /**
     *add the Intersectable objects to the collection
     *
     * @param geometries- group of Intersectable objects to add to the collection
     */
    public void add(Intersectable... geometries){
        this.intersectableList.addAll(List.of(geometries));
    }

    /**
     *constructor- creat collection of geometries from the Intersectable object given by using function add
     * @param intersectableList- list of geometries
     */
    public Geometries(Intersectable... intersectableList) {
           add(this);
    }


    /**
     *return null temper
     * @param ray-Ray
     * @return null
     */
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}
