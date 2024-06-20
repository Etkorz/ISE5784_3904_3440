package geometries;

import primitives.Ray;
import primitives.Point;
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
   List<Point> findIntersections(Ray ray);



}
