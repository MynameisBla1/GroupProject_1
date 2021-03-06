package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TPiece extends Piece{
    //initialize piece and state
    int position = 0;
    public TPiece(int x, int y){
        this.squares[0] = new Rectangle(x,y+GameBoard.BLOCKSIZE,GameBoard.RENDERSIZE,GameBoard.RENDERSIZE);
        this.squares[1] = new Rectangle(x+GameBoard.BLOCKSIZE,y+GameBoard.BLOCKSIZE,GameBoard.RENDERSIZE,GameBoard.RENDERSIZE);
        this.squares[2] = new Rectangle(x+GameBoard.BLOCKSIZE,y,GameBoard.RENDERSIZE,GameBoard.RENDERSIZE);
        this.squares[3] = new Rectangle(x+(2*GameBoard.BLOCKSIZE),y+GameBoard.BLOCKSIZE,GameBoard.RENDERSIZE,GameBoard.RENDERSIZE);
        for(int i = 0; i<4;i++) {
            this.squares[i].setFill(Color.LIGHTSEAGREEN); //set colour light sea green to this piece
        }
    }
    //Overriding rotate() function from Piece class
    @Override
    public void rotate(){
        super.rotate();
        //checks if can rotate or too close to edge
        if(position == 3){
            if((this.squares[0].getX()) >= (GameBoard.BOARDWIDTH-GameBoard.BLOCKSIZE)){
                return;
            }
        }
        else if(position == 1){
            if((this.squares[0].getX()) <=0 ){
                return;
            }
        }
        position = position +1; //add 1 to position
        if(position>3) {
            position = 0;
        }
        //changes position based on current
        if(position == 0){

            this.squares[0].setX(this.squares[0].getX()-GameBoard.BLOCKSIZE);
            this.squares[0].setY(this.squares[0].getY()-GameBoard.BLOCKSIZE);

            this.squares[2].setX(this.squares[2].getX()+GameBoard.BLOCKSIZE);
            this.squares[2].setY(this.squares[2].getY()-GameBoard.BLOCKSIZE);

            this.squares[3].setX(this.squares[3].getX()+GameBoard.BLOCKSIZE);
            this.squares[3].setY(this.squares[3].getY()+GameBoard.BLOCKSIZE);

        } else if(position == 1){
            this.squares[0].setX(this.squares[0].getX()+GameBoard.BLOCKSIZE);
            this.squares[0].setY(this.squares[0].getY()-GameBoard.BLOCKSIZE);

            this.squares[2].setX(this.squares[2].getX()+GameBoard.BLOCKSIZE);
            this.squares[2].setY(this.squares[2].getY()+GameBoard.BLOCKSIZE);

            this.squares[3].setX(this.squares[3].getX()-GameBoard.BLOCKSIZE);
            this.squares[3].setY(this.squares[3].getY()+GameBoard.BLOCKSIZE);

        } else if(position ==2){
            this.squares[0].setX(this.squares[0].getX()+GameBoard.BLOCKSIZE);
            this.squares[0].setY(this.squares[0].getY()+GameBoard.BLOCKSIZE);

            this.squares[2].setX(this.squares[2].getX()-GameBoard.BLOCKSIZE);
            this.squares[2].setY(this.squares[2].getY()+GameBoard.BLOCKSIZE);

            this.squares[3].setX(this.squares[3].getX()-GameBoard.BLOCKSIZE);
            this.squares[3].setY(this.squares[3].getY()-GameBoard.BLOCKSIZE);


        } else {

            this.squares[0].setX(this.squares[0].getX()-GameBoard.BLOCKSIZE);
            this.squares[0].setY(this.squares[0].getY()+GameBoard.BLOCKSIZE);

            this.squares[2].setX(this.squares[2].getX()-GameBoard.BLOCKSIZE);
            this.squares[2].setY(this.squares[2].getY()-GameBoard.BLOCKSIZE);


            this.squares[3].setX(this.squares[3].getX()+GameBoard.BLOCKSIZE);
            this.squares[3].setY(this.squares[3].getY()-GameBoard.BLOCKSIZE);
        }
    }
}