package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries extends Intersectable {

private final List<Intersectable> geometries = new LinkedList<>();

    /**
     *empty constructor
     */
    public Geometries() {

    }

    /**
     *constructor
     * @param geometries- list fo geometries
     */
    public Geometries(Intersectable... geometries) {
           add(this);
    }

    /**
     *add geometries to the list
     *
     * @param geometries- group of geometries
     */
    public void add(Intersectable... geometries){
          this.geometries.addAll(List.of(geometries));
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
