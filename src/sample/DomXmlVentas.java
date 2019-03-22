package sample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Set;

public class DomXmlVentas {



    void escribirVenda(Venda venda){

        try {



            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();


            Element eRaiz = doc.createElement("ventas");

            doc.appendChild(eRaiz);


            Element eEmpleado = doc.createElement("venta");
            eRaiz.appendChild(eEmpleado);

            Element eNombre = doc.createElement("vendedor");
            eNombre.appendChild(doc.createTextNode(venda.getVendedor().getNom()));
            eEmpleado.appendChild(eNombre);

            Element eCognom = doc.createElement("fecha");
            eCognom.appendChild(doc.createTextNode(venda.getFecha().toString()));
            eEmpleado.appendChild(eCognom);

            Element eEdad= doc.createElement("precio");
            eEdad.appendChild(doc.createTextNode(venda.getPreuTotal()+""));
            eEmpleado.appendChild(eEdad);

            Element productos = doc.createElement("productos");

            eEmpleado.appendChild(productos);

            for (Product p: venda.getProductes()) {
                Element producto = doc.createElement("producto");

                eEmpleado.appendChild(producto);
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
            StreamResult result = new StreamResult("allsales.xml");

            transformer.transform(source, result);
            System.out.println("HELLO THERE ESBRIBIT VENda");

            System.out.println("File saved!");
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    }


