package sample;

public abstract class Empleat extends Persona  {

    private String nom;
    private String cognom;
    private int edad;
    private int seguretatsocial;


    public Empleat(String nom, String cognom, int edad, int seguretatsocial) {
        this.nom = nom;
        this.cognom = cognom;
        this.edad = edad;
        this.seguretatsocial = seguretatsocial;
    }

    public Empleat(String nom){
        this.nom = nom;
    }
    /**
     * Gets seguretatsocial.
     *
     * @return Value of seguretatsocial.
     */
    public int getSeguretatsocial() {
        return seguretatsocial;
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
     * Sets new seguretatsocial.
     *
     * @param seguretatsocial New value of seguretatsocial.
     */
    public void setSeguretatsocial(int seguretatsocial) {
        this.seguretatsocial = seguretatsocial;
    }

    /**
     * Sets new cognom.
     *
     * @param cognom New value of cognom.
     */
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    /**
     * Gets edad.
     *
     * @return Value of edad.
     */
    public int getEdad() {
        return edad;
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
     * Sets new edad.
     *
     * @param edad New value of edad.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Gets cognom.
     *
     * @return Value of cognom.
     */
    public String getCognom() {
        return cognom;
    }
}
