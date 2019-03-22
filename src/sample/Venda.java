package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.Stack;

public class Venda implements Comparator<Venda> {

    private Stack<Product> productes = new Stack<Product>();
    private Date fecha;
    private Vendedor vendedor;
    private float preuTotal = 0f;
    private static int totalVentes = 0;

    public Venda() {
        totalVentes++;
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

    public Stack<Product> getProductes() {
        return productes;
    }

    public void setProductes(Stack<Product> productes) {
        this.productes = productes;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {


        this.vendedor = vendedor;
    }

    public float getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(float preuTotal) {
        this.preuTotal = preuTotal;
    }

    public static int getTotalVentes() {
        return totalVentes;
    }

    public static void setTotalVentes() {
        Venda.totalVentes++;
    }

    @Override
    public int compare(Venda o1, Venda o2) {
        return o1.getFecha().compareTo(o2.getFecha());
    }
}
