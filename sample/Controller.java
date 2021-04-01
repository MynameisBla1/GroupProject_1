package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Controller {
    public static Connection conn;
    public static void dataBase(){
        try{
            conn = DriverManager.getConnection("JDBC:sqlite:highscore.db");
            Statement query = conn.createStatement();
            query.execute("CREATE TABLE IF NOT EXISTS scores(hs INTEGER)");}
        catch(SQLException e){
            System.out.println("exception "+e);
        }

    }
    @FXML
    Button beginGame;


    @FXML
    public void changeScreen(ActionEvent event) throws Exception {

        Stage stage;
        Parent root;
        if (event.getSource() == beginGame) {
            stage = (Stage) beginGame.getScene().getWindow();
            Game g = new Game();

            root = g;
            Scene scene = new Scene(root);
            g.setUp();
            stage.setScene(scene);
            stage.show();
        }
        else{
            stage = (Stage) beginGame.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }

    }



}
