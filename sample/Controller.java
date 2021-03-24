package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField gameOver;
    @FXML
    Button beginGame;
    Rectangle r = new Rectangle(5, 5);
    static String input = "";

    @FXML
    public void changeScreen(ActionEvent event) throws Exception {

        Stage stage;
        Parent root;
        if (event.getSource() == beginGame) {
            stage = (Stage) beginGame.getScene().getWindow();
            root = new gameScreen();
            //root = FXMLLoader.load(getClass().getResource("test.fxml"));


        } else {
            stage = (Stage) beginGame.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        }
        Scene scene = new Scene(root);
        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        input = keyEvent.getCode().toString();
                    }
                }

        );
        stage.setScene(scene);
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


