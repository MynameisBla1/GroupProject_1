package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField gameOver;
    @FXML
    private Button beginGame;
    Rectangle r = new Rectangle(5, 5);


    @FXML
    public void changeScreen(javafx.event.ActionEvent event) throws Exception{

        Stage stage;
        Parent root;
        if(event.getSource() == beginGame){
            stage = (Stage) beginGame.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("test.fxml"));

        }
        else{
            stage = (Stage) beginGame.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("test.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    Shape a = new Shape() {
        Rectangle v = new Rectangle(2,5);
        Rectangle h = new Rectangle(1,6);
    };

}