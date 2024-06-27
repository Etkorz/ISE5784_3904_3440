package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

/**
 * Geometry interface represents a geometric body
 *
 * @author Eti Kenig and Gitty Shapira
 */
public abstract class Geometry extends Intersectable {

    protected Color emission= Color.BLACK;

   private Material material=new Material();

    /**
     * @param point
     * @return
     */
    public abstract Vector getNormal(Point point);

    /**
     * getter to the emission color
     *
     * @return the emission color
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * getter of the Material of the geometry
     *
     * @return the Material of the geometry
     */
    public Material getMaterial() {
        return material;
    }

    /**
     *set the Material of the geometry
     *
     * @param material for the geometry
     * @return the Material of the geometry
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }

    /**
     *set the emission color of the geometry
     *
     * @param emission the color to set the emission to
     * @return the update emission color
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }


}
