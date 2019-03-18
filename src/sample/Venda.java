package sample;

import java.util.Date;

public class Venda {

    private Product product;
    private Date fecha;
    private Vendedor vendedor;

    public Venda(Product product) {
        this.product = product;
        this.fecha = new Date();
    }


    /**
     * Gets product.
     *
     * @return Value of product.
     */
    public Product getProduct() {
        return product;
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
     * Sets new product.
     *
     * @param product New value of product.
     */
    public void setProduct(Product product) {
        this.product = product;
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
