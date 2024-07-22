package renderer;

import primitives.*;

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
    private double vpHeight = 0.0;
    private double vpWidth = 0.0;
    private double vpDistance = 0.0;

    //parameters to construct image
    private ImageWriter imageWriter;
    private RayTracerBase rayTracer;

    private Point center;


    /**
     * private constructor
     */
    private Camera() {
    }

    public Camera(Point position, Vector vTo, Vector vUp) {
        if (vTo.dotProduct(vUp) != 0)
            throw new IllegalArgumentException("vTo and vUp must be orthogonal");
        this.position = position;
        this.toDirection = vTo.normalize();
        this.upDirection = vUp.normalize();
        this.rightDirection = this.toDirection.crossProduct(this.upDirection).normalize();
    }

    /**
     * Returns a new builder instance for creating a `Camera` object.
     *
     * @return A new `Builder` instance to configure and build a `Camera`.
     */
    public static Builder getBuilder() {
        return new Builder();
    }

    /**
     * goes over all the pixels and color them according to the scene
     */
    public Camera renderImage() {
        // throw new UnsupportedOperationException();
//        int Nx = imageWriter.getNx();
//        int Ny = imageWriter.getNy();
        for (int i = 0; i < imageWriter.getNx(); i++) {
            for (int j = 0; j < imageWriter.getNy(); j++)
                castRay(imageWriter.getNx(), imageWriter.getNy(), i, j);
        }
        return this;
    }

    /**
     * Casts a ray through a pixel at position (j, i) on the view plane,
     * and calculate the color of the closest intersected geometry, if any.
     *
     * @param nX the number of pixels along the width of the image plane
     * @param nY the number of pixels along the height of the image plane
     * @param j  the horizontal index of the pixel being casted
     * @param i  the vertical index of the pixel being casted
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @return the color of the closest intersected geometry, if any
     */
    private void castRay(int nX, int nY, int j, int i) {
        Ray ray = constructRay(nX, nY, j, i);  // casting a ray through pixel
        Color color = rayTracer.traceRay(ray); // finding the color of the point where the ray is intersected
        imageWriter.writePixel(j, i, color);   // coloring the pixel in the image
    }

    /**
     * Write the image
     */
    public void writeToImage() {
        this.imageWriter.writeToImage();
    }

    /**
     * print a grid of interval * interval pixels squares
     *
     * @param interval size of grid
     * @param color    of grid
     * @return this
     */
    public Camera printGrid(int interval, Color color) {
        for (int j = 0; j < imageWriter.getNx(); j++) {
            for (int i = 0; i < imageWriter.getNy(); i++) {
                if (isZero(j % interval) || isZero(i % interval))
                    imageWriter.writePixel(j, i, color);
            }
        }
        return this;
    }

    /**
     * Constructs a ray based on pixel coordinates within the camera's viewport.
     *
     * @param nX The number of pixels in the horizontal direction (width).
     * @param nY The number of pixels in the vertical direction (height).
     * @param j  The horizontal pixel index (column index, 0-based).
     * @param i  The vertical pixel index (row index, 0-based).
     * @return A new Ray object representing the ray originating from the camera's position and passing through the specified pixel.
     * @throws IllegalArgumentException If either `nX` or `nY` is zero (division by zero would occur).
     */
    public Ray constructRay(int nX, int nY, int j, int i) {
        
        Point Pc = position.add(toDirection.scale(vpDistance));
        double Ry = vpHeight / nY;
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
    public static class Builder {
        private final Camera camera;
        private Point Pto = null;
        /**
         * Empty constructor build camera from new object
         */
        public Builder() {
            camera = new Camera();
        }

        /**
         * Constructor to build camera from giving camera
         *
         * @param camera the given one
         */
        public Builder(Camera camera) {
            this.camera = camera;
        }

        /**
         * set the position of the camera
         *
         * @param location the position to set the camera
         * @return the current camera object
         * @throws IllegalArgumentException if the given location is null
         */
        public Builder setLocation(Point location) {
            if (location == null)
                throw new IllegalArgumentException("camera position cannot be null");
            camera.position = location;
            return this;
        }

        /**
         * set the direction of the camera
         *
         * @param toDirection the toward direction vector
         * @param upDirection the up direction vector
         * @return the current camera object
         * @throws IllegalArgumentException if the vectors are null or not orthogonal
         */
        public Builder setDirection(Vector toDirection, Vector upDirection) {
            if (toDirection == null || upDirection == null)
                throw new IllegalArgumentException("camera direction vectors cannot be null");
            if (!isZero(toDirection.dotProduct(upDirection)))
                throw new IllegalArgumentException("direction vectors must be orthogonal");

            camera.upDirection = upDirection.normalize();
            camera.toDirection = toDirection.normalize();
            camera.rightDirection = toDirection.crossProduct(upDirection).normalize();
            return this;
        }

        /**
         * sets the vectors from the camera towards a given point
         * @param Pto the direction point
         * @param Vup the general up direction (of view plane)
         * @return the updated builder
         */
        public Builder setDirection(Point Pto, Vector Vup ){
            camera.upDirection = Vup;
            this.Pto = Pto;
            return this;
        }

        /**
         * set the size of the view plane
         *
         * @param width  the width of the view plane
         * @param height the height of the view plane
         * @return the current camera object
         * @throws IllegalArgumentException if the width or height are not positive
         */
        public Builder setVpSize(double width, double height) {
            if (alignZero(width) <= 0 || alignZero(height) <= 0)
                throw new IllegalArgumentException("view plane width or height must be positive");

            camera.vpWidth = width;
            camera.vpHeight = height;
            return this;
        }

        /**
         * set the view plane distance
         *
         * @param distance the view plane distance
         * @return the current camera object
         * @throws IllegalArgumentException if the distance is negative
         */
        public Builder setVpDistance(double distance) {
            if (alignZero(distance) <= 0.0)
                throw new IllegalArgumentException("view plane distance cannot be negative");

            camera.vpDistance = distance;
            return this;
        }

        /**
         * Sets the RayTracerBase of the Camera
         *
         * @param rayTracer rayTracer
         * @return this
         */
        public Builder setRayTracer(RayTracerBase rayTracer) {
            camera.rayTracer = rayTracer;
            return this;
        }

        /**
         * sets the ImageWriter of the Camera
         *
         * @param imageWriter imageWriter
         * @return this
         */
        public Builder setImageWriter(ImageWriter imageWriter) {
            camera.imageWriter = imageWriter;
            return this;
        }
//        public Builder setImageWriter(ImageWriter imageWriter) {
//            camera.imageWriter = imageWriter;
//            return this;
//        }

        /**
         * Builds and validates a complete Camera object, ensuring all necessary data is present and adheres to constraints.
         *
         * @return A new, validated Camera instance.
         * @throws MissingResourceException If any of the following camera properties are missing:
         *                                  - `position`
         *                                  - `toDirection`
         *                                  - `upDirection`
         * @throws IllegalStateException    If either viewport height, width, or distance is non-positive.
         * @throws IllegalArgumentException If `toDirection` and `upDirection` are not orthogonal (i.e., not perpendicular).
         */
        public Camera build() {
            //const strings for exceptions throwing
            final String MISSING_RENDERING_ARGUMENT = "Missing rendering argument";
            final String CAMERA = "Camera";
            final String MUST_BE_NORMALIZED = " must be normalized";
            //if a field is null
            if (camera.position == null)
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA ,"p0");
            if (Pto == null && camera.toDirection == null)
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA ,"direction (Vto or Pto)");
            if (camera.upDirection == null)
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA ,"Vup");
            if(camera.imageWriter == null)
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA,"imageWriter");
            if(camera.rayTracer == null)
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA,"rayTracer");
            // check if Vto and Vup are orthogonal
            if (Pto == null && !Util.isZero(camera.toDirection.dotProduct(camera.upDirection)))
                throw new IllegalArgumentException("Vto and Vup are not orthogonal");
            // check if Vup and Vto are normalized
            if (Pto == null && !Util.isZero(camera.toDirection.lengthSquared()-1))
                throw new IllegalArgumentException("Vto" + MUST_BE_NORMALIZED);
            if (!Util.isZero(camera.upDirection.lengthSquared()-1))
                throw new IllegalArgumentException("Vup" + MUST_BE_NORMALIZED);
            //check if Pto equals P0
            if(camera.position.equals(Pto))
                throw new IllegalArgumentException("Pto must be different from P0");
            // setting Vright and center (Vto optionally)
            if(Pto != null)
                camera.toDirection = Pto.subtract(camera.position).normalize();

            camera.rightDirection = camera.toDirection.crossProduct(camera.upDirection);

            camera.center = camera.position.add(camera.toDirection.scale(camera.vpDistance));
            //if a field is zero
            if(Util.isZero(camera.vpWidth))
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA,"width");
            if(Util.isZero(camera.vpHeight))
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA,"height");
            if(Util.isZero(camera.vpDistance))
                throw new MissingResourceException(MISSING_RENDERING_ARGUMENT,CAMERA,"distance");
            // return clone of the object
            try {
                return (Camera) camera.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
