package primitives;

public class Material {

    public Double3 kD=Double3.ZERO;
    public Double3 kS=Double3.ZERO;

    public int shininess=0;

    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    public Material setkD(Double kD) {
        return setkD(new Double3(kD));}

    public Material setkS(Double3 kS) {
        this.kS = kS;
        return this;
    }

    public Material setkS(Double kS) {
        return setkS(new Double3(kS));
    }

    public Material setShininess(int shininess) {
        this.shininess = shininess;
        return this;
    }
}
