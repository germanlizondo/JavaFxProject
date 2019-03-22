package sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SaxXml extends DefaultHandler {

    private ArrayList<Venda> ventas = new ArrayList<Venda>();
    private Venda venda;
    private String valor;
    private Product product;
    private Vendedor vendedor;
    private SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        System.out.println(qName);
        switch (qName){
            case "venta" :
                this.venda = new Venda();
                this.ventas.add(this.venda);

                break;

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        switch (qName){

            case "vendedor":
                this.vendedor = new Vendedor(this.valor);
                this.venda.setVendedor(this.vendedor);
                break;

            case "fecha":
                try {
                    this.venda.setFecha(this.dateFormat.parse(this.valor));
                    System.out.println(this.dateFormat.parse(this.valor));
                    this.valor = "";
                }catch (Exception e){
                    e.fillInStackTrace();
                }
                break;
            case "precio":
                this.venda.setPreuTotal(Float.parseFloat(this.valor));
                break;
            case "tipo":

                if(this.valor.equals("tauleta")){
                    this.product = new Tauleta();
                }
                break;
            case "referencia":
                this.product.setReferencia(Integer.parseInt(this.valor));
                break;
            case "nom":
                this.product.setNom(this.valor);
                break;
            case "precioProduct":
                this.product.setPreu(Float.parseFloat(this.valor));
                break;
            case "garantia":
                if(this.valor.equals("No")) this.product.setGarantia(false);
                else this.product.setGarantia(true);
                break;
            case "marca":
                this.product.setMarca(this.valor);
                break;
            case "model":
                this.product.setModel(this.valor);
                this.venda.afegirProducteVenda(this.product);
                break;

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        this.valor = new String(ch,start,length);

    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();


    }

    public ArrayList<Venda> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venda> ventas) {
        this.ventas = ventas;
    }
}
