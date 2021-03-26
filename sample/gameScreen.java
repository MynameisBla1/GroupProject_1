package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class gameScreen extends Group {
    String input = " ";
    boolean addNewBrick = false;
    Bricks currentBrick =  Bricks.makeRect();
    ArrayList<Bricks> brickList = new ArrayList<Bricks>();

    public gameScreen(){
        super();

        //creating score text
        Text scoreLabel = new Text("score:");
        scoreLabel.setX(5);
        scoreLabel.setY(10);

        Text scoreValue = new Text("0");
        scoreValue.setX(40);
        scoreValue.setY(10);
        //creating background
        GridPane grid = new GridPane();
        grid.setPrefWidth(400);
        grid.setPrefHeight(550);
        grid.setStyle("-fx-background-color: lightgrey");
        grid.setGridLinesVisible(true);

        //create brick and make visible

        getChildren().addAll(grid,currentBrick.a, currentBrick.b,currentBrick.c, currentBrick.d, scoreLabel,scoreValue );

        //timer to automatically move down bricks
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentBrick.moveDown();
            }
        }, 1000, 1000);






        new AnimationTimer(){
            public void handle(long currentNanoTime){

                if(Controller.input.equals("LEFT")){
                    System.out.println(Controller.input);
                    currentBrick.moveLeft();
                }
                if(Controller.input.equals("RIGHT")){
                    System.out.println(Controller.input);
                    currentBrick.moveRight();
                }
                if(Controller.input.equals("UP")){
                    System.out.println(Controller.input);
                    currentBrick.rotate();
                }
                if(Controller.input.equals("DOWN")){
                    System.out.println(Controller.input);
                    currentBrick.moveDown();
                }
                for(Bricks brick : brickList) {
                    if(brick.doesNextOverlap(currentBrick)) {
                        currentBrick.atBottom=true;
                    }
                }
                if(currentBrick.atBottom == true){
                    brickList.add(currentBrick);
                    currentBrick = Bricks.makeRect();
                    getChildren().addAll(currentBrick.a, currentBrick.b,currentBrick.c, currentBrick.d);
                    currentBrick.atBottom = false;
                }



                Controller.input = "";

            }

        }.start();
    }


}
