package primitives;

public class Vector extends Point{

    public Vector(double x, double y, double z) {
        super(x, y, z);
        isVectorZero(this.xyz);
    }

    public Vector(Double3 xyz) {
        super(xyz);
        isVectorZero(xyz);
    }
    private void isVectorZero(Double3 xyz){
        if(xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("The given vector is zero");
    }

    @Override
    public Vector add(Vector v) {
        return new Vector(v.xyz.add(this.xyz));
    }

    public Vector scale(double scalar) {
        return new Vector(xyz.scale(scalar));
    }

    /**
     * !!! to ask: int or double? !!!
     * @param v3
     * @return
     */
    public int dotProduct(Vector v3) {
       return (int) (this.xyz.d1*v3.xyz.d1+this.xyz.d2*v3.xyz.d2+this.xyz.d3*v3.xyz.d3);
    }

    public Vector crossProduct(Vector v2) {
        double x= this.xyz.d2*v2.xyz.d3-this.xyz.d3*v2.xyz.d2;
        double y= this.xyz.d3*v2.xyz.d1-this.xyz.d1*v2.xyz.d3;
        double z= this.xyz.d1*v2.xyz.d2-this.xyz.d2*v2.xyz.d1;
        return new Vector(x,y,z);
    }

    public double lengthSquared() {
        return this.dotProduct(this);
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public Vector normalize() {
        return new Vector( xyz.reduce(this.length()));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "xyz=" + xyz +
                '}';
    }

}
