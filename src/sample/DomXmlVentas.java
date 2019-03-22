package sample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Set;

public class DomXmlVentas {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    Element eRaiz;
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public DomXmlVentas() {

        try {
              dbf = DocumentBuilderFactory.newInstance();
             db = dbf.newDocumentBuilder();
             doc = db.newDocument();

             eRaiz = doc.createElement("ventas");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public void rellenarTabla(){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            File file = new File("src/sample/allsales.xml");
            SaxXml saxXml = new SaxXml();
            saxParser.parse(file,saxXml);


            for (Venda v: saxXml.getVentas()) {
                Element eEmpleado = doc.createElement("venta");
                eRaiz.appendChild(eEmpleado);

                Element eNombre = doc.createElement("vendedor");
                eNombre.appendChild(doc.createTextNode(v.getVendedor().getNom()));
                eEmpleado.appendChild(eNombre);

                Element eCognom = doc.createElement("fecha");

                String data1 =  simpleDateFormat.format(v.getFecha()).toString();
                String datafinal = data1.replace('-','/');

                eCognom.appendChild(doc.createTextNode(datafinal));
                eEmpleado.appendChild(eCognom);

                Element eEdad= doc.createElement("precio");
                eEdad.appendChild(doc.createTextNode(v.getPreuTotal()+""));
                eEmpleado.appendChild(eEdad);

                Element productos = doc.createElement("productos");

                eEmpleado.appendChild(productos);

                for (Product p: v.getProductes()) {
                    Element producto = doc.createElement("producto");

                    productos.appendChild(producto);
                    Element tipo = doc.createElement("tipo");
                    if(p instanceof Tauleta) tipo.appendChild(doc.createTextNode("tauleta"));
                    else tipo.appendChild(doc.createTextNode("videoconsola"));
                    producto.appendChild(tipo);

                    Element referecia = doc.createElement("referencia");

                    referecia.appendChild(doc.createTextNode(p.getReferencia()+""));
                    producto.appendChild(referecia);

                    Element nom = doc.createElement("nom");

                    nom.appendChild(doc.createTextNode(p.getNom()));
                    producto.appendChild(nom);

                    Element precio = doc.createElement("precioProduct");

                    precio.appendChild(doc.createTextNode(p.getPreu()+""));
                    producto.appendChild(precio);

                    Element garantia = doc.createElement("garantia");
                    if(p.isGarantia())  garantia.appendChild(doc.createTextNode("Yes"));
                    else garantia.appendChild(doc.createTextNode("No"));

                    producto.appendChild(garantia);

                    Element marca = doc.createElement("marca");

                    marca.appendChild(doc.createTextNode(p.getMarca()));
                    producto.appendChild(marca);
                    Element model = doc.createElement("model");

                    model.appendChild(doc.createTextNode(p.getModel()));
                    producto.appendChild(model);

                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    void escribirVenda(Venda venda){

        try {



            doc.appendChild(eRaiz);

            this.rellenarTabla();

            Element eEmpleado = doc.createElement("venta");
            eRaiz.appendChild(eEmpleado);

            Element eNombre = doc.createElement("vendedor");
            eNombre.appendChild(doc.createTextNode(venda.getVendedor().getNom()));
            eEmpleado.appendChild(eNombre);

            Element eCognom = doc.createElement("fecha");

          String data1 =  simpleDateFormat.format(venda.getFecha()).toString();
          String datafinal = data1.replace('-','/');

            eCognom.appendChild(doc.createTextNode(datafinal));
            eEmpleado.appendChild(eCognom);

            Element eEdad= doc.createElement("precio");
            eEdad.appendChild(doc.createTextNode(venda.getPreuTotal()+""));
            eEmpleado.appendChild(eEdad);

            Element productos = doc.createElement("productos");

            eEmpleado.appendChild(productos);

            for (Product p: venda.getProductes()) {
                Element producto = doc.createElement("producto");

                productos.appendChild(producto);
                Element tipo = doc.createElement("tipo");
                if(p instanceof Tauleta) tipo.appendChild(doc.createTextNode("tauleta"));
                else tipo.appendChild(doc.createTextNode("videoconsola"));
                producto.appendChild(tipo);

                Element referecia = doc.createElement("referencia");

                referecia.appendChild(doc.createTextNode(p.getReferencia()+""));
                producto.appendChild(referecia);

                Element nom = doc.createElement("nom");

                nom.appendChild(doc.createTextNode(p.getNom()));
                producto.appendChild(nom);

                Element precio = doc.createElement("precioProduct");

                precio.appendChild(doc.createTextNode(p.getPreu()+""));
                producto.appendChild(precio);

                Element garantia = doc.createElement("garantia");
                if(p.isGarantia())  garantia.appendChild(doc.createTextNode("Yes"));
                else garantia.appendChild(doc.createTextNode("No"));

                producto.appendChild(garantia);

                Element marca = doc.createElement("marca");

                marca.appendChild(doc.createTextNode(p.getMarca()));
                producto.appendChild(marca);
                Element model = doc.createElement("model");

                model.appendChild(doc.createTextNode(p.getModel()));
                producto.appendChild(model);

            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/sample/allsales.xml").getAbsolutePath());

            transformer.transform(source, result);
            System.out.println("HELLO THERE ESBRIBIT VENda");

            System.out.println("File saved!");
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    }


