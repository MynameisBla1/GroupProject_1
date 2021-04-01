package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.TimerTask;

public class Game extends Parent {
    public boolean pause = false;
    public boolean end = false;
    int highest = 0;
    public String input = "";
    GameBoard board = new GameBoard();
    Text scoreLabel = new Text("Score:");

    Text scoreValue = new Text("0");
    java.util.Timer timer = new java.util.Timer();
    Font f = new Font("arial", 20);

    Rectangle r = new Rectangle();


    Text high = new Text(null);
    Text highs = new Text(null);

    Text over = new Text("GAME OVER");
    Text n = new Text("click n for a new game");

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
                if(pause == false) {
                    board.moveDownIfCan();
                }
            }

        }, 700, 500);


        new AnimationTimer(){

            public void handle(long currentNanoTime){

                if(end == false) {
                    if (input == "LEFT") {
                        board.moveLeftIfCan();
                    } else if (input == "RIGHT") {
                        board.moveRightIfCan();
                    } else if (input == "DOWN") {
                        board.moveDownIfCan();
                    } else if (input == "UP") {
                        board.rotateIfCan();
                    } else if (input == "P") {
                        System.out.println("pause");
                        pauseGame();
                    } else if (input == "R") {
                        System.out.println("resume");
                        resumeGame();
                    }
                }
                if (input == "N"){
                    board.newBoard();
                    end = false;
                    getChildren().removeAll(high,over,highs,n,r);
                }
                input = "";
                if(end == false) {
                    board.goToNextIfNeed();
                    board.deleteRowIfNeed();
                }
                scoreValue.setText(String.valueOf(board.score));
                if(end == false && board.isEndGame()==true){
                    //creating database

                    try (Statement query = Controller.conn.createStatement()) {
                        try {
                            query.execute("INSERT INTO scores VALUES('" + board.score + "')");
                            ResultSet rs = query.executeQuery("SELECT MAX(hs) FROM scores");
                            highest = rs.getInt("MAX(hs)");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    r.setHeight(GameBoard.BOARDHEIGHT);
                    r.setWidth(GameBoard.BOARDWIDTH);
                    r.setFill(Color.ALICEBLUE);
                    r.setOpacity(.6);
                    getChildren().add(r);
                    high.setText("your score was "+ board.score);
                    highs.setText("your highest score ever is " + highest);

                    over.setX(100);
                    over.setY(150);
                    over.setFont(f);
                    over.toFront();

                    high.setFont(f);
                    high.setX(90);
                    high.setY(200);
                    high.toFront();

                    highs.setX(50);
                    highs.setY(300);
                    highs.setFont(f);
                    highs.toFront();

                    n.setX(80);
                    n.setY(330);
                    n.setFont(f);
                    n.toFront();

                    getChildren().addAll(high,over,highs,n);

                    end = true;
                }
                /*if(board.score == 100){
                    board.clearMesh();

                }*/


            }
        }.start();
    }
    public void pauseGame(){
        pause = true;

    }
    public void resumeGame(){
        pause = false;
    }

}
