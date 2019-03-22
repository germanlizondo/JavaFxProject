package sample;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable{

   public interface EncontrarProducto{
       Product encontrar(int ref);
   }

    private Hashtable<Integer,Product> products=new Hashtable<Integer, Product>();

    private Venda vendaAhora;
    @FXML
    private Button home;

    @FXML
    private Button empleats;

    @FXML
    private Button ventes;

    @FXML
    private ListView listaProductos;

    @FXML
    private TextField empleado;

    @FXML
    private TextField productos;



    EncontrarProducto productoEncontrado = (ref)->{

        for (Map.Entry<Integer, Product> entry : this.products.entrySet()) {

            Integer key = entry.getKey();
            Product value = entry.getValue();


           if(value.getReferencia() == ref) return  value;
        }
        return null;
    };



    @FXML
    public void canviarEscenaAction(ActionEvent actionEvent) {

        Stage stage = null;
        Parent root = null;
try {

    if(actionEvent.getSource()==home){
        System.out.println("Home");


    }else if(actionEvent.getSource()==empleats){
        System.out.println("Empleats");


        stage=(Stage) empleats.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("empleats.fxml"));


    }else if(actionEvent.getSource()==ventes){
        System.out.println("Ventes");

        stage=(Stage) empleats.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ventes.fxml"));

    }

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

}catch (Exception e){
    e.getStackTrace();
}



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            StaxXml staxXml = new StaxXml();
            int ctn = 1;
            for (Map.Entry<Integer, Product> entry : staxXml.getProductos().entrySet()) {

                Integer key = entry.getKey();
                Product value = entry.getValue();

                listaProductos.getItems().add(value);

                this.products.put(key,value);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void hacerVenta(ActionEvent actionEvent) {
        System.out.println("HACER VENTA");
       String emp = empleado.getText();
       String pros = productos.getText();
        Date hoy = new Date();

        String[] arrayProds = pros.split(",");

       this.vendaAhora = new Venda();
       this.vendaAhora.setFecha(hoy);
       this.vendaAhora.setVendedor(new Vendedor(emp));

       for (int x = 0;x < arrayProds.length;x++){
       this.vendaAhora.afegirProducteVenda(productoEncontrado.encontrar(Integer.parseInt(arrayProds[x])));
       }

      DomXmlVentas domXmlVentas = new DomXmlVentas();
       domXmlVentas.escribirVenda(this.vendaAhora);


       empleado.setText("");
       productos.setText("");



    }





}

