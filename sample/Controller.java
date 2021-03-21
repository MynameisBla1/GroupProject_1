package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField gameOver;
    @FXML
    Button beginGame;


    public void beginClicked(){
        System.out.println("button");
        beginGame.setDisable(true);
        gameOver.setDisable(true);
    }
}
