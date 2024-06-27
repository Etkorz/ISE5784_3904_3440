package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;


import static primitives.Util.isZero;

public class Triangle extends Polygon {
    /**
     * Constructor that initialize the Triangle point
     *
     * @param p1 point p1
     * @param p2 point p2
     * @param p3 point p3
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        // find intersection of triangle with plane
        List<Point> intersections = plane.findIntersections(ray);

        //if there are no intersection- return null
        if (intersections == null)
            return null;


        //get the head and direction of ray
        Point p0 = ray.getHead();
        Vector v = ray.getDirection();

        //get the vertices of the triangle
        Vector vector1 = vertices.get(0).subtract(p0);
        Vector vector2 = vertices.get(1).subtract(p0);
        Vector vector3 = vertices.get(2).subtract(p0);

        //calculate the dot products of the ray direction and the normal vector
        //return the vector that
        double nv1 = v.dotProduct(vector1.crossProduct(vector2));//v*(v1Xv2)
        double nv2 = v.dotProduct(vector2.crossProduct(vector3));//v*(v2Xv3)
        double nv3 = v.dotProduct(vector3.crossProduct(vector1));//v*(v3Xv1)

        if (isZero(nv1) || isZero(nv2) || isZero(nv3))
            return null;

        // if ALL the products are positive or ALL the products are negatives the point is inside the triangle
         if((nv1 > 0 && nv2 > 0 && nv3 > 0) || (nv1 < 0 && nv2 < 0 && nv3 < 0)){
             List<GeoPoint> result = plane.findGeoIntersectionsHelper(ray);
             for(GeoPoint geoPoint : result){
                 geoPoint.geometry=this;
             }
             return result;
         }else
             return null;
    }
}
