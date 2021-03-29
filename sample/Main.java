package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tetris Game Clone");

        Scene scene = new Scene(root,350,475);
        primaryStage.setScene(scene);
        primaryStage.show();
        /*Game game = new Game();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 350, 475));
        game.setUp();
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
