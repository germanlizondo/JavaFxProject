package sample;

import java.util.Date;
import java.util.Stack;

public class Venda {

    private Stack<Product> productes = new Stack<Product>();
    private Date fecha;
    private Vendedor vendedor;
    private float preuTotal = 0f;

    public Venda() {
        this.obtenirPreuTotal();
        this.fecha = new Date();
    }


    public void obtenirPreuTotal(){


        for (Product p: this.productes) {
            this.preuTotal = this.preuTotal + p.getPreu();
        }

    }

    public void afegirProducteVenda(Product product){
        this.productes.add(product);
    }



    /**
     * Gets fecha.
     *
     * @return Value of fecha.
     */
    public Date getFecha() {
        return fecha;
    }



    /**
     * Sets new fecha.
     *
     * @param fecha New value of fecha.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
