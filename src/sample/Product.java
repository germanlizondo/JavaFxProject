package sample;

public abstract class Product implements Comparable<Product>{

    private int referencia;
    private String nom;
    private float preu;
    private boolean garantia;
    private String marca;
    private String model;
    private int quantitat;

    public Product(int referencia, String nom, float preu,  String marca, String model,int quantitat) {
        this.referencia = referencia;
        this.nom = nom;
        this.preu = preu;
        this.marca = marca;
        this.model = model;
        this.quantitat = quantitat;

    }

    public Product(){

    }

    public Product(int referencia,String nom){
        this.referencia = referencia;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return marca+" "+nom + "|ref: "+referencia +"|n "+quantitat ;
    }

    @Override
    public int compareTo(Product o) {
        if(this.quantitat > o.quantitat) return 1;
        else if(this.quantitat < o.quantitat) return -1;
        else return 0;

    }

    /**
     * Sets new nom.
     *
     * @param nom New value of nom.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Sets new model.
     *
     * @param model New value of model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets new marca.
     *
     * @param marca New value of marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Gets nom.
     *
     * @return Value of nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Gets referencia.
     *
     * @return Value of referencia.
     */
    public int getReferencia() {
        return referencia;
    }

    /**
     * Gets preu.
     *
     * @return Value of preu.
     */
    public float getPreu() {
        return preu;
    }

    /**
     * Gets marca.
     *
     * @return Value of marca.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Sets new garantia.
     *
     * @param garantia New value of garantia.
     */
    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    /**
     * Gets model.
     *
     * @return Value of model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets new referencia.
     *
     * @param referencia New value of referencia.
     */
    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    /**
     * Gets garantia.
     *
     * @return Value of garantia.
     */
    public boolean isGarantia() {
        return garantia;
    }

    /**
     * Sets new preu.
     *
     * @param preu New value of preu.
     */
    public void setPreu(float preu) {
        this.preu = preu;
    }

    /**
     * Sets new quantitat.
     *
     * @param quantitat New value of quantitat.
     */
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    /**
     * Gets quantitat.
     *
     * @return Value of quantitat.
     */
    public  int getQuantitat() {
        return quantitat;
    }
}
