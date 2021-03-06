package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;


public class ControllerEmpleats implements Initializable {

    DomXml domXml = new DomXml();
    private TreeSet<Tauleta> tauletas = new TreeSet<Tauleta>();
    private TreeSet<Videoconsola> videoconsolas = new TreeSet<Videoconsola>();
    private TreeSet<Gerent> gerents = new TreeSet<Gerent>();
    private TreeSet<Vendedor> vendedors = new TreeSet<Vendedor>();

    @FXML
    private Button home;
    @FXML
    private ToggleButton toogle;
    @FXML
    private Button empleats;

    @FXML
    private Button ventes;

    @FXML
    private TextField gerente;
    @FXML
    private TextField empleado;

    @FXML
    private TextField nom;

    @FXML
    private TextField cognom;

    @FXML
    private TextField edad;

    @FXML
    private TextField ss;

    @FXML
    private TableView tabla;



    @FXML
    public TableColumn<EmpleatTable, String> nomColumn;

    @FXML
    public TableColumn<EmpleatTable, String> tipo;

    @FXML
    public TableColumn<EmpleatTable, String> cognomColumn;
    @FXML
    public TableColumn<EmpleatTable, Integer> edadColumn;
    @FXML
    public TableColumn<EmpleatTable, Integer> ssColumn;



    // add your data here from any source
    private ObservableList<EmpleatTable> empleatTables = FXCollections.observableArrayList();



    @FXML
    public void anadirEmpleado(ActionEvent actionEvent) {
        Empleat empleat;
        if(toogle.isSelected()){
            empleat = new Gerent(nom.getText(),cognom.getText(),Integer.parseInt(edad.getText()),Integer.parseInt(ss.getText()));
            ((Gerent) empleat).encargarseDeEmpleados(gerents,vendedors);
            ((Gerent) empleat).encargarseDeProductos(tauletas,videoconsolas);
}
    else {
         empleat = new Vendedor(nom.getText(),cognom.getText(),Integer.parseInt(edad.getText()),Integer.parseInt(ss.getText()));

        }

        domXml.anadirEmpleado(empleat);

        nom.setText("");
        cognom.setText("");
        edad.setText("");
        ss.setText("");

        String tipo = "";
        if(empleat instanceof Vendedor) tipo = "Vendedor";
        else tipo = "Gerente";
        this.empleatTables.add(  new EmpleatTable(empleat.getNom(),empleat.getCognom(), empleat.getEdad(),empleat.getSeguretatsocial(),tipo));

    }


    @FXML
    public void canviarEscenaAction(ActionEvent actionEvent) {

        Stage stage = null;
        Parent root = null;
        try {

            if(actionEvent.getSource()==home){
                System.out.println("Home");

                stage=(Stage) empleats.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));


            }else if(actionEvent.getSource()==empleats){
                System.out.println("Empleats");



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

        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cognomColumn.setCellValueFactory(new PropertyValueFactory<>("cognom"));
        edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
        ssColumn.setCellValueFactory(new PropertyValueFactory<>("seguretatSocial"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));


        this.rellenarTabla();

        tabla.setItems(empleatTables);
    }


    public void rellenarTabla(){

        String tipo = "";
        for (Empleat e: this.domXml.getEmpleatQueue()) {

            if(e instanceof Vendedor){
                tipo = "Vendedor";

            }
            else {
                tipo = "Gerente";

            }
            this.empleatTables.add(  new EmpleatTable(e.getNom(),e.getCognom(), e.getEdad(),e.getSeguretatsocial(),tipo));
        }
    }



}
