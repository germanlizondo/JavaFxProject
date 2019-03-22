package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VentesTable {

    private SimpleStringProperty fecha;
    private SimpleStringProperty productos;
    private SimpleFloatProperty precio;
    private SimpleStringProperty vendedor;


    public VentesTable(String fecha, String productos, float precio, String vendedor) {
        this.fecha = new SimpleStringProperty(fecha);
        this.productos = new SimpleStringProperty(productos);;
        this.precio = new SimpleFloatProperty(precio);
        this.vendedor = new SimpleStringProperty(vendedor);;
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getProductos() {
        return productos.get();
    }

    public SimpleStringProperty productosProperty() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos.set(productos);
    }

    public float getPrecio() {
        return precio.get();
    }

    public SimpleFloatProperty precioProperty() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio.set(precio);
    }

    public String getVendedor() {
        return vendedor.get();
    }

    public SimpleStringProperty vendedorProperty() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor.set(vendedor);
    }
}
