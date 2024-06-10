package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

public class Triangle extends Polygon{
    /**
     * Constructor that initialize the Triangle point
     * @param p1 point p1
     * @param p2 point p2
     * @param p3 point p3
     */
    public Triangle(Point p1, Point p2, Point p3){
        super(p1,p2,p3);
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}
