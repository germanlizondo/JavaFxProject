package sample;

public class Vendedor extends Empleat {


    public Vendedor(String nom, String cognom, int edad, int seguretatsocial) {
        super(nom, cognom, edad, seguretatsocial);


    }

    @Override
    public String toString() {
        return "Vendedor{}";
    }

    public Vendedor(String nom){
        super(nom);
    }
}
