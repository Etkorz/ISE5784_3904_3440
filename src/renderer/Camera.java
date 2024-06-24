package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * The Camera class represents a virtual camera in a 3D space.
 * It provides methods to set up the camera's position, orientation, and viewport size and distance.
 *
 * @author Gitty Shapira and Eti Kortiz
 */
public class Camera implements Cloneable {

    //the position of the camera in D3
    private Point position;

    //the right direction of the camera
    private Vector rightDirection;

    //the up direction of the camera
    private Vector upDirection;

    //the direction that the camera is pointing to
    private Vector toDirection;

    //parameters of the view Plane
    private double vpHeigth = 0.0;
    private double vpWidth = 0.0;
    private double vpDistance = 0.0;

    /**
     * private constructor
     */
    private Camera(){}

    /**
     * Returns a new builder instance for creating a `Camera` object.
     *
     * @return A new `Builder` instance to configure and build a `Camera`.
     */
    public static Builder getBuilder(){
        return new Builder();
    }

    /**
     * Constructs a ray based on pixel coordinates within the camera's viewport.
     *
     * @param nX The number of pixels in the horizontal direction (width).
     * @param nY The number of pixels in the vertical direction (height).
     * @param j The horizontal pixel index (column index, 0-based).
     * @param i The vertical pixel index (row index, 0-based).
     * @return A new Ray object representing the ray originating from the camera's position and passing through the specified pixel.
     * @throws IllegalArgumentException If either `nX` or `nY` is zero (division by zero would occur).
     */
    public Ray constructRay(int nX, int nY, int j, int i){
        if (nY == 0 || nX == 0) {
            throw new IllegalArgumentException("It is impossible to divide by 0");
        }
        Point Pc = position.add(toDirection.scale(vpDistance));
        double Ry = vpHeigth / nY;
        double Rx = vpWidth / nX;

        double Yi = -1 * (i - (nY - 1) / 2.0) * Ry;
        double Xj = (j - (nX - 1) / 2.0) * Rx;

        Point Pij = Pc;
        if (!isZero(Xj)) {
            Pij = Pij.add(rightDirection.scale(Xj));
        }

        if (!isZero(Yi)) {
            Pij = Pij.add(upDirection.scale(Yi));
        }

        return new Ray(position, Pij.subtract(position));
    }

    /**
     * Builder class for the camera, inside class
     */
    public static class Builder{
        private final Camera camera;

        /**
         *empty constructor build camera from new object
         */
        public Builder(){
            camera=new Camera();
        }

        /**
         *constructor to build camera from giving camera
         * @param camera the given one
         */
        public Builder(Camera camera){
            this.camera=camera;
        }

        /**
         * set the position of the camera
         * @param location the position to set the camera
         * @return the current camera object
         * @throws IllegalArgumentException if the given location is null
         */
        public Builder setLocation(Point location){
            if(location == null)
                throw new IllegalArgumentException("camera position cannot be null");

            camera.position=location;
            return this;
        }

        /**
         *set the direction of the camera
         * @param toDirection the toward direction vector
         * @param upDirection the up direction vector
         * @return the current camera object
         * @throws IllegalArgumentException if the vectors are null or not orthogonal
         */
        public Builder setDirection(Vector toDirection, Vector upDirection){
            if(toDirection == null || upDirection == null)
                throw new IllegalArgumentException("camera direction vectors cannot be null");
            if(!isZero(toDirection.dotProduct(upDirection)))
                throw new IllegalArgumentException("direction vectors must be orthogonal");

            camera.upDirection=upDirection.normalize();
            camera.toDirection=toDirection.normalize();
            camera.rightDirection=toDirection.crossProduct(upDirection).normalize();
            return this;
        }

        /**
         *set the size of the view plane
         * @param width the width of the view plane
         * @param height the height of the view plane
         * @return the current camera object
         * @throws IllegalArgumentException if the width or height are not positive
         */
        public Builder setVpSize(double width, double height){
            if(alignZero(width) <= 0 || alignZero(height) <= 0)
                throw new IllegalArgumentException("view plane width or height must be positive");

            camera.vpWidth=width;
            camera.vpHeigth=height;
            return this;
        }

        /**
         *set the view plane distance
         * @param distance the view plane distance
         * @return the current camera object
         * @throws IllegalArgumentException if the distance is negative
         */
        public Builder setVpDistance(double distance){
            if(alignZero(distance) <= 0.0)
                throw new IllegalArgumentException("view plane distance cannot be negative");

            camera.vpDistance=distance;
            return this;
        }

        /**
         * Builds and validates a complete Camera object, ensuring all necessary data is present and adheres to constraints.
         *
         * @return A new, validated Camera instance.
         * @throws MissingResourceException If any of the following camera properties are missing:
         *                                  - `position`
         *                                  - `toDirection`
         *                                  - `upDirection`
         * @throws IllegalStateException If either viewport height, width, or distance is non-positive.
         * @throws IllegalArgumentException If `toDirection` and `upDirection` are not orthogonal (i.e., not perpendicular).
         */
        public Camera build(){
            final String masseg = "Missing rendering data";
            if(camera.position == null)
                throw new MissingResourceException(masseg, Camera.class.getName(), "position");
            if(camera.toDirection == null)
                throw new MissingResourceException(masseg, Camera.class.getName(), "toDirection");
            if(camera.upDirection == null)
                throw new MissingResourceException(masseg, Camera.class.getName(), "upDirection");
            if(alignZero(camera.vpHeigth)<=0)
                throw new IllegalStateException("heigth must be positive");
            if(alignZero(camera.vpWidth)<=0)
                throw new IllegalStateException("width must be positive");
            if(alignZero(camera.vpDistance)<=0)
                throw new IllegalStateException("distance must be positive");
            if(!isZero(camera.toDirection.dotProduct(camera.upDirection)))
                throw new IllegalArgumentException("direction vectors must be orthogonal");
            if(camera.rightDirection == null)
                camera.rightDirection=camera.toDirection.crossProduct(camera.upDirection).normalize();
            try{
                return (Camera) camera.clone();
            }catch (CloneNotSupportedException e){
                throw new AssertionError(e);
            }
        }
    }
}
