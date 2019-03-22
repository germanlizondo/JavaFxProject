package sample;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;

public class StaxXml {

  private Hashtable<Integer,Product> productos=new Hashtable<Integer, Product>();
  private Product product;

    public StaxXml() throws FileNotFoundException, XMLStreamException {

        this.leerXml();
    }

    public void leerXml() throws FileNotFoundException, XMLStreamException {

        int eventType;
        int cnt = 1;
        String tag = "";
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader("src/sample/productos.xml"));

        while (streamReader.hasNext()){
            eventType = streamReader.next();

            switch (eventType){

                case XMLEvent.START_ELEMENT:

                    tag = streamReader.getLocalName();
                    switch (tag){
                        case "tipo":
                            if(streamReader.getElementText().equals("tauleta")){

                                this.product = new Tauleta();
                            }
                            break;
                        case "referencia": this.product.setReferencia(Integer.parseInt(streamReader.getElementText()));break;
                        case "nom": this.product.setNom(streamReader.getElementText());break;
                        case "preu": this.product.setPreu(Integer.parseInt(streamReader.getElementText()));break;
                        case "marca":this.product.setMarca(streamReader.getElementText());break;
                        case "model": this.product.setModel(streamReader.getElementText());break;
                        case "quantitat":
                            this.product.setQuantitat(Integer.parseInt(streamReader.getElementText()));
                            this.productos.put(cnt,this.product);
                            cnt++;

                            break;
                    }


                    break;


            }


        }
    }


    public Hashtable<Integer, Product> getProductos() {
        return productos;
    }
}
