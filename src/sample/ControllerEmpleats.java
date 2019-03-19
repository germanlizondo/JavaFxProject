package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class ControllerEmpleats {

    DomXml domXml = new DomXml();
    @FXML
    private Button home;

    @FXML
    private Button empleats;

    @FXML
    private Button ventes;

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
    public void initialize() {
        System.out.println("second");

    }

    @FXML
    public void anadirEmpleado(ActionEvent actionEvent) {

        Empleat empleat = new Vendedor(nom.getText(),cognom.getText(),Integer.parseInt(edad.getText()),Integer.parseInt(ss.getText()));
        domXml.anadirEmpleado(empleat);

        nom.setText("");
        cognom.setText("");
        edad.setText("");
        ss.setText("");
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
}
