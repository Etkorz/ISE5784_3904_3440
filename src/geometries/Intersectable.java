package geometries;

import primitives.*;
import primitives.Ray;

import java.util.List;

/**
 *
 */
public interface Intersectable {

    /**
     * find the intersection point between ray to graphic object
     * @param ray
     * @return
     */
   List<Point> findIntersections(Ray ray);//do i need to add public?


}
