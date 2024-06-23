package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

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

    public static Builder getBuilder(){
        return new Builder();
    }

    /**
     *
     * @param nX represents number of pixels in columns
     * @param nY represents number of pixels in rows
     * @param j represents the x coordinate of pixel
     * @param i represents the y coordinate of pixel
     * @return for now return null
     */
    public Ray constructRay(int nX, int nY, int j, int i){
        return null;
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
         * @return the current builder camera
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
         * @return the current builder camera
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
         * @return the current builder camera
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
         * @return the current builder camera
         * @throws IllegalArgumentException if the distance is negative
         */
        public Builder setVpDistance(double distance){
            if(alignZero(distance) <= 0.0)
                throw new IllegalArgumentException("view plane distance cannot be negative");

            camera.vpDistance=distance;
            return this;
        }

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
                throw new AssertionError();
            }
        }

    }







}
