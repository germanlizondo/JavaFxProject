package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmpleatTable {

    private SimpleStringProperty nom;
    private SimpleStringProperty cognom;
    private SimpleIntegerProperty edad;
    private SimpleIntegerProperty seguretatSocial;


    public EmpleatTable(String nom, String cognom, int edad, int seguretatSocial) {
        this.nom = new SimpleStringProperty(nom);
        this.cognom = new SimpleStringProperty(cognom);;
        this.edad = new SimpleIntegerProperty(edad);
        this.seguretatSocial =  new SimpleIntegerProperty(seguretatSocial);;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }
    public String getCognom() {
        return cognom.get();
    }

    public void setCognom(String cognom) {
        this.cognom = new SimpleStringProperty(cognom);
    }

    public int getEdad(){
       return this.edad.get();
    }

    public void setEdad(int edad){
        this.edad = new SimpleIntegerProperty(edad);
    }

    public int getSeguretatSocial(){
        return this.seguretatSocial.get();
    }

    public void setSeguretatSocial(int seguretatSocial){
        this.seguretatSocial = new SimpleIntegerProperty(seguretatSocial);
    }

}
