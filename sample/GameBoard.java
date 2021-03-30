package sample;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class GameBoard extends Parent {


    public static int BLOCKSIZE = 25;
    public static int BOARDWIDTH = 350;
    public static int BOARDHEIGHT = 475;
    public static int BOARDCOLUMNS = BOARDWIDTH/BLOCKSIZE;
    public static int BOARDROWS = BOARDHEIGHT/BLOCKSIZE;
    public static int RENDERSIZE = BLOCKSIZE-1;
    public Piece currentPiece = null;
    public static Color EMPTYCOLOR = Color.LIGHTCYAN;
    public int score = 0;

    private static Rectangle[][] mesh = new Rectangle[BOARDCOLUMNS][BOARDROWS];



    public GameBoard(){

        for(int i = 0; i<BOARDCOLUMNS; i++){
            for(int j = 0; j<BOARDROWS; j++){
                mesh[i][j] = new Rectangle(i*BLOCKSIZE,j*BLOCKSIZE,BLOCKSIZE,BLOCKSIZE);
                mesh[i][j].setFill(EMPTYCOLOR);
                getChildren().add(mesh[i][j]);
            }
        }
        nextPiece();

    }

    public void nextPiece(){
        currentPiece = Piece.createRandomPiece(((BOARDCOLUMNS/2)-1)*BLOCKSIZE,0);
        getChildren().addAll(currentPiece.squares);
    }

    public void moveLeftIfCan(){
        if(currentPiece.collideIf((-1*BLOCKSIZE),0,mesh)==false){
            currentPiece.moveLeft();
        }

    }
    public void moveRightIfCan() {
        if (currentPiece.collideIf(BLOCKSIZE, 0, mesh) == false){
            currentPiece.moveRight();
        }

    }
    public void moveDownIfCan(){
        if(currentPiece.collideIf(0,BLOCKSIZE,mesh)==false){
            currentPiece.moveDown();
        }

    }
    public void rotateIfCan(){
        currentPiece.rotate();
    }

    public void goToNextIfNeed(){
        if(currentPiece.isAtBottom() == true|| currentPiece.collideIf(0,BLOCKSIZE,mesh) == true){
            Rectangle [] squares = currentPiece.getSquares();

            for(Rectangle r : squares) {
                int x = (int)r.getX()/BLOCKSIZE;
                int y = (int)r.getY()/BLOCKSIZE;
                mesh[x][y] = r;
            }
            nextPiece();
        }

    }
    public void deleteRowIfNeed(){
        for(int y = BOARDROWS-1; y>0; y--){
            int numFull = 0;
            for(int x = 0; x < BOARDCOLUMNS; x++){
                if(mesh[x][y].getFill() != EMPTYCOLOR){
                    numFull++;
                } else{
                    break;
                }
            }
            if(numFull == BOARDCOLUMNS){
                score = score + 100;
                System.out.println(score);
                for(int x = 0; x < BOARDCOLUMNS; x++) {
                    mesh[x][y].setVisible(false);
                }
                for(int movey = y; movey > 0;movey--){
                    for(int movex = 0; movex<BOARDCOLUMNS; movex++){
                        mesh[movex][movey-1].setY(mesh[movex][movey-1].getY()+BLOCKSIZE);
                        mesh[movex][movey] = mesh[movex][movey-1];
                    }

                }
                for(int x = 0; x < BOARDCOLUMNS; x++) {
                    mesh[x][0]= new Rectangle(x*BLOCKSIZE, 0, BLOCKSIZE,BLOCKSIZE);
                    mesh[x][0].setFill(EMPTYCOLOR);
                    getChildren().add(mesh[x][0]);
                }

            }
        }

    }
    public void clearMesh(){
        for(int i = 0; i<BOARDCOLUMNS; i++){
            for(int j = 0; j<BOARDROWS; j++){
                mesh[i][j].setFill(EMPTYCOLOR);
                score = 0;
                currentPiece.clear();
            }
        }
    }

}
