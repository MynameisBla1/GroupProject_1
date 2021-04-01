package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void makeDB(){
        Controller.dataBase();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tetris Game Clone");

        Scene scene = new Scene(root,350,475);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        makeDB();
        launch(args);
    }
}
