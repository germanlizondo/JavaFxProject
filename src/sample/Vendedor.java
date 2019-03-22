package sample;

import java.util.ArrayList;

public class Vendedor extends Empleat {

    private ArrayList<Venda> vendas = new ArrayList<>();


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
