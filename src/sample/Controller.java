package sample;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;

public class Controller {
    @FXML
    private Button home;

    @FXML
    private Button empleats;

    @FXML
    private Button ventes;



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
}
