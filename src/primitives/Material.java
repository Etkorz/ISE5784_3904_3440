package primitives;

public class Material {

    public Double3 kD=Double3.ZERO;
    public Double3 kS=Double3.ZERO;

    //Attenuation coefficient of transparency
    public Double3 kT=Double3.ZERO;
    //reflection attenuation coefficient
    public Double3 kR=Double3.ZERO;

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

    /**
     * Sets the kT value.
     *
     * @param  kT  the new kD value
     * @return     the updated Material object
     */
    public Material setkT(Double3 kT){
        this.kT=kT;
        return this;
    }

    /**
     * Sets the kT value.
     *
     * @param  kT  the new kR value
     * @return     the updated Material object
     */
    public Material setkT(double kT) {
        this.kT = new Double3(kT);
        return this;
    }

    /**
     * Sets the kR value.
     *
     * @param  kR  the new kD value
     * @return     the updated Material object
     */
    public Material setkR(Double3 kR){
        this.kR=kR;
        return this;
    }

    /**
     * Sets the kR value.
     *
     * @param  kR  the new kR value
     * @return     the updated Material object
     */
    public Material setkR(double kR) {
        this.kR = new Double3(kR);
        return this;
    }

    public Material setkS(Double kS) {
        return setkS(new Double3(kS));
    }

    public Material setShininess(int shininess) {
        this.shininess = shininess;
        return this;
    }

    public Double3 getkD() {
        return kD;
    }

    public Double3 getkS() {
        return kS;
    }

    public Double3 getkT() {
        return kT;
    }

    public Double3 getkR() {
        return kR;
    }

    public int getShininess() {
        return shininess;
    }
}
