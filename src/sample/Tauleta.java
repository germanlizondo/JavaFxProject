package sample;

public class Tauleta extends Product {

    private int pntPolzades;
    private String resPantalla;

    public Tauleta(int referencia, String nom, float preu, String marca, String model, int pntPolzades, String resPantalla,int quantitat) {
        super(referencia, nom, preu, marca, model,quantitat);
        this.pntPolzades = pntPolzades;
        this.resPantalla = resPantalla;
    }

    public Tauleta(){ }

    public Tauleta(int referencia, String nom) {
        super(referencia, nom);
    }

    /**
     * Gets resPantalla.
     *
     * @return Value of resPantalla.
     */
    public String getResPantalla() {
        return resPantalla;
    }

    /**
     * Sets new resPantalla.
     *
     * @param resPantalla New value of resPantalla.
     */
    public void setResPantalla(String resPantalla) {
        this.resPantalla = resPantalla;
    }


    /**
     * Gets pntPolzades.
     *
     * @return Value of pntPolzades.
     */
    public int getPntPolzades() {
        return pntPolzades;
    }

    /**
     * Sets new pntPolzades.
     *
     * @param pntPolzades New value of pntPolzades.
     */
    public void setPntPolzades(int pntPolzades) {
        this.pntPolzades = pntPolzades;
    }




}
