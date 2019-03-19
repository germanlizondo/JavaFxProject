package sample;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;


public class DomXml {

   private ArrayList<Empleat> empleats = new ArrayList<Empleat>();

   private File empleatsFile = new File("src/sample/empleats.xml");

    Document doc;

    public DomXml() {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.parse(this.empleatsFile);
            doc.getDocumentElement().normalize();

            this.leerArchivo();

           Empleat v = new Vendedor("Obi","Wan",66,0232);

       //     this.anadirEmpleado(v);


        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

    public void leerArchivo(){


        System.out.println("arrel " + doc.getDocumentElement().getNodeName());
        NodeList nodes =doc.getElementsByTagName("empleat");
        System.out.println("==========================" + nodes.getLength());

        String nom = "";
        String cognom = "";
        int edad;
        int seguretatsocial;
        String ocupacio = "";

        for(int temp = 0; temp < nodes.getLength(); temp++) {
            Node nNode = nodes.item(temp);

            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Element element = (Element) nNode;
                nom = eElement.getElementsByTagName("nom").item(0).getTextContent();
                cognom = eElement.getElementsByTagName("cognom").item(0).getTextContent();
                edad = Integer.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent());
                seguretatsocial = Integer.parseInt(eElement.getElementsByTagName("seguretatsocial").item(0).getTextContent());
                ocupacio = eElement.getElementsByTagName("ocupacio").item(0).getTextContent();

                if(ocupacio.equals("Venedor")){
                    this.empleats.add(new Vendedor(nom,cognom,edad,seguretatsocial));
                }


            }
        }

    }


    public void anadirEmpleado(Empleat empleat){

        this.empleats.add(empleat);


        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();


            Element eRaiz = doc.createElement("empleats");

            doc.appendChild(eRaiz);

            for (Empleat e: this.empleats) {

                Element eEmpleado = doc.createElement("empleat");
                eRaiz.appendChild(eEmpleado);

                Element eNombre = doc.createElement("nom");
                eNombre.appendChild(doc.createTextNode(e.getNom()));
                eEmpleado.appendChild(eNombre);

                Element eCognom = doc.createElement("cognom");
                eCognom.appendChild(doc.createTextNode(e.getCognom()));
                eEmpleado.appendChild(eCognom);

                Element eEdad= doc.createElement("edad");
                eEdad.appendChild(doc.createTextNode(e.getEdad()+""));
                eEmpleado.appendChild(eEdad);

                Element eSeguretatsocial = doc.createElement("seguretatsocial");
                eSeguretatsocial.appendChild(doc.createTextNode(e.getSeguretatsocial()+""));
                eEmpleado.appendChild(eSeguretatsocial);

                Element eOcupacio = doc.createElement("ocupacio");

                if(e instanceof Vendedor) eOcupacio.appendChild(doc.createTextNode("Venedor"));
                else eOcupacio.appendChild(doc.createTextNode("No venedor"));
                eEmpleado.appendChild(eOcupacio);

            }




            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(this.empleatsFile);

            transformer.transform(source, result);

            System.out.println("File saved!");
        }catch (Exception e){
            e.fillInStackTrace();
        }


    }
}
