package sample;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

public class Bricks {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    private String name;
    public int form = 1;
    public boolean atBottom = false;
    //String letters = new String[

    public Bricks(Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Bricks(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;

        switch (name) {
            case "j":
                color = Color.HOTPINK;
                break;
            case "l":
                color = Color.INDIANRED;
                break;
            case "o":
                color = Color.LIGHTGOLDENRODYELLOW;
                break;
            case "s":
                color = Color.FORESTGREEN;
                break;
            case "t":
                color = Color.DARKBLUE;
                break;
            case "z":
                color = Color.PAPAYAWHIP;
                break;
            case "i":
                color = Color.ORANGERED;
                break;

        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }


    public String getName() {
        return name;
    }

    public void changeForm() {
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }


    // Getting the numbers and the MESH from Tetris
    public static final int MOVE = Main.MOVE;
    public static final int SIZE = Main.SIZE;
    public static int XMAX = Main.XMAX;
    public static int YMAX = Main.YMAX;
    public static int[][] MESH = Main.MESH;

    public static Bricks makeRect() {
        int block = (int) (Math.random() * 100);
        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1),
                b = new Rectangle(SIZE - 1, SIZE - 1),
                c = new Rectangle(SIZE - 1, SIZE - 1),
                d = new Rectangle(SIZE - 1, SIZE - 1);
        if (block < 15) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }
        return new Bricks(a, b, c, d, name);
    }
    public void moveRight(){
        if(a.getX()< 375 && b.getX()<375 && c.getX()<375 && d.getX()<375) {
            a.setX(a.getX() + MOVE);
            b.setX(b.getX() + MOVE);
            c.setX(c.getX() + MOVE);
            d.setX(d.getX() + MOVE);
        }

    }
    public void moveLeft(){
        if(a.getX()> 0 && b.getX()>0 && c.getX()>0 && d.getX()>0) {
            a.setX(a.getX() - MOVE);
            b.setX(b.getX() - MOVE);
            c.setX(c.getX() - MOVE);
            d.setX(d.getX() - MOVE);
        }

    }
    public void rotate(){
        //need code to rotate
    }
    public void moveDown(){
        if(a.getY()<525  && b.getY()<525 && c.getY()<525 && d.getY()<525){
            a.setY(a.getY() +MOVE);
            b.setY(b.getY() +MOVE);
            c.setY(c.getY() +MOVE);
            d.setY(d.getY() +MOVE);
        }
        else{
            atBottom = true;
        }

    }

    public Boolean doesNextOverlap(Bricks other){

        Rectangle tempA = new Rectangle(other.a.getX(), other.a.getY()+Main.MOVE, other.a.getWidth(), other.a.getHeight());
        Rectangle tempB = new Rectangle(other.b.getX(), other.b.getY()+Main.MOVE, other.b.getWidth(), other.b.getHeight());
        Rectangle tempC = new Rectangle(other.c.getX(), other.c.getY()+Main.MOVE, other.c.getWidth(), other.c.getHeight());
        Rectangle tempD = new Rectangle(other.d.getX(), other.d.getY()+Main.MOVE, other.d.getWidth(), other.d.getHeight());

        if(a.intersects(tempA.getBoundsInParent())) {
            return true;
        }
        if(a.intersects(tempB.getBoundsInParent())) {
            return true;
        }
        if(a.intersects(tempC.getBoundsInParent())) {
            return true;
        }
        if(a.intersects(tempD.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(tempA.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(tempB.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(tempC.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(tempD.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(tempA.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(tempB.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(tempC.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(tempD.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(tempA.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(tempB.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(tempC.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(tempD.getBoundsInParent())) {
            return true;
        }
        return false;

    }

    public Boolean doesOverlap(Bricks other){
        if(a.intersects(other.a.getBoundsInParent())) {
            return true;
        }
        if(a.intersects(other.b.getBoundsInParent())) {
            return true;
        }
        if(a.intersects(other.c.getBoundsInParent())) {
            return true;
        }
        if(a.intersects(other.d.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(other.a.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(other.b.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(other.c.getBoundsInParent())) {
            return true;
        }
        if(b.intersects(other.d.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(other.a.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(other.b.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(other.c.getBoundsInParent())) {
            return true;
        }
        if(c.intersects(other.d.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(other.a.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(other.b.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(other.c.getBoundsInParent())) {
            return true;
        }
        if(d.intersects(other.d.getBoundsInParent())) {
            return true;
        }
        return false;

    }




}
