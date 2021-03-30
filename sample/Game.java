package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;

public class Game extends Parent {

    public String input = "";
    GameBoard board = new GameBoard();
    Text scoreLabel = new Text("Score:");

    Text scoreValue = new Text("0");
    java.util.Timer timer = new java.util.Timer();


    public Game(){


    }
    public void setUp(){
        getScene().setOnKeyReleased(

                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        input = keyEvent.getCode().toString();
                    }
                }
        );
        scoreLabel.setX(10);
        scoreLabel.setY(10);
        scoreValue.setX(75);
        scoreValue.setFill(Color.BLACK);
        scoreValue.setY(10);


        getChildren().addAll(board,scoreLabel,scoreValue);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                board.currentPiece.moveDown();
            }

        }, 700, 500);


        new AnimationTimer(){

            public void handle(long currentNanoTime){

                if(input == "LEFT"){
                    board.moveLeftIfCan();
                }
                else if(input == "RIGHT"){
                    board.moveRightIfCan();
                }
                else if(input == "DOWN"){
                    board.moveDownIfCan();
                }
                else if(input == "UP"){
                    board.rotateIfCan();
                }
                // Restart funtion
                else if (input =="N"){
                    board.clearMesh();
                }
              // pause funtion
                else if (input == "P"){timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    }

                }, -10000, -10000);}

                else if (input == "R"){timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                    }
                },100,100);}

                //else if(input == "SPACE"){
                //  do{board.moveDownIfCan();}while()


                //}
                input = "";
                board.goToNextIfNeed();
                board.deleteRowIfNeed();
                scoreValue.setText(String.valueOf(board.score));
                /*if(board.score == 100){
                    board.clearMesh();

                }*/


            }
        }.start();
    }



}
