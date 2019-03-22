package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class VentesController implements Initializable{


    public class ComparadorFecha implements Comparator<Venda> {

        @Override
        public int compare(Venda p1, Venda p2) {
            // TODO Auto-generated method stub
            return  p1.getFecha().compareTo(p2.getFecha());
        }

    }



    private ArrayList<Venda> ventas = new ArrayList<Venda>();

    @FXML
    private Button home;

    @FXML
    private Button empleats;

    @FXML
    private Button ventes;


    @FXML
    private TableView tablaVentas;
    

    @FXML
    public TableColumn<VentesTable, String> fecha;

    @FXML
    public TableColumn<VentesTable, String> productos;
    @FXML
    public TableColumn<VentesTable, Integer> precio;
    @FXML
    public TableColumn<VentesTable, String> vendedor;



    // add your data here from any source
    private ObservableList<VentesTable> ventesTables = FXCollections.observableArrayList();

    @FXML
    public void canviarEscenaAction(ActionEvent actionEvent) {

        Stage stage = null;
        Parent root = null;
        try {

            if(actionEvent.getSource()==home){


                stage=(Stage) empleats.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));


            }else if(actionEvent.getSource()==empleats){


                stage=(Stage) empleats.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("empleats.fxml"));

            }else if(actionEvent.getSource()==ventes){




            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.getStackTrace();
        }



    }

    public void leerXml(){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            File file = new File("src/sample/allsales.xml");
            SaxXml saxXml = new SaxXml();
            saxParser.parse(file,saxXml);

            this.ventas = saxXml.getVentas();

            this.ventas.sort(new ComparadorFecha());



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.leerXml();

        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        productos.setCellValueFactory(new PropertyValueFactory<>("productos"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        vendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));

        this.rellenarTabla();

        tablaVentas.setItems(ventesTables);
    }
    
    public String verProductos(Venda venda){
        String allProducts = "";
        for (Product p: venda.getProductes()) {
            allProducts += p.getReferencia()+" | ";
        }
        return allProducts;
    }


    public void rellenarTabla(){
        String pattern = "dd-MM-YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.ventas.forEach( v -> {
            this.ventesTables.add(  new VentesTable(simpleDateFormat.format(v.getFecha()).toString(),
                    this.verProductos(v),v.getPreuTotal(),
                    v.getVendedor().getNom()));
        });
    }





}


