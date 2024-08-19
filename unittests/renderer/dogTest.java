package renderer;
import static java.awt.Color.*;
import geometries.Plane;
import lighting.DirectionalLight;
import lighting.PointLight;
import org.junit.jupiter.api.Test;
import geometries.Sphere;
import geometries.Triangle;
import lighting.AmbientLight;
import lighting.SpotLight;
import primitives.*;
import scene.Scene;


public class dogTest {
    private final Scene          scene         = new Scene("Test scene");
    /** Camera builder for the tests with triangles */
    private final Camera.Builder cameraBuilder = Camera.getBuilder()
            .setDirection(new Point(0,30,0), new Vector(0,1,0))
            .setRayTracer(new SimpleRayTracer(scene))
            .setSamplesPerPixel(9)
            .setMultithreading(-2)
            .setAdaptive(true);


    @Test
    public void myTest1() {
        Color bowlColor = new Color(83, 86, 84);
        Color dogColor = new Color(90, 63, 30);
        Material dogMaterial = new Material().setkD(0.4).setkS(0.3).setShininess(1).setkT(0.3);
        Material bowMaterial = new Material().setkD(0.1).setkS(0.5).setkR(0.5).setShininess(1).setkT(0.0);

        scene.geometries.add(
                new Triangle(new Point(-39.33, 66.09, 33.23),
                        new Point(-34.53, 66.53, 31.77),
                        new Point(-36.46, 67.02, 29.72))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.22, 67.00, 33.14),
                        new Point(-34.53, 66.53, 31.77),
                        new Point(-39.33, 66.09, 33.23))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.00, 45.43, 19.59),
                        new Point(-33.24, 54.81, 28.53),
                        new Point(-24.09, 53.95, 22.79))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.89, 59.81, 43.34),
                        new Point(-25.61, 60.35, 42.19),
                        new Point(-26.09, 62.97, 44.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.57, 56.36, 43.07),
                        new Point(-26.89, 59.81, 43.34),
                        new Point(-26.09, 62.97, 44.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-46.86, 50.97, 45.64),
                        new Point(-35.33, 49.70, 39.14),
                        new Point(-34.44, 51.45, 42.90))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-47.98, 53.84, 48.37),
                        new Point(-46.86, 50.97, 45.64),
                        new Point(-34.44, 51.45, 42.90))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-43.40, 60.19, 38.89),
                        new Point(-42.61, 62.12, 41.93),
                        new Point(-42.62, 63.80, 36.85))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-34.92, 48.02, 34.98),
                        new Point(-37.84, 50.76, 34.22),
                        new Point(-30.22, 34.22, 28.37))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.35, 22.53, 22.68),
                        new Point(0.07, 31.52, 26.03),
                        new Point(-11.37, 21.55, 28.31))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(37.28, 15.61, -19.95),
                        new Point(31.00, 12.25, -21.68),
                        new Point(31.55, 11.64, -19.86))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(31.00, 12.25, -21.68),
                        new Point(37.28, 15.61, -19.95),
                        new Point(31.87, 13.65, -25.20))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(40.83, 14.09, -13.25),
                        new Point(36.74, 9.32, -12.12),
                        new Point(39.09, 8.87, -10.24))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(35.54, 17.37, -25.33),
                        new Point(31.87, 13.65, -25.20),
                        new Point(37.28, 15.61, -19.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(39.09, 8.87, -10.24),
                        new Point(40.58, 8.86, -9.77),
                        new Point(40.83, 14.09, -13.25))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(44.45, 13.12, -11.49),
                        new Point(40.83, 14.09, -13.25),
                        new Point(40.58, 8.86, -9.77))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.54, -0.81, 2.35),
                        new Point(-29.71, -2.36, 0.33),
                        new Point(-27.33, -3.34, 3.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.59, -6.47, 18.86),
                        new Point(-13.63, -1.89, 18.43),
                        new Point(-15.54, -3.40, 14.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-10.17, 27.34, 8.16),
                        new Point(5.89, 34.36, 7.76),
                        new Point(-6.85, 23.48, 17.38))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-10.53, 37.47, 3.77),
                        new Point(-10.17, 27.34, 8.16),
                        new Point(-14.95, 22.90, 10.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.65, -0.25, 3.71),
                        new Point(-27.33, -3.34, 3.65),
                        new Point(-24.18, -3.27, 4.36))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.65, -0.25, 3.71),
                        new Point(-27.54, -0.81, 2.35),
                        new Point(-27.33, -3.34, 3.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-22.96, 2.26, 2.89),
                        new Point(-27.54, -0.81, 2.35),
                        new Point(-20.65, -0.25, 3.71))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(37.28, 15.61, -19.95),
                        new Point(31.55, 11.64, -19.86),
                        new Point(39.70, 13.36, -22.17))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.24, 27.21, -7.92),
                        new Point(25.48, 46.46, 0.74),
                        new Point(22.99, 38.95, -1.22))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(22.99, 38.95, -1.22),
                        new Point(25.77, 26.02, -3.44),
                        new Point(15.37, 35.02, 4.44))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.21, 38.92, 11.21),
                        new Point(35.20, 31.41, -1.60),
                        new Point(29.26, 44.66, 5.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(22.99, 38.95, -1.22),
                        new Point(15.37, 35.02, 4.44),
                        new Point(10.15, 35.98, 2.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-42.62, 63.80, 36.85),
                        new Point(-43.06, 55.75, 35.50),
                        new Point(-43.40, 60.19, 38.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-42.61, 62.12, 41.93),
                        new Point(-43.40, 60.19, 38.89),
                        new Point(-51.42, 57.53, 44.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-46.86, 50.97, 45.64),
                        new Point(-47.98, 53.84, 48.37),
                        new Point(-50.06, 55.99, 46.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.89, 59.81, 43.34),
                        new Point(-31.73, 61.46, 46.99),
                        new Point(-34.44, 51.45, 42.90))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.22, 67.00, 33.14),
                        new Point(-37.04, 62.33, 31.42),
                        new Point(-33.38, 63.29, 29.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.38, 63.29, 29.52),
                        new Point(-33.16, 65.38, 31.32),
                        new Point(-33.22, 67.00, 33.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.00, 37.81, 6.98),
                        new Point(-22.77, 47.36, 14.29),
                        new Point(0.71, 49.52, 4.60))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(0.71, 49.52, 4.60),
                        new Point(-10.53, 37.47, 3.77),
                        new Point(-20.00, 37.81, 6.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(2.96, 36.67, 2.99),
                        new Point(-10.17, 27.34, 8.16),
                        new Point(-10.53, 37.47, 3.77))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(2.96, 36.67, 2.99),
                        new Point(0.71, 49.52, 4.60),
                        new Point(10.79, 36.95, -0.30))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-14.95, 22.90, 10.14),
                        new Point(-20.00, 37.81, 6.98),
                        new Point(-10.53, 37.47, 3.77))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.67, 28.78, 6.66),
                        new Point(-28.38, 29.82, 12.92),
                        new Point(-20.00, 37.81, 6.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(15.72, 43.88, 14.54),
                        new Point(10.01, 34.92, 11.65),
                        new Point(16.70, 33.33, 6.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-6.85, 23.48, 17.38),
                        new Point(10.01, 34.92, 11.65),
                        new Point(0.07, 31.52, 26.03))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.05, 23.03, 30.43),
                        new Point(0.07, 31.52, 26.03),
                        new Point(-15.33, 35.16, 35.97))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-6.85, 23.48, 17.38),
                        new Point(0.07, 31.52, 26.03),
                        new Point(-8.35, 22.53, 22.68))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.35, 22.53, 22.68),
                        new Point(-10.71, 20.82, 19.38),
                        new Point(-6.85, 23.48, 17.38))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.54, -0.81, 2.35),
                        new Point(-27.79, -1.77, -0.71),
                        new Point(-29.71, -2.36, 0.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-11.37, 21.55, 28.31),
                        new Point(-15.05, 23.03, 30.43),
                        new Point(-19.38, 17.95, 25.67))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-13.63, -1.89, 18.43),
                        new Point(-17.87, -8.39, 20.00),
                        new Point(-16.00, -8.44, 20.66))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-11.37, 21.55, 28.31),
                        new Point(0.07, 31.52, 26.03),
                        new Point(-15.05, 23.03, 30.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.33, 35.16, 35.97),
                        new Point(-12.06, 42.87, 32.93),
                        new Point(-20.25, 42.26, 36.31))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.05, 23.03, 30.43),
                        new Point(-15.33, 35.16, 35.97),
                        new Point(-27.08, 38.47, 34.24))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.25, 42.26, 36.31),
                        new Point(-27.08, 38.47, 34.24),
                        new Point(-15.33, 35.16, 35.97))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-39.33, 66.09, 33.23),
                        new Point(-37.04, 62.33, 31.42),
                        new Point(-42.62, 63.80, 36.85))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.45, 65.43, 42.28),
                        new Point(-39.33, 66.09, 33.23),
                        new Point(-42.62, 63.80, 36.85))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-42.62, 63.80, 36.85),
                        new Point(-42.61, 62.12, 41.93),
                        new Point(-37.45, 65.43, 42.28))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-22.77, 47.36, 14.29),
                        new Point(-30.00, 45.43, 19.59),
                        new Point(-24.09, 53.95, 22.79))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.00, 37.81, 6.98),
                        new Point(-30.00, 45.43, 19.59),
                        new Point(-22.77, 47.36, 14.29))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-22.77, 47.36, 14.29),
                        new Point(-24.09, 53.95, 22.79),
                        new Point(-9.41, 50.67, 12.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.38, 29.82, 12.92),
                        new Point(-30.00, 45.43, 19.59),
                        new Point(-20.00, 37.81, 6.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.67, 28.78, 6.66),
                        new Point(-26.56, 24.89, 8.52),
                        new Point(-28.38, 29.82, 12.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.09, 45.13, 26.06),
                        new Point(-30.00, 45.43, 19.59),
                        new Point(-28.38, 29.82, 12.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.32, 14.77, 4.22),
                        new Point(-23.67, 28.78, 6.66),
                        new Point(-18.86, 24.36, 6.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-13.63, -1.89, 18.43),
                        new Point(-18.59, -6.47, 18.86),
                        new Point(-17.87, -8.39, 20.00))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.75, -0.04, 15.33),
                        new Point(-10.53, -6.77, 17.74),
                        new Point(-9.59, -6.18, 16.40))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.75, -0.04, 15.33),
                        new Point(-11.32, -3.33, 18.97),
                        new Point(-10.53, -6.77, 17.74))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.54, -0.81, 2.35),
                        new Point(-22.96, 2.26, 2.89),
                        new Point(-23.42, 1.65, 0.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-16.00, -8.44, 20.66),
                        new Point(-14.98, -8.32, 20.64),
                        new Point(-13.63, -1.89, 18.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-11.32, -3.33, 18.97),
                        new Point(-13.63, -1.89, 18.43),
                        new Point(-14.98, -8.32, 20.64))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.54, -0.81, 2.35),
                        new Point(-26.50, -1.16, -1.98),
                        new Point(-27.79, -1.77, -0.71))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.54, -0.81, 2.35),
                        new Point(-23.42, 1.65, 0.41),
                        new Point(-26.50, -1.16, -1.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-11.32, -3.33, 18.97),
                        new Point(-14.98, -8.32, 20.64),
                        new Point(-10.53, -6.77, 17.74))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(40.83, 14.09, -13.25),
                        new Point(42.35, 11.93, -17.55),
                        new Point(36.74, 9.32, -12.12))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(21.83, 35.56, 10.29),
                        new Point(24.21, 38.92, 11.21),
                        new Point(15.72, 43.88, 14.54))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(16.70, 33.33, 6.43),
                        new Point(32.11, 26.63, 1.89),
                        new Point(21.83, 35.56, 10.29))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.21, 38.92, 11.21),
                        new Point(21.83, 35.56, 10.29),
                        new Point(32.11, 26.63, 1.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.44, 22.62, -6.15),
                        new Point(35.20, 31.41, -1.60),
                        new Point(24.21, 38.92, 11.21))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.44, 22.62, -6.15),
                        new Point(24.21, 38.92, 11.21),
                        new Point(32.11, 26.63, 1.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(30.93, 34.57, -2.45),
                        new Point(33.75, 28.98, -5.68),
                        new Point(28.43, 31.62, -2.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.42, 1.65, 0.41),
                        new Point(-20.92, -1.40, 0.27),
                        new Point(-26.50, -1.16, -1.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.70, -1.33, 0.72),
                        new Point(-20.92, -1.40, 0.27),
                        new Point(-17.64, 3.82, 2.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.42, 1.65, 0.41),
                        new Point(-17.64, 3.82, 2.02),
                        new Point(-20.92, -1.40, 0.27))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(7.81, 52.49, 15.02),
                        new Point(14.59, 49.18, 16.66),
                        new Point(19.99, 51.68, 13.23))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-12.06, 42.87, 32.93),
                        new Point(7.81, 52.49, 15.02),
                        new Point(-6.88, 48.66, 23.10))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-43.06, 55.75, 35.50),
                        new Point(-42.62, 63.80, 36.85),
                        new Point(-37.04, 62.33, 31.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-51.42, 57.53, 44.65),
                        new Point(-50.19, 57.94, 48.11),
                        new Point(-42.61, 62.12, 41.93))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-24.09, 53.95, 22.79),
                        new Point(-6.88, 48.66, 23.10),
                        new Point(-9.41, 50.67, 12.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(8.95, 55.78, 5.08),
                        new Point(19.99, 51.68, 13.23),
                        new Point(21.05, 55.48, 2.49))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(19.99, 51.68, 13.23),
                        new Point(30.28, 52.09, 1.04),
                        new Point(21.05, 55.48, 2.49))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.48, 54.58, -0.72),
                        new Point(8.95, 55.78, 5.08),
                        new Point(21.05, 55.48, 2.49))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(21.05, 55.48, 2.49),
                        new Point(30.28, 52.09, 1.04),
                        new Point(26.90, 51.37, -2.32))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(8.95, 55.78, 5.08),
                        new Point(0.71, 49.52, 4.60),
                        new Point(-9.41, 50.67, 12.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.48, 54.58, -0.72),
                        new Point(21.05, 55.48, 2.49),
                        new Point(22.06, 48.12, -6.74))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(6.59, 50.88, 1.14),
                        new Point(14.90, 44.89, -7.42),
                        new Point(11.96, 42.19, -6.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(26.14, 39.11, -9.61),
                        new Point(25.48, 46.46, 0.74),
                        new Point(24.24, 27.21, -7.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.24, 27.21, -7.92),
                        new Point(30.12, 33.19, -14.81),
                        new Point(26.14, 39.11, -9.61))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.68, 27.10, -21.24),
                        new Point(33.79, 22.10, -16.04),
                        new Point(18.77, 29.35, -10.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(11.96, 42.19, -6.52),
                        new Point(14.90, 44.89, -7.42),
                        new Point(32.68, 27.10, -21.24))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(11.96, 42.19, -6.52),
                        new Point(32.68, 27.10, -21.24),
                        new Point(18.77, 29.35, -10.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.90, 44.89, -7.42),
                        new Point(26.14, 39.11, -9.61),
                        new Point(30.12, 33.19, -14.81))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(30.12, 33.19, -14.81),
                        new Point(32.68, 27.10, -21.24),
                        new Point(14.90, 44.89, -7.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(6.59, 50.88, 1.14),
                        new Point(11.96, 42.19, -6.52),
                        new Point(10.79, 36.95, -0.30))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.57, 51.09, -1.47),
                        new Point(25.48, 46.46, 0.74),
                        new Point(26.14, 39.11, -9.61))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.71, 18.28, 23.16),
                        new Point(-8.75, -0.04, 15.33),
                        new Point(-8.35, 22.53, 22.68))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.65, -0.25, 3.71),
                        new Point(-24.18, -3.27, 4.36),
                        new Point(-19.90, -1.91, 1.93))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.11, 26.63, 1.89),
                        new Point(25.77, 26.02, -3.44),
                        new Point(36.19, 21.12, -11.01))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(36.19, 21.12, -11.01),
                        new Point(41.44, 22.62, -6.15),
                        new Point(32.11, 26.63, 1.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(22.99, 38.95, -1.22),
                        new Point(25.48, 46.46, 0.74),
                        new Point(30.93, 34.57, -2.45))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.24, 27.21, -7.92),
                        new Point(22.99, 38.95, -1.22),
                        new Point(10.15, 35.98, 2.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(33.79, 22.10, -16.04),
                        new Point(24.24, 27.21, -7.92),
                        new Point(18.77, 29.35, -10.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(44.45, 13.12, -11.49),
                        new Point(41.44, 22.62, -6.15),
                        new Point(36.19, 21.12, -11.01))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(44.45, 13.12, -11.49),
                        new Point(40.58, 8.86, -9.77),
                        new Point(43.74, 11.69, -16.50))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(19.99, 51.68, 13.23),
                        new Point(29.26, 44.66, 5.33),
                        new Point(27.71, 50.17, 3.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.22, 34.22, 28.37),
                        new Point(-26.02, 28.77, 29.40),
                        new Point(-27.08, 38.47, 34.24))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.22, 34.22, 28.37),
                        new Point(-37.84, 50.76, 34.22),
                        new Point(-33.09, 45.13, 26.06))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.66, 24.20, 16.63),
                        new Point(-30.52, 30.64, 24.65),
                        new Point(-28.38, 29.82, 12.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.66, 24.20, 16.63),
                        new Point(-18.31, 23.55, 13.39),
                        new Point(-14.95, 22.90, 10.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-14.95, 22.90, 10.14),
                        new Point(-17.17, 21.77, 17.59),
                        new Point(-21.66, 24.20, 16.63))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-10.17, 27.34, 8.16),
                        new Point(2.96, 36.67, 2.99),
                        new Point(5.89, 34.36, 7.76))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-43.40, 60.19, 38.89),
                        new Point(-43.06, 55.75, 35.50),
                        new Point(-51.19, 55.57, 42.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-51.19, 55.57, 42.69),
                        new Point(-51.42, 57.53, 44.65),
                        new Point(-43.40, 60.19, 38.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.08, 38.47, 34.24),
                        new Point(-30.33, 50.60, 39.74),
                        new Point(-30.22, 34.22, 28.37))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.04, 62.33, 31.42),
                        new Point(-34.04, 62.99, 26.07),
                        new Point(-33.38, 63.29, 29.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.52, 30.64, 24.65),
                        new Point(-30.22, 34.22, 28.37),
                        new Point(-33.09, 45.13, 26.06))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.17, 21.77, 17.59),
                        new Point(-26.02, 28.77, 29.40),
                        new Point(-24.91, 25.91, 22.48))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.22, 34.22, 28.37),
                        new Point(-30.33, 50.60, 39.74),
                        new Point(-35.33, 49.70, 39.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.33, 49.70, 39.14),
                        new Point(-34.92, 48.02, 34.98),
                        new Point(-30.22, 34.22, 28.37))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-39.59, 57.36, 31.63),
                        new Point(-37.04, 62.33, 31.42),
                        new Point(-39.33, 66.09, 33.23))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-44.29, 52.36, 36.75),
                        new Point(-33.24, 54.81, 28.53),
                        new Point(-37.84, 50.76, 34.22))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.68, 50.34, 41.91),
                        new Point(-26.89, 59.81, 43.34),
                        new Point(-21.57, 56.36, 43.07))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.57, 56.36, 43.07),
                        new Point(-27.67, 46.14, 46.35),
                        new Point(-27.68, 50.34, 41.91))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-36.87, 60.83, 47.21),
                        new Point(-42.68, 58.54, 46.40),
                        new Point(-35.75, 57.98, 46.36))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-42.61, 62.12, 41.93),
                        new Point(-50.19, 57.94, 48.11),
                        new Point(-42.68, 58.54, 46.40))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-16.61, 50.90, 29.92),
                        new Point(-25.13, 57.74, 39.42),
                        new Point(-12.06, 42.87, 32.93))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.45, 65.43, 42.28),
                        new Point(-42.61, 62.12, 41.93),
                        new Point(-36.87, 60.83, 47.21))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.68, 62.70, 39.95),
                        new Point(-25.13, 57.74, 39.42),
                        new Point(-16.61, 50.90, 29.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-34.44, 51.45, 42.90),
                        new Point(-30.33, 50.60, 39.74),
                        new Point(-25.13, 57.74, 39.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-25.13, 57.74, 39.42),
                        new Point(-26.89, 59.81, 43.34),
                        new Point(-34.44, 51.45, 42.90))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-24.09, 53.95, 22.79),
                        new Point(-33.22, 67.00, 33.14),
                        new Point(-29.91, 65.60, 37.16))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-39.59, 57.36, 31.63),
                        new Point(-39.33, 66.09, 33.23),
                        new Point(-36.46, 67.02, 29.72))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-31.73, 61.46, 46.99),
                        new Point(-26.09, 62.97, 44.95),
                        new Point(-37.45, 65.43, 42.28))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.28, 58.69, 46.50),
                        new Point(-26.09, 62.97, 44.95),
                        new Point(-31.73, 61.46, 46.99))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.67, 46.14, 46.35),
                        new Point(-28.28, 58.69, 46.50),
                        new Point(-32.22, 53.24, 44.10))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-32.22, 53.24, 44.10),
                        new Point(-27.68, 50.34, 41.91),
                        new Point(-27.67, 46.14, 46.35))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.68, 50.34, 41.91),
                        new Point(-32.22, 53.24, 44.10),
                        new Point(-26.89, 59.81, 43.34))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.04, 62.33, 31.42),
                        new Point(-33.22, 67.00, 33.14),
                        new Point(-33.24, 54.81, 28.53))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-36.46, 67.02, 29.72),
                        new Point(-35.13, 64.61, 26.50),
                        new Point(-38.65, 60.87, 26.85))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-36.88, 54.56, 27.45),
                        new Point(-39.59, 57.36, 31.63),
                        new Point(-40.71, 53.50, 23.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.24, 54.81, 28.53),
                        new Point(-43.06, 55.75, 35.50),
                        new Point(-37.04, 62.33, 31.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-34.04, 62.99, 26.07),
                        new Point(-37.04, 62.33, 31.42),
                        new Point(-35.54, 61.49, 24.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.28, 58.69, 46.50),
                        new Point(-31.73, 61.46, 46.99),
                        new Point(-32.22, 53.24, 44.10))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.22, 67.00, 33.14),
                        new Point(-24.09, 53.95, 22.79),
                        new Point(-33.24, 54.81, 28.53))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.24, 54.81, 28.53),
                        new Point(-30.00, 45.43, 19.59),
                        new Point(-33.09, 45.13, 26.06))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-31.73, 61.46, 46.99),
                        new Point(-26.89, 59.81, 43.34),
                        new Point(-32.22, 53.24, 44.10))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-31.73, 61.46, 46.99),
                        new Point(-36.87, 60.83, 47.21),
                        new Point(-35.75, 57.98, 46.36))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.75, 57.98, 46.36),
                        new Point(-34.44, 51.45, 42.90),
                        new Point(-31.73, 61.46, 46.99))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.45, 65.43, 42.28),
                        new Point(-36.87, 60.83, 47.21),
                        new Point(-31.73, 61.46, 46.99))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.33, 50.60, 39.74),
                        new Point(-34.44, 51.45, 42.90),
                        new Point(-35.33, 49.70, 39.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-49.42, 52.14, 42.46),
                        new Point(-35.33, 49.70, 39.14),
                        new Point(-46.86, 50.97, 45.64))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-36.88, 54.56, 27.45),
                        new Point(-37.04, 62.33, 31.42),
                        new Point(-39.59, 57.36, 31.63))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-34.92, 48.02, 34.98),
                        new Point(-35.33, 49.70, 39.14),
                        new Point(-37.84, 50.76, 34.22))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-36.88, 54.56, 27.45),
                        new Point(-40.71, 53.50, 23.52),
                        new Point(-35.54, 61.49, 24.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.54, 61.49, 24.69),
                        new Point(-37.04, 62.33, 31.42),
                        new Point(-36.88, 54.56, 27.45))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.22, 67.00, 33.14),
                        new Point(-33.16, 65.38, 31.32),
                        new Point(-34.53, 66.53, 31.77))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.84, 50.76, 34.22),
                        new Point(-35.33, 49.70, 39.14),
                        new Point(-44.29, 52.36, 36.75))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.22, 34.22, 28.37),
                        new Point(-30.52, 30.64, 24.65),
                        new Point(-26.02, 28.77, 29.40))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.24, 54.81, 28.53),
                        new Point(-33.09, 45.13, 26.06),
                        new Point(-37.84, 50.76, 34.22))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.24, 54.81, 28.53),
                        new Point(-44.29, 52.36, 36.75),
                        new Point(-43.06, 55.75, 35.50))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-49.42, 52.14, 42.46),
                        new Point(-44.29, 52.36, 36.75),
                        new Point(-35.33, 49.70, 39.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-29.91, 65.60, 37.16),
                        new Point(-33.22, 67.00, 33.14),
                        new Point(-39.33, 66.09, 33.23))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-24.91, 25.91, 22.48),
                        new Point(-30.52, 30.64, 24.65),
                        new Point(-21.66, 24.20, 16.63))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.02, 28.77, 29.40),
                        new Point(-19.38, 17.95, 25.67),
                        new Point(-15.05, 23.03, 30.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.38, 29.82, 12.92),
                        new Point(-30.52, 30.64, 24.65),
                        new Point(-33.09, 45.13, 26.06))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-24.91, 25.91, 22.48),
                        new Point(-26.02, 28.77, 29.40),
                        new Point(-30.52, 30.64, 24.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.66, 24.20, 16.63),
                        new Point(-17.17, 21.77, 17.59),
                        new Point(-24.91, 25.91, 22.48))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-29.91, 65.60, 37.16),
                        new Point(-39.33, 66.09, 33.23),
                        new Point(-37.45, 65.43, 42.28))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.68, 62.70, 39.95),
                        new Point(-29.91, 65.60, 37.16),
                        new Point(-26.09, 62.97, 44.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-16.61, 50.90, 29.92),
                        new Point(-29.91, 65.60, 37.16),
                        new Point(-26.68, 62.70, 39.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-29.91, 65.60, 37.16),
                        new Point(-16.61, 50.90, 29.92),
                        new Point(-24.09, 53.95, 22.79))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-25.13, 57.74, 39.42),
                        new Point(-30.33, 50.60, 39.74),
                        new Point(-20.25, 42.26, 36.31))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-12.06, 42.87, 32.93),
                        new Point(-25.13, 57.74, 39.42),
                        new Point(-20.25, 42.26, 36.31))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-30.33, 50.60, 39.74),
                        new Point(-27.08, 38.47, 34.24),
                        new Point(-20.25, 42.26, 36.31))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.28, 58.69, 46.50),
                        new Point(-21.57, 56.36, 43.07),
                        new Point(-26.09, 62.97, 44.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-47.98, 53.84, 48.37),
                        new Point(-34.44, 51.45, 42.90),
                        new Point(-35.75, 57.98, 46.36))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.75, 57.98, 46.36),
                        new Point(-42.68, 58.54, 46.40),
                        new Point(-47.98, 53.84, 48.37))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.09, 62.97, 44.95),
                        new Point(-25.61, 60.35, 42.19),
                        new Point(-25.13, 57.74, 39.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-42.68, 58.54, 46.40),
                        new Point(-36.87, 60.83, 47.21),
                        new Point(-42.61, 62.12, 41.93))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-50.19, 57.94, 48.11),
                        new Point(-47.98, 53.84, 48.37),
                        new Point(-42.68, 58.54, 46.40))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-25.13, 57.74, 39.42),
                        new Point(-26.68, 62.70, 39.95),
                        new Point(-26.09, 62.97, 44.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-46.86, 50.97, 45.64),
                        new Point(-50.06, 55.99, 46.43),
                        new Point(-49.42, 52.14, 42.46))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-25.13, 57.74, 39.42),
                        new Point(-25.61, 60.35, 42.19),
                        new Point(-26.89, 59.81, 43.34))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-49.42, 52.14, 42.46),
                        new Point(-51.19, 55.57, 42.69),
                        new Point(-44.29, 52.36, 36.75))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.67, 46.14, 46.35),
                        new Point(-21.57, 56.36, 43.07),
                        new Point(-28.28, 58.69, 46.50))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-37.45, 65.43, 42.28),
                        new Point(-26.09, 62.97, 44.95),
                        new Point(-29.91, 65.60, 37.16))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-43.06, 55.75, 35.50),
                        new Point(-44.29, 52.36, 36.75),
                        new Point(-51.19, 55.57, 42.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(26.14, 39.11, -9.61),
                        new Point(14.90, 44.89, -7.42),
                        new Point(22.06, 48.12, -6.74))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.05, 13.80, -22.98),
                        new Point(38.96, 14.11, -24.41),
                        new Point(38.21, 29.52, -16.99))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(35.54, 17.37, -25.33),
                        new Point(38.21, 29.52, -16.99),
                        new Point(38.96, 14.11, -24.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.56, 28.31, -10.86),
                        new Point(43.74, 11.69, -16.50),
                        new Point(43.05, 12.57, -19.08))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.56, 28.31, -10.86),
                        new Point(44.45, 13.12, -11.49),
                        new Point(43.74, 11.69, -16.50))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.66, 24.20, 16.63),
                        new Point(-23.65, 22.43, 14.52),
                        new Point(-25.65, 20.65, 12.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-25.65, 20.65, 12.41),
                        new Point(-19.50, 20.16, 11.96),
                        new Point(-21.66, 24.20, 16.63))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-19.38, 17.95, 25.67),
                        new Point(-17.17, 21.77, 17.59),
                        new Point(-10.71, 20.82, 19.38))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.17, 21.77, 17.59),
                        new Point(-6.85, 23.48, 17.38),
                        new Point(-10.71, 20.82, 19.38))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(11.96, 42.19, -6.52),
                        new Point(18.77, 29.35, -10.65),
                        new Point(10.79, 36.95, -0.30))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.24, 27.21, -7.92),
                        new Point(10.15, 35.98, 2.42),
                        new Point(10.79, 36.95, -0.30))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(43.05, 12.57, -19.08),
                        new Point(42.13, 12.31, -18.64),
                        new Point(41.56, 28.31, -10.86))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(16.70, 33.33, 6.43),
                        new Point(25.77, 26.02, -3.44),
                        new Point(32.11, 26.63, 1.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(5.89, 34.36, 7.76),
                        new Point(2.96, 36.67, 2.99),
                        new Point(10.15, 35.98, 2.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(10.15, 35.98, 2.42),
                        new Point(15.37, 35.02, 4.44),
                        new Point(5.89, 34.36, 7.76))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(10.01, 34.92, 11.65),
                        new Point(15.37, 35.02, 4.44),
                        new Point(16.70, 33.33, 6.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(10.79, 36.95, -0.30),
                        new Point(10.15, 35.98, 2.42),
                        new Point(2.96, 36.67, 2.99))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(5.89, 34.36, 7.76),
                        new Point(15.37, 35.02, 4.44),
                        new Point(10.01, 34.92, 11.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(10.79, 36.95, -0.30),
                        new Point(18.77, 29.35, -10.65),
                        new Point(24.24, 27.21, -7.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(16.70, 33.33, 6.43),
                        new Point(15.37, 35.02, 4.44),
                        new Point(25.77, 26.02, -3.44))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(21.83, 35.56, 10.29),
                        new Point(15.72, 43.88, 14.54),
                        new Point(16.70, 33.33, 6.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.59, 49.18, 16.66),
                        new Point(15.72, 43.88, 14.54),
                        new Point(24.21, 38.92, 11.21))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.59, 49.18, 16.66),
                        new Point(9.12, 45.14, 19.02),
                        new Point(15.72, 43.88, 14.54))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(7.81, 52.49, 15.02),
                        new Point(9.12, 45.14, 19.02),
                        new Point(14.59, 49.18, 16.66))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(6.59, 50.88, 1.14),
                        new Point(0.71, 49.52, 4.60),
                        new Point(8.95, 55.78, 5.08))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(8.95, 55.78, 5.08),
                        new Point(14.48, 54.58, -0.72),
                        new Point(6.59, 50.88, 1.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.59, 49.18, 16.66),
                        new Point(24.21, 38.92, 11.21),
                        new Point(19.99, 51.68, 13.23))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(6.59, 50.88, 1.14),
                        new Point(14.48, 54.58, -0.72),
                        new Point(14.90, 44.89, -7.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(19.99, 51.68, 13.23),
                        new Point(24.21, 38.92, 11.21),
                        new Point(29.26, 44.66, 5.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(15.72, 43.88, 14.54),
                        new Point(9.12, 45.14, 19.02),
                        new Point(10.01, 34.92, 11.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-6.85, 23.48, 17.38),
                        new Point(5.89, 34.36, 7.76),
                        new Point(10.01, 34.92, 11.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-11.37, 21.55, 28.31),
                        new Point(-8.71, 18.28, 23.16),
                        new Point(-8.35, 22.53, 22.68))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.32, 14.77, 4.22),
                        new Point(-18.86, 24.36, 6.89),
                        new Point(-14.95, 22.90, 10.14))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(36.19, 21.12, -11.01),
                        new Point(41.56, 28.31, -10.86),
                        new Point(42.13, 12.31, -18.64))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(35.54, 17.37, -25.33),
                        new Point(37.28, 15.61, -19.95),
                        new Point(33.79, 22.10, -16.04))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.21, 29.52, -16.99),
                        new Point(33.79, 22.10, -16.04),
                        new Point(37.28, 15.61, -19.95))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.24, 27.21, -7.92),
                        new Point(38.21, 29.52, -16.99),
                        new Point(30.12, 33.19, -14.81))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.21, 29.52, -16.99),
                        new Point(32.68, 27.10, -21.24),
                        new Point(30.12, 33.19, -14.81))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.56, 28.31, -10.86),
                        new Point(33.75, 28.98, -5.68),
                        new Point(30.93, 34.57, -2.45))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(35.20, 31.41, -1.60),
                        new Point(41.56, 28.31, -10.86),
                        new Point(30.93, 34.57, -2.45))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.44, 22.62, -6.15),
                        new Point(41.56, 28.31, -10.86),
                        new Point(35.20, 31.41, -1.60))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-11.32, -3.33, 18.97),
                        new Point(-19.38, 17.95, 25.67),
                        new Point(-13.63, -1.89, 18.43))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-19.38, 17.95, 25.67),
                        new Point(-11.32, -3.33, 18.97),
                        new Point(-11.37, 21.55, 28.31))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-19.38, 17.95, 25.67),
                        new Point(-10.71, 20.82, 19.38),
                        new Point(-15.54, -3.40, 14.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.54, -3.40, 14.69),
                        new Point(-10.71, 20.82, 19.38),
                        new Point(-8.75, -0.04, 15.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.64, 3.82, 2.02),
                        new Point(-19.90, -1.91, 1.93),
                        new Point(-18.70, -1.33, 0.72))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.64, 3.82, 2.02),
                        new Point(-20.65, -0.25, 3.71),
                        new Point(-19.90, -1.91, 1.93))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-14.95, 22.90, 10.14),
                        new Point(-18.43, 12.43, 6.30),
                        new Point(-17.64, 3.82, 2.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.32, 14.77, 4.22),
                        new Point(-14.95, 22.90, 10.14),
                        new Point(-17.64, 3.82, 2.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-25.65, 20.65, 12.41),
                        new Point(-23.42, 1.65, 0.41),
                        new Point(-22.96, 2.26, 2.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.67, 28.78, 6.66),
                        new Point(-17.32, 14.77, 4.22),
                        new Point(-23.42, 1.65, 0.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.67, 28.78, 6.66),
                        new Point(-23.42, 1.65, 0.41),
                        new Point(-26.56, 24.89, 8.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.35, 22.53, 22.68),
                        new Point(-8.75, -0.04, 15.33),
                        new Point(-10.71, 20.82, 19.38))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.71, 18.28, 23.16),
                        new Point(-11.37, 21.55, 28.31),
                        new Point(-11.32, -3.33, 18.97))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.21, 29.52, -16.99),
                        new Point(39.70, 13.36, -22.17),
                        new Point(41.05, 13.80, -22.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.21, 29.52, -16.99),
                        new Point(37.28, 15.61, -19.95),
                        new Point(39.70, 13.36, -22.17))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.21, 29.52, -16.99),
                        new Point(24.24, 27.21, -7.92),
                        new Point(33.79, 22.10, -16.04))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(35.54, 17.37, -25.33),
                        new Point(38.96, 14.11, -24.41),
                        new Point(31.87, 13.65, -25.20))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-9.59, -6.18, 16.40),
                        new Point(-12.72, -6.30, 15.82),
                        new Point(-8.75, -0.04, 15.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.54, -3.40, 14.69),
                        new Point(-8.75, -0.04, 15.33),
                        new Point(-12.72, -6.30, 15.82))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.57, 51.09, -1.47),
                        new Point(26.14, 39.11, -9.61),
                        new Point(22.06, 48.12, -6.74))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(29.26, 44.66, 5.33),
                        new Point(35.20, 31.41, -1.60),
                        new Point(30.93, 34.57, -2.45))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(30.93, 34.57, -2.45),
                        new Point(27.71, 50.17, 3.69),
                        new Point(29.26, 44.66, 5.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(25.48, 46.46, 0.74),
                        new Point(27.71, 50.17, 3.69),
                        new Point(30.93, 34.57, -2.45))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(25.48, 46.46, 0.74),
                        new Point(24.57, 51.09, -1.47),
                        new Point(27.71, 50.17, 3.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(30.28, 52.09, 1.04),
                        new Point(27.71, 50.17, 3.69),
                        new Point(32.31, 46.95, -1.34))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.31, 46.95, -1.34),
                        new Point(33.57, 48.15, -2.58),
                        new Point(30.28, 52.09, 1.04))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(19.99, 51.68, 13.23),
                        new Point(27.71, 50.17, 3.69),
                        new Point(30.28, 52.09, 1.04))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(21.05, 55.48, 2.49),
                        new Point(26.90, 51.37, -2.32),
                        new Point(24.57, 51.09, -1.47))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(14.48, 54.58, -0.72),
                        new Point(22.06, 48.12, -6.74),
                        new Point(14.90, 44.89, -7.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.57, 51.09, -1.47),
                        new Point(22.06, 48.12, -6.74),
                        new Point(21.05, 55.48, 2.49))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(19.99, 51.68, 13.23),
                        new Point(8.95, 55.78, 5.08),
                        new Point(7.81, 52.49, 15.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(2.96, 36.67, 2.99),
                        new Point(-10.53, 37.47, 3.77),
                        new Point(0.71, 49.52, 4.60))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(0.07, 31.52, 26.03),
                        new Point(10.01, 34.92, 11.65),
                        new Point(9.12, 45.14, 19.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(0.07, 31.52, 26.03),
                        new Point(9.12, 45.14, 19.02),
                        new Point(-12.06, 42.87, 32.93))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(7.81, 52.49, 15.02),
                        new Point(-12.06, 42.87, 32.93),
                        new Point(9.12, 45.14, 19.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(6.59, 50.88, 1.14),
                        new Point(10.79, 36.95, -0.30),
                        new Point(0.71, 49.52, 4.60))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-16.61, 50.90, 29.92),
                        new Point(-12.06, 42.87, 32.93),
                        new Point(-6.88, 48.66, 23.10))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-9.41, 50.67, 12.69),
                        new Point(0.71, 49.52, 4.60),
                        new Point(-22.77, 47.36, 14.29))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-6.88, 48.66, 23.10),
                        new Point(-24.09, 53.95, 22.79),
                        new Point(-16.61, 50.90, 29.92))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-9.41, 50.67, 12.69),
                        new Point(-6.88, 48.66, 23.10),
                        new Point(7.81, 52.49, 15.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(7.81, 52.49, 15.02),
                        new Point(8.95, 55.78, 5.08),
                        new Point(-9.41, 50.67, 12.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-12.06, 42.87, 32.93),
                        new Point(-15.33, 35.16, 35.97),
                        new Point(0.07, 31.52, 26.03))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.17, 21.77, 17.59),
                        new Point(-19.38, 17.95, 25.67),
                        new Point(-26.02, 28.77, 29.40))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-14.95, 22.90, 10.14),
                        new Point(-10.17, 27.34, 8.16),
                        new Point(-6.85, 23.48, 17.38))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-14.95, 22.90, 10.14),
                        new Point(-6.85, 23.48, 17.38),
                        new Point(-17.17, 21.77, 17.59))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.02, 28.77, 29.40),
                        new Point(-15.05, 23.03, 30.43),
                        new Point(-27.08, 38.47, 34.24))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.19, 11.44, 7.82),
                        new Point(-19.50, 20.16, 11.96),
                        new Point(-25.65, 20.65, 12.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.54, -3.40, 14.69),
                        new Point(-12.72, -6.30, 15.82),
                        new Point(-18.65, -6.72, 15.26))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.59, -6.47, 18.86),
                        new Point(-18.65, -6.72, 15.26),
                        new Point(-19.58, -7.62, 17.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.59, -6.47, 18.86),
                        new Point(-15.54, -3.40, 14.69),
                        new Point(-18.65, -6.72, 15.26))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(28.43, 31.62, -2.42),
                        new Point(33.75, 28.98, -5.68),
                        new Point(25.77, 26.02, -3.44))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-8.75, -0.04, 15.33),
                        new Point(-8.71, 18.28, 23.16),
                        new Point(-11.32, -3.33, 18.97))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(30.93, 34.57, -2.45),
                        new Point(28.43, 31.62, -2.42),
                        new Point(22.99, 38.95, -1.22))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(25.77, 26.02, -3.44),
                        new Point(22.99, 38.95, -1.22),
                        new Point(28.43, 31.62, -2.42))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(33.57, 48.15, -2.58),
                        new Point(31.51, 48.60, -4.35),
                        new Point(26.90, 51.37, -2.32))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(26.90, 51.37, -2.32),
                        new Point(30.28, 52.09, 1.04),
                        new Point(33.57, 48.15, -2.58))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.31, 46.95, -1.34),
                        new Point(31.51, 48.60, -4.35),
                        new Point(33.57, 48.15, -2.58))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.00, 37.81, 6.98),
                        new Point(-14.95, 22.90, 10.14),
                        new Point(-18.86, 24.36, 6.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.67, 28.78, 6.66),
                        new Point(-20.00, 37.81, 6.98),
                        new Point(-18.86, 24.36, 6.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-15.54, -3.40, 14.69),
                        new Point(-13.63, -1.89, 18.43),
                        new Point(-19.38, 17.95, 25.67))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-22.96, 2.26, 2.89),
                        new Point(-21.19, 11.44, 7.82),
                        new Point(-25.65, 20.65, 12.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.19, 11.44, 7.82),
                        new Point(-17.64, 3.82, 2.02),
                        new Point(-18.43, 12.43, 6.30))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.59, -6.47, 18.86),
                        new Point(-19.58, -7.62, 17.42),
                        new Point(-17.87, -8.39, 20.00))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.31, 46.95, -1.34),
                        new Point(27.71, 50.17, 3.69),
                        new Point(26.90, 51.37, -2.32))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(26.90, 51.37, -2.32),
                        new Point(31.51, 48.60, -4.35),
                        new Point(32.31, 46.95, -1.34))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(24.57, 51.09, -1.47),
                        new Point(26.90, 51.37, -2.32),
                        new Point(27.71, 50.17, 3.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-50.06, 55.99, 46.43),
                        new Point(-51.19, 55.57, 42.69),
                        new Point(-49.42, 52.14, 42.46))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-51.19, 55.57, 42.69),
                        new Point(-50.06, 55.99, 46.43),
                        new Point(-51.42, 57.53, 44.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-34.53, 66.53, 31.77),
                        new Point(-33.16, 65.38, 31.32),
                        new Point(-33.38, 63.29, 29.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.38, 63.29, 29.52),
                        new Point(-36.46, 67.02, 29.72),
                        new Point(-34.53, 66.53, 31.77))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-33.38, 63.29, 29.52),
                        new Point(-34.04, 62.99, 26.07),
                        new Point(-35.13, 64.61, 26.50))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.13, 64.61, 26.50),
                        new Point(-36.46, 67.02, 29.72),
                        new Point(-33.38, 63.29, 29.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.13, 64.61, 26.50),
                        new Point(-34.04, 62.99, 26.07),
                        new Point(-35.54, 61.49, 24.69))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-50.19, 57.94, 48.11),
                        new Point(-50.06, 55.99, 46.43),
                        new Point(-47.98, 53.84, 48.37))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-50.06, 55.99, 46.43),
                        new Point(-50.19, 57.94, 48.11),
                        new Point(-51.42, 57.53, 44.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-35.13, 64.61, 26.50),
                        new Point(-35.54, 61.49, 24.69),
                        new Point(-38.65, 60.87, 26.85))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-38.65, 60.87, 26.85),
                        new Point(-35.54, 61.49, 24.69),
                        new Point(-40.71, 53.50, 23.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-36.46, 67.02, 29.72),
                        new Point(-38.65, 60.87, 26.85),
                        new Point(-39.59, 57.36, 31.63))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-38.65, 60.87, 26.85),
                        new Point(-40.71, 53.50, 23.52),
                        new Point(-39.59, 57.36, 31.63))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-17.32, 14.77, 4.22),
                        new Point(-17.64, 3.82, 2.02),
                        new Point(-23.42, 1.65, 0.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.38, 29.82, 12.92),
                        new Point(-26.56, 24.89, 8.52),
                        new Point(-25.65, 20.65, 12.41))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-14.95, 22.90, 10.14),
                        new Point(-19.50, 20.16, 11.96),
                        new Point(-18.43, 12.43, 6.30))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.19, 11.44, 7.82),
                        new Point(-18.43, 12.43, 6.30),
                        new Point(-19.50, 20.16, 11.96))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.66, 24.20, 16.63),
                        new Point(-19.50, 20.16, 11.96),
                        new Point(-18.31, 23.55, 13.39))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-19.50, 20.16, 11.96),
                        new Point(-14.95, 22.90, 10.14),
                        new Point(-18.31, 23.55, 13.39))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.66, 24.20, 16.63),
                        new Point(-28.38, 29.82, 12.92),
                        new Point(-23.65, 22.43, 14.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-28.38, 29.82, 12.92),
                        new Point(-25.65, 20.65, 12.41),
                        new Point(-23.65, 22.43, 14.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(44.45, 13.12, -11.49),
                        new Point(36.19, 21.12, -11.01),
                        new Point(40.83, 14.09, -13.25))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(40.83, 14.09, -13.25),
                        new Point(36.19, 21.12, -11.01),
                        new Point(42.13, 12.31, -18.64))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(40.83, 14.09, -13.25),
                        new Point(42.13, 12.31, -18.64),
                        new Point(42.35, 11.93, -17.55))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.68, 27.10, -21.24),
                        new Point(35.54, 17.37, -25.33),
                        new Point(33.79, 22.10, -16.04))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(41.44, 22.62, -6.15),
                        new Point(44.45, 13.12, -11.49),
                        new Point(41.56, 28.31, -10.86))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(32.68, 27.10, -21.24),
                        new Point(38.21, 29.52, -16.99),
                        new Point(35.54, 17.37, -25.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(33.75, 28.98, -5.68),
                        new Point(36.19, 21.12, -11.01),
                        new Point(25.77, 26.02, -3.44))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-21.19, 11.44, 7.82),
                        new Point(-20.65, -0.25, 3.71),
                        new Point(-17.64, 3.82, 2.02))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.65, -0.25, 3.71),
                        new Point(-21.19, 11.44, 7.82),
                        new Point(-22.96, 2.26, 2.89))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(36.19, 21.12, -11.01),
                        new Point(33.75, 28.98, -5.68),
                        new Point(41.56, 28.31, -10.86))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-23.42, 1.65, 0.41),
                        new Point(-25.65, 20.65, 12.41),
                        new Point(-26.56, 24.89, 8.52))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-12.72, -6.30, 15.82),
                        new Point(-10.53, -6.77, 17.74),
                        new Point(-14.98, -8.32, 20.64))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.65, -6.72, 15.26),
                        new Point(-12.72, -6.30, 15.82),
                        new Point(-16.00, -8.44, 20.66))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-19.58, -7.62, 17.42),
                        new Point(-18.65, -6.72, 15.26),
                        new Point(-17.87, -8.39, 20.00))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-12.72, -6.30, 15.82),
                        new Point(-9.59, -6.18, 16.40),
                        new Point(-10.53, -6.77, 17.74))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-12.72, -6.30, 15.82),
                        new Point(-14.98, -8.32, 20.64),
                        new Point(-16.00, -8.44, 20.66))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.65, -6.72, 15.26),
                        new Point(-16.00, -8.44, 20.66),
                        new Point(-17.87, -8.39, 20.00))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.96, 14.11, -24.41),
                        new Point(39.70, 13.36, -22.17),
                        new Point(31.00, 12.25, -21.68))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.96, 14.11, -24.41),
                        new Point(41.05, 13.80, -22.98),
                        new Point(39.70, 13.36, -22.17))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(39.70, 13.36, -22.17),
                        new Point(31.55, 11.64, -19.86),
                        new Point(31.00, 12.25, -21.68))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(38.96, 14.11, -24.41),
                        new Point(31.00, 12.25, -21.68),
                        new Point(31.87, 13.65, -25.20))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.79, -1.77, -0.71),
                        new Point(-24.18, -3.27, 4.36),
                        new Point(-27.33, -3.34, 3.65))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-26.50, -1.16, -1.98),
                        new Point(-24.18, -3.27, 4.36),
                        new Point(-27.79, -1.77, -0.71))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-27.79, -1.77, -0.71),
                        new Point(-27.33, -3.34, 3.65),
                        new Point(-29.71, -2.36, 0.33))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.92, -1.40, 0.27),
                        new Point(-19.90, -1.91, 1.93),
                        new Point(-24.18, -3.27, 4.36))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-20.92, -1.40, 0.27),
                        new Point(-24.18, -3.27, 4.36),
                        new Point(-26.50, -1.16, -1.98))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(-18.70, -1.33, 0.72),
                        new Point(-19.90, -1.91, 1.93),
                        new Point(-20.92, -1.40, 0.27))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(42.13, 12.31, -18.64),
                        new Point(43.05, 12.57, -19.08),
                        new Point(42.35, 11.93, -17.55))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(42.35, 11.93, -17.55),
                        new Point(43.05, 12.57, -19.08),
                        new Point(43.74, 11.69, -16.50))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(39.09, 8.87, -10.24),
                        new Point(43.74, 11.69, -16.50),
                        new Point(40.58, 8.86, -9.77))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(42.35, 11.93, -17.55), new Point(43.74, 11.69, -16.50),
                        new Point(39.09, 8.87, -10.24))
                        .setEmission(dogColor).setMaterial(dogMaterial),
                new Triangle(new Point(42.35, 11.93, -17.55),
                        new Point(39.09, 8.87, -10.24),
                        new Point(36.74, 9.32, -12.12))
                        .setEmission(dogColor).setMaterial(dogMaterial),


                new Plane(new Point(0.74, 0.62, 0.26), new Point(-0.50, 0.76, -0.41), new Point(-0.45, 0.17, 0.88))
                        .setEmission(new Color(95, 95, 95))
                        .setMaterial(new Material().setkD(0.4).setShininess(40)),

                new Triangle(new Point(-10.10, -6.45, 253.77),
                        new Point(-3.56, -7.49, 260.23),
                        new Point(-7.16, -6.59, 257.20))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.56, -7.49, 260.23),
                        new Point(5.47, -6.55, 258.51),
                        new Point(5.89, -6.23, 259.54))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.00, -5.69, 253.95),
                        new Point(-10.10, -6.45, 253.77),
                        new Point(-7.16, -6.59, 257.20))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.27, 1.49, 237.95),
                        new Point(3.30, 0.88, 237.84),
                        new Point(-1.56, 1.18, 237.40))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(12.15, -1.94, 247.98),
                        new Point(10.72, 0.12, 243.78),
                        new Point(12.17, -1.32, 248.20))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(11.77, -3.04, 252.73),
                        new Point(9.56, -5.34, 256.43),
                        new Point(12.17, -1.32, 248.20))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(10.72, 0.12, 243.78),
                        new Point(7.57, 0.51, 240.06),
                        new Point(3.27, 1.49, 237.95))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.89, -6.23, 259.54),
                        new Point(5.47, -6.55, 258.51),
                        new Point(9.56, -5.34, 256.43))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.56, -7.49, 260.23),
                        new Point(-10.10, -6.45, 253.77),
                        new Point(5.47, -6.55, 258.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-12.10, -2.92, 245.45),
                        new Point(-9.88, -1.21, 241.47),
                        new Point(-6.06, -0.37, 238.52))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.27, 1.49, 237.95),
                        new Point(7.57, 0.51, 240.06),
                        new Point(3.30, 0.88, 237.84))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.56, 1.18, 237.40),
                        new Point(3.30, 0.88, 237.84),
                        new Point(-6.06, -0.37, 238.52))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(12.17, -1.32, 248.20),
                        new Point(9.56, -5.34, 256.43),
                        new Point(12.15, -1.94, 247.98))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(10.72, 0.12, 243.78),
                        new Point(12.15, -1.94, 247.98),
                        new Point(7.57, 0.51, 240.06))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.88, -1.21, 241.47),
                        new Point(-1.56, 1.18, 237.40),
                        new Point(-6.06, -0.37, 238.52))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(9.56, -5.34, 256.43),
                        new Point(11.77, -3.04, 252.73),
                        new Point(5.89, -6.23, 259.54))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.22, -7.42, 259.65),
                        new Point(5.47, -6.55, 258.51),
                        new Point(-3.24, -7.71, 259.14))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.10, -6.45, 253.77),
                        new Point(-3.24, -7.71, 259.14),
                        new Point(5.47, -6.55, 258.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.47, -6.55, 258.51),
                        new Point(8.88, -5.22, 255.90),
                        new Point(9.56, -5.34, 256.43))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(9.56, -5.34, 256.43),
                        new Point(8.88, -5.22, 255.90),
                        new Point(10.93, -3.64, 252.23))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(10.93, -3.64, 252.23),
                        new Point(11.30, -2.05, 248.04),
                        new Point(12.15, -1.94, 247.98))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(12.15, -1.94, 247.98),
                        new Point(11.30, -2.05, 248.04),
                        new Point(9.93, -0.69, 243.98))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(10.93, -3.64, 252.23),
                        new Point(12.15, -1.94, 247.98),
                        new Point(9.56, -5.34, 256.43))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.10, -6.45, 253.77),
                        new Point(-10.00, -5.69, 253.95),
                        new Point(-11.47, -5.09, 249.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-12.10, -2.92, 245.45),
                        new Point(-11.10, -3.50, 245.53),
                        new Point(-11.47, -5.09, 249.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-11.47, -5.09, 249.71),
                        new Point(-10.00, -5.69, 253.95),
                        new Point(-12.10, -2.92, 245.45))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.06, -0.37, 238.52),
                        new Point(-9.06, -1.92, 241.85),
                        new Point(-11.10, -3.50, 245.53))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-11.10, -3.50, 245.53),
                        new Point(-12.10, -2.92, 245.45),
                        new Point(-6.06, -0.37, 238.52))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(9.93, -0.69, 243.98),
                        new Point(3.07, 0.57, 238.61),
                        new Point(7.57, 0.51, 240.06))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(12.15, -1.94, 247.98),
                        new Point(9.93, -0.69, 243.98),
                        new Point(7.57, 0.51, 240.06))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.07, 0.57, 238.61),
                        new Point(3.30, 0.88, 237.84),
                        new Point(7.57, 0.51, 240.06))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.39, 0.29, 238.11),
                        new Point(3.30, 0.88, 237.84),
                        new Point(3.07, 0.57, 238.61))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.06, -0.37, 238.52),
                        new Point(3.30, 0.88, 237.84),
                        new Point(-1.39, 0.29, 238.11))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.06, -1.92, 241.85),
                        new Point(-6.06, -0.37, 238.52),
                        new Point(-1.39, 0.29, 238.11))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-12.10, -2.92, 245.45),
                        new Point(-10.98, -2.79, 245.85),
                        new Point(-9.88, -1.21, 241.47))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.98, -2.79, 245.85),
                        new Point(-12.10, -2.92, 245.45),
                        new Point(-11.34, -4.35, 249.96))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.88, -1.21, 241.47),
                        new Point(-8.97, -1.24, 242.24),
                        new Point(-1.56, 1.18, 237.40))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.97, -1.24, 242.24),
                        new Point(-9.88, -1.21, 241.47),
                        new Point(-10.98, -2.79, 245.85))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.00, -5.69, 253.95),
                        new Point(-11.34, -4.35, 249.96),
                        new Point(-12.10, -2.92, 245.45))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-5.62, 0.07, 239.68),
                        new Point(-1.56, 1.18, 237.40),
                        new Point(-8.97, -1.24, 242.24))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.56, 1.18, 237.40),
                        new Point(-1.44, 0.93, 238.56),
                        new Point(3.27, 1.49, 237.95))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.44, 0.93, 238.56),
                        new Point(-1.56, 1.18, 237.40),
                        new Point(-5.62, 0.07, 239.68))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.84, 0.87, 241.08),
                        new Point(3.27, 1.49, 237.95),
                        new Point(-1.44, 0.93, 238.56))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.27, 1.49, 237.95),
                        new Point(6.84, 0.87, 241.08),
                        new Point(10.72, 0.12, 243.78))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.56, -7.49, 260.23),
                        new Point(1.12, -6.65, 259.72),
                        new Point(-7.16, -6.59, 257.20))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.12, -6.65, 259.72),
                        new Point(5.89, -6.23, 259.54),
                        new Point(5.23, -5.59, 258.58))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.89, -6.23, 259.54),
                        new Point(1.12, -6.65, 259.72),
                        new Point(-3.56, -7.49, 260.23))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.23, -5.59, 258.58),
                        new Point(5.89, -6.23, 259.54),
                        new Point(11.77, -3.04, 252.73))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(9.68, -0.03, 244.33),
                        new Point(12.17, -1.32, 248.20),
                        new Point(10.72, 0.12, 243.78))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(12.17, -1.32, 248.20),
                        new Point(9.68, -0.03, 244.33),
                        new Point(8.55, -4.29, 256.04))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(9.68, -0.03, 244.33),
                        new Point(10.72, 0.12, 243.78),
                        new Point(6.84, 0.87, 241.08))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(11.77, -3.04, 252.73),
                        new Point(8.55, -4.29, 256.04),
                        new Point(5.23, -5.59, 258.58))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(8.55, -4.29, 256.04),
                        new Point(11.77, -3.04, 252.73),
                        new Point(12.17, -1.32, 248.20))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.53, -2.97, 254.03),
                        new Point(-7.16, -2.09, 247.30),
                        new Point(4.08, 0.00, 244.40))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.68, 0.21, 243.15),
                        new Point(-7.16, -2.09, 247.30),
                        new Point(-1.06, 0.28, 242.64))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.68, 0.21, 243.15),
                        new Point(4.08, 0.00, 244.40),
                        new Point(-7.16, -2.09, 247.30))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-4.71, -4.53, 254.56),
                        new Point(-6.27, -4.03, 252.30),
                        new Point(-7.16, -2.09, 247.30))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-4.71, -4.53, 254.56),
                        new Point(-7.16, -2.09, 247.30),
                        new Point(5.53, -2.97, 254.03))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.33, -3.83, 255.72),
                        new Point(-4.71, -4.53, 254.56),
                        new Point(5.53, -2.97, 254.03))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.21, -0.05, 246.33),
                        new Point(5.53, -2.97, 254.03),
                        new Point(4.08, 0.00, 244.40))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-7.16, -2.09, 247.30),
                        new Point(-9.12, 1.84, 251.91),
                        new Point(-4.89, 5.23, 244.21))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.11, 0.24, 257.47),
                        new Point(-9.12, 1.84, 251.91),
                        new Point(-6.27, -4.03, 252.30))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(0.18, 0.18, 259.28),
                        new Point(-6.11, 0.24, 257.47),
                        new Point(-4.71, -4.53, 254.56))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.53, -2.97, 254.03),
                        new Point(7.43, 3.03, 253.84),
                        new Point(5.84, 1.81, 256.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.75, 5.88, 243.37),
                        new Point(1.56, 6.17, 243.67),
                        new Point(1.68, 0.21, 243.15))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(4.08, 0.00, 244.40),
                        new Point(1.56, 6.17, 243.67),
                        new Point(6.56, 5.06, 247.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.21, -0.05, 246.33),
                        new Point(6.56, 5.06, 247.71),
                        new Point(7.43, 3.03, 253.84))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.33, -3.83, 255.72),
                        new Point(5.84, 1.81, 256.51),
                        new Point(0.18, 0.18, 259.28))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-7.16, -2.09, 247.30),
                        new Point(-6.27, -4.03, 252.30),
                        new Point(-9.12, 1.84, 251.91))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.27, -4.03, 252.30),
                        new Point(-4.71, -4.53, 254.56),
                        new Point(-6.11, 0.24, 257.47))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-4.71, -4.53, 254.56),
                        new Point(3.33, -3.83, 255.72),
                        new Point(0.18, 0.18, 259.28))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.33, -3.83, 255.72),
                        new Point(5.53, -2.97, 254.03),
                        new Point(5.84, 1.81, 256.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.53, -2.97, 254.03),
                        new Point(6.21, -0.05, 246.33),
                        new Point(7.43, 3.03, 253.84))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.21, -0.05, 246.33),
                        new Point(4.08, 0.00, 244.40),
                        new Point(6.56, 5.06, 247.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.68, 0.21, 243.15),
                        new Point(-1.06, 0.28, 242.64),
                        new Point(-1.75, 5.88, 243.37))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(4.08, 0.00, 244.40),
                        new Point(1.68, 0.21, 243.15),
                        new Point(1.56, 6.17, 243.67))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-4.89, 5.23, 244.21),
                        new Point(-1.06, 0.28, 242.64),
                        new Point(-7.16, -2.09, 247.30))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-4.89, 5.23, 244.21),
                        new Point(-1.75, 5.88, 243.37),
                        new Point(-1.06, 0.28, 242.64))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.42, 4.36, 245.31),
                        new Point(-9.12, 1.84, 251.91),
                        new Point(-10.18, 2.92, 248.40))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.12, 1.84, 251.91),
                        new Point(-8.42, 4.36, 245.31),
                        new Point(-4.89, 5.23, 244.21))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.12, 1.84, 251.91),
                        new Point(-6.81, -0.18, 258.26),
                        new Point(-10.18, 2.92, 248.40))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.12, 1.84, 251.91),
                        new Point(-6.11, 0.24, 257.47),
                        new Point(-6.81, -0.18, 258.26))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.75, 5.88, 243.37),
                        new Point(-4.89, 5.23, 244.21),
                        new Point(-5.52, 5.40, 243.03))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.42, 4.36, 245.31),
                        new Point(-5.52, 5.40, 243.03),
                        new Point(-4.89, 5.23, 244.21))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.56, 6.17, 243.67),
                        new Point(-1.75, 5.88, 243.37),
                        new Point(-1.89, 6.23, 242.12))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-5.52, 5.40, 243.03),
                        new Point(-1.89, 6.23, 242.12),
                        new Point(-1.75, 5.88, 243.37))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.89, 6.23, 242.12),
                        new Point(5.17, 6.26, 244.47),
                        new Point(1.56, 6.17, 243.67))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.56, 6.17, 243.67),
                        new Point(5.17, 6.26, 244.47),
                        new Point(6.56, 5.06, 247.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.45, -0.47, 260.00),
                        new Point(-6.81, -0.18, 258.26),
                        new Point(-6.11, 0.24, 257.47))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.98, 0.31, 259.49),
                        new Point(-3.45, -0.47, 260.00),
                        new Point(0.18, 0.18, 259.28))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.11, 0.24, 257.47),
                        new Point(0.18, 0.18, 259.28),
                        new Point(-3.45, -0.47, 260.00))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.72, 1.70, 257.22),
                        new Point(3.98, 0.31, 259.49),
                        new Point(5.84, 1.81, 256.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(0.18, 0.18, 259.28),
                        new Point(5.84, 1.81, 256.51),
                        new Point(3.98, 0.31, 259.49))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(8.74, 4.35, 250.64),
                        new Point(7.43, 3.03, 253.84),
                        new Point(6.56, 5.06, 247.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.56, 5.06, 247.71),
                        new Point(7.68, 5.46, 247.19),
                        new Point(8.74, 4.35, 250.64))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.17, 6.26, 244.47),
                        new Point(7.68, 5.46, 247.19),
                        new Point(6.56, 5.06, 247.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(7.43, 3.03, 253.84),
                        new Point(6.72, 1.70, 257.22),
                        new Point(5.84, 1.81, 256.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.72, 1.70, 257.22),
                        new Point(7.43, 3.03, 253.84),
                        new Point(8.74, 4.35, 250.64))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.33, 0.40, 255.44),
                        new Point(-10.18, 2.92, 248.40),
                        new Point(-6.81, -0.18, 258.26))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-11.10, -3.50, 245.53),
                        new Point(-10.18, 2.92, 248.40),
                        new Point(-11.47, -5.09, 249.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.42, 4.36, 245.31),
                        new Point(-11.10, -3.50, 245.53),
                        new Point(-9.06, -1.92, 241.85))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.94, -6.55, 256.93),
                        new Point(-3.45, -0.47, 260.00),
                        new Point(1.22, -7.42, 259.65))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.10, -6.45, 253.77),
                        new Point(-11.47, -5.09, 249.71),
                        new Point(-9.33, 0.40, 255.44))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.10, -6.45, 253.77),
                        new Point(-9.33, 0.40, 255.44),
                        new Point(-6.94, -6.55, 256.93))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.98, 0.31, 259.49),
                        new Point(8.88, -5.22, 255.90),
                        new Point(5.47, -6.55, 258.51))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(10.93, -3.64, 252.23),
                        new Point(8.88, -5.22, 255.90),
                        new Point(6.72, 1.70, 257.22))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.17, 6.26, 244.47),
                        new Point(9.93, -0.69, 243.98),
                        new Point(7.68, 5.46, 247.19))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.89, 6.23, 242.12),
                        new Point(3.07, 0.57, 238.61),
                        new Point(5.17, 6.26, 244.47))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(11.30, -2.05, 248.04),
                        new Point(8.74, 4.35, 250.64),
                        new Point(7.68, 5.46, 247.19))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.47, -6.55, 258.51),
                        new Point(1.22, -7.42, 259.65),
                        new Point(3.98, 0.31, 259.49))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-5.52, 5.40, 243.03),
                        new Point(-8.42, 4.36, 245.31),
                        new Point(-9.06, -1.92, 241.85))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.42, 4.36, 245.31),
                        new Point(-10.18, 2.92, 248.40),
                        new Point(-11.10, -3.50, 245.53))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.33, 0.40, 255.44),
                        new Point(-6.81, -0.18, 258.26),
                        new Point(-6.94, -6.55, 256.93))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.81, -0.18, 258.26),
                        new Point(-3.45, -0.47, 260.00),
                        new Point(-6.94, -6.55, 256.93))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.18, 2.92, 248.40),
                        new Point(-9.33, 0.40, 255.44),
                        new Point(-11.47, -5.09, 249.71))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.98, 0.31, 259.49),
                        new Point(6.72, 1.70, 257.22),
                        new Point(8.88, -5.22, 255.90))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(8.74, 4.35, 250.64),
                        new Point(11.30, -2.05, 248.04),
                        new Point(10.93, -3.64, 252.23))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.72, 1.70, 257.22),
                        new Point(8.74, 4.35, 250.64),
                        new Point(10.93, -3.64, 252.23))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.17, 6.26, 244.47),
                        new Point(3.07, 0.57, 238.61),
                        new Point(9.93, -0.69, 243.98))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.89, 6.23, 242.12),
                        new Point(-1.39, 0.29, 238.11),
                        new Point(3.07, 0.57, 238.61))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(7.68, 5.46, 247.19),
                        new Point(9.93, -0.69, 243.98),
                        new Point(11.30, -2.05, 248.04))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.45, -0.47, 260.00),
                        new Point(3.98, 0.31, 259.49),
                        new Point(1.22, -7.42, 259.65))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.06, -1.92, 241.85),
                        new Point(-1.39, 0.29, 238.11),
                        new Point(-5.52, 5.40, 243.03))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.39, 0.29, 238.11),
                        new Point(-1.89, 6.23, 242.12),
                        new Point(-5.52, 5.40, 243.03))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.22, -7.42, 259.65),
                        new Point(-3.24, -7.71, 259.14),
                        new Point(-6.94, -6.55, 256.93))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.94, -6.55, 256.93),
                        new Point(-3.24, -7.71, 259.14),
                        new Point(-10.10, -6.45, 253.77))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.41, 4.75, 245.50),
                        new Point(-5.62, 0.07, 239.68),
                        new Point(-8.97, -1.24, 242.24))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.98, -2.79, 245.85),
                        new Point(-8.41, 4.75, 245.50),
                        new Point(-8.97, -1.24, 242.24))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.96, -0.03, 258.49),
                        new Point(-9.30, 0.92, 255.58),
                        new Point(-10.00, -5.69, 253.95))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.89, 0.83, 259.60),
                        new Point(-3.53, -0.32, 260.27),
                        new Point(1.12, -6.65, 259.72))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-7.16, -6.59, 257.20),
                        new Point(-3.53, -0.32, 260.27),
                        new Point(-6.96, -0.03, 258.49))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-11.34, -4.35, 249.96),
                        new Point(-9.30, 0.92, 255.58),
                        new Point(-10.14, 3.42, 248.61))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.77, 1.96, 257.39),
                        new Point(3.89, 0.83, 259.60),
                        new Point(5.23, -5.59, 258.58))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(8.55, -4.29, 256.04),
                        new Point(8.81, 4.64, 250.74),
                        new Point(6.77, 1.96, 257.39))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.51, 6.26, 244.05),
                        new Point(8.81, 4.64, 250.74),
                        new Point(9.68, -0.03, 244.33))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.84, 0.87, 241.08),
                        new Point(-1.93, 6.62, 242.33),
                        new Point(5.51, 6.26, 244.05))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.98, -2.79, 245.85),
                        new Point(-11.34, -4.35, 249.96),
                        new Point(-10.14, 3.42, 248.61))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.98, -2.79, 245.85),
                        new Point(-10.14, 3.42, 248.61),
                        new Point(-8.41, 4.75, 245.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.00, -5.69, 253.95),
                        new Point(-7.16, -6.59, 257.20),
                        new Point(-6.96, -0.03, 258.49))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-7.16, -6.59, 257.20),
                        new Point(1.12, -6.65, 259.72),
                        new Point(-3.53, -0.32, 260.27))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-11.34, -4.35, 249.96),
                        new Point(-10.00, -5.69, 253.95),
                        new Point(-9.30, 0.92, 255.58))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.23, -5.59, 258.58),
                        new Point(8.55, -4.29, 256.04),
                        new Point(6.77, 1.96, 257.39))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(8.55, -4.29, 256.04),
                        new Point(9.68, -0.03, 244.33),
                        new Point(8.81, 4.64, 250.74))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(9.68, -0.03, 244.33),
                        new Point(6.84, 0.87, 241.08),
                        new Point(5.51, 6.26, 244.05))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.84, 0.87, 241.08),
                        new Point(-1.44, 0.93, 238.56),
                        new Point(-1.93, 6.62, 242.33))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.12, -6.65, 259.72),
                        new Point(5.23, -5.59, 258.58),
                        new Point(3.89, 0.83, 259.60))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.41, 4.75, 245.50),
                        new Point(-1.44, 0.93, 238.56),
                        new Point(-5.62, 0.07, 239.68))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.41, 4.75, 245.50),
                        new Point(-1.93, 6.62, 242.33),
                        new Point(-1.44, 0.93, 238.56))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.14, 3.42, 248.61),
                        new Point(-8.87, 2.02, 251.94),
                        new Point(-8.41, 4.75, 245.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.41, 4.75, 245.50),
                        new Point(-7.28, 4.44, 246.34),
                        new Point(-1.75, 6.03, 243.64))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-7.28, 4.44, 246.34),
                        new Point(-8.41, 4.75, 245.50),
                        new Point(-8.87, 2.02, 251.94))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-10.14, 3.42, 248.61),
                        new Point(-9.30, 0.92, 255.58),
                        new Point(-8.21, 1.23, 255.05))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.21, 1.23, 255.05),
                        new Point(-8.87, 2.02, 251.94),
                        new Point(-10.14, 3.42, 248.61))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-9.30, 0.92, 255.58),
                        new Point(-3.15, 0.30, 259.02),
                        new Point(-8.21, 1.23, 255.05))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.75, 6.03, 243.64),
                        new Point(-1.93, 6.62, 242.33),
                        new Point(-8.41, 4.75, 245.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.93, 6.62, 242.33),
                        new Point(-1.75, 6.03, 243.64),
                        new Point(1.46, 6.24, 244.00))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.93, 6.62, 242.33),
                        new Point(1.46, 6.24, 244.00),
                        new Point(5.51, 6.26, 244.05))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.51, 6.26, 244.05),
                        new Point(4.26, 5.79, 245.53),
                        new Point(6.31, 5.14, 247.88))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(4.26, 5.79, 245.53),
                        new Point(5.51, 6.26, 244.05),
                        new Point(1.46, 6.24, 244.00))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.15, 0.30, 259.02),
                        new Point(-6.96, -0.03, 258.49),
                        new Point(-3.53, -0.32, 260.27))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-6.96, -0.03, 258.49),
                        new Point(-3.15, 0.30, 259.02),
                        new Point(-9.30, 0.92, 255.58))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.15, 0.30, 259.02),
                        new Point(-3.53, -0.32, 260.27),
                        new Point(3.89, 0.83, 259.60))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.28, 1.16, 258.55),
                        new Point(3.89, 0.83, 259.60),
                        new Point(7.02, 3.05, 253.72))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.89, 0.83, 259.60),
                        new Point(3.28, 1.16, 258.55),
                        new Point(-3.15, 0.30, 259.02))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.31, 5.14, 247.88),
                        new Point(7.02, 3.05, 253.72),
                        new Point(8.81, 4.64, 250.74))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.31, 5.14, 247.88),
                        new Point(8.81, 4.64, 250.74),
                        new Point(5.51, 6.26, 244.05))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(6.77, 1.96, 257.39),
                        new Point(7.02, 3.05, 253.72),
                        new Point(3.89, 0.83, 259.60))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(8.81, 4.64, 250.74),
                        new Point(7.02, 3.05, 253.72),
                        new Point(6.77, 1.96, 257.39))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-5.41, -1.10, 245.39),
                        new Point(-3.66, -0.10, 243.61),
                        new Point(-7.28, 4.44, 246.34))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.21, 1.23, 255.05),
                        new Point(-3.15, 0.30, 259.02),
                        new Point(-4.61, -4.24, 254.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.87, 2.02, 251.94),
                        new Point(-8.21, 1.23, 255.05),
                        new Point(-6.20, -3.73, 252.36))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.20, -3.45, 255.68),
                        new Point(3.28, 1.16, 258.55),
                        new Point(7.02, 3.05, 253.72))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.96, 0.03, 246.50),
                        new Point(5.08, -3.00, 253.63),
                        new Point(7.02, 3.05, 253.72))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.96, 0.03, 246.50),
                        new Point(6.31, 5.14, 247.88),
                        new Point(4.26, 5.79, 245.53))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.62, 0.44, 243.35),
                        new Point(1.46, 6.24, 244.00),
                        new Point(-1.75, 6.03, 243.64))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(4.26, 5.79, 245.53),
                        new Point(1.46, 6.24, 244.00),
                        new Point(3.98, 0.24, 244.57))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.15, 0.30, 259.02),
                        new Point(3.28, 1.16, 258.55),
                        new Point(-2.24, -4.34, 255.94))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.75, 6.03, 243.64),
                        new Point(-7.28, 4.44, 246.34),
                        new Point(-3.66, -0.10, 243.61))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.87, 2.02, 251.94),
                        new Point(-6.20, -3.73, 252.36),
                        new Point(-5.41, -1.10, 245.39))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-7.28, 4.44, 246.34),
                        new Point(-8.87, 2.02, 251.94),
                        new Point(-5.41, -1.10, 245.39))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-8.21, 1.23, 255.05),
                        new Point(-4.61, -4.24, 254.50),
                        new Point(-6.20, -3.73, 252.36))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.15, 0.30, 259.02),
                        new Point(-2.24, -4.34, 255.94),
                        new Point(-4.61, -4.24, 254.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(7.02, 3.05, 253.72),
                        new Point(5.08, -3.00, 253.63),
                        new Point(3.20, -3.45, 255.68))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(7.02, 3.05, 253.72),
                        new Point(6.31, 5.14, 247.88),
                        new Point(5.96, 0.03, 246.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(4.26, 5.79, 245.53),
                        new Point(3.98, 0.24, 244.57),
                        new Point(5.96, 0.03, 246.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-1.75, 6.03, 243.64),
                        new Point(-3.66, -0.10, 243.61),
                        new Point(1.62, 0.44, 243.35))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(1.46, 6.24, 244.00),
                        new Point(1.62, 0.44, 243.35),
                        new Point(3.98, 0.24, 244.57))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.28, 1.16, 258.55),
                        new Point(3.20, -3.45, 255.68),
                        new Point(-2.24, -4.34, 255.94))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.98, 0.24, 244.57),
                        new Point(-5.41, -1.10, 245.39),
                        new Point(5.08, -3.00, 253.63))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-3.66, -0.10, 243.61),
                        new Point(-5.41, -1.10, 245.39),
                        new Point(1.62, 0.44, 243.35))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-5.41, -1.10, 245.39),
                        new Point(3.98, 0.24, 244.57),
                        new Point(1.62, 0.44, 243.35))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-5.41, -1.10, 245.39),
                        new Point(-6.20, -3.73, 252.36),
                        new Point(-2.24, -4.34, 255.94))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.08, -3.00, 253.63),
                        new Point(-5.41, -1.10, 245.39),
                        new Point(-2.24, -4.34, 255.94))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(5.08, -3.00, 253.63),
                        new Point(-2.24, -4.34, 255.94),
                        new Point(3.20, -3.45, 255.68))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(3.98, 0.24, 244.57),
                        new Point(5.08, -3.00, 253.63),
                        new Point(5.96, 0.03, 246.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial),
                new Triangle(new Point(-2.24, -4.34, 255.94),
                        new Point(-6.20, -3.73, 252.36),
                        new Point(-4.61, -4.24, 254.50))
                        .setEmission(bowlColor).setMaterial(bowMaterial)
                );

        scene.lights.add(new SpotLight(new Color(RED), new Point(60, 50, 0), new Vector(-1, -1, -2)));
        scene.lights.add(new PointLight(new Color(BLUE), new Point(-60, -50, 0)));
        scene.lights.add(new DirectionalLight(new Color(255,255,159),new Vector(-1, -1, -2)));

        scene.setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.2)));

        cameraBuilder.setLocation(new Point(50, 50, 1000)).setVpDistance(1000)
                .setVpSize(200, 200)
                .setImageWriter(new ImageWriter("dog with improvements", 600, 600))
                .build()
                .renderImage()
                .writeToImage();
    }

}
