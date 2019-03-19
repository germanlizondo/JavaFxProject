package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEmpleats {

    DomXml domXml = new DomXml();

    @FXML
    private TextField nom;

    @FXML
    private TextField cognom;

    @FXML
    private TextField edad;

    @FXML
    private TextField ss;


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
}
