package primitives;

public class Material {

    /**
     * Diffuse attenuation factor.
     */
    public Double3 kD=Double3.ZERO;

    /**
     * Specular attenuation factor.
     */
    public Double3 kS=Double3.ZERO;

    /**
     * Attenuation coefficient of transparency
     */
    public Double3 kT=Double3.ZERO;

    /**
     * reflection attenuation coefficient
     */
    public Double3 kR=Double3.ZERO;

    /**
     * Shininess factor of the material.
     */
    public int shininess=0;

    /**
     * Sets the diffuse attenuation factor whit Double3.
     *
     * @param kD The diffuse attenuation factor.
     * @return This Material object, to allow method chaining.
     */
    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Sets the diffuse attenuation factor whit Double.
     *
     * @param kD The diffuse attenuation factor.
     * @return This Material object, to allow method chaining.
     */
    public Material setkD(Double kD) {
        return setkD(new Double3(kD));}

    /**
     * Sets the Specular attenuation factor whit Double3.
     *
     * @param kS The Specular attenuation factor.
     * @return This Material object, to allow method chaining.
     */
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

    /**
     * Sets the Specular attenuation factor whit Double.
     *
     * @param kS The Specular attenuation factor.
     * @return This Material object, to allow method chaining.
     */
    public Material setkS(Double kS) {

        return setkS(new Double3(kS));
    }

    /**
     * Sets the Shininess factor of the material.
     *
     * @param shininess The Shininess factor of the material.
     * @return This Material object, to allow method chaining.
     */
    public Material setShininess(int shininess) {
        this.shininess = shininess;
        return this;
    }

    /**
     * getter
     * @return Diffuse attenuation factor.
     */
    public Double3 getkD() {
        return kD;
    }

    /**
     * getter
     * @return Specular attenuation factor.
     */
    public Double3 getkS() {
        return kS;
    }

    /**
     * getter
     * @return Transparency coefficient.
     */
    public Double3 getkT() {
        return kT;
    }

    /**
     * getter
     * @return Reflection coefficient.
     */
    public Double3 getkR() {
        return kR;
    }

    /**
     * getter
     * @return Shininess factor of the material
     */
    public int getShininess() {
        return shininess;
    }
}
