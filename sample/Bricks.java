package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Bricks {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    private String name;
    public int form = 1;
    public boolean atBottom = false;
    private static Bricks nextObj = Bricks.makeRect();
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
    public void rotate(){
        int f = form;
        switch(getName()){
            case "j":
                if(f ==1 && cB(a,1,-1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(a);
                    MoveDown(a);
                    MoveDown(c);
                    MoveLeft(c);
                    MoveDown(d);
                    MoveDown(d);
                    MoveLeft(d);
                    MoveLeft(d);
                    changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
                    MoveDown(a);
                    MoveLeft(a);
                    MoveLeft(c);
                    MoveUp(c);
                    MoveLeft(d);
                    MoveLeft(d);
                    MoveUp(d);
                    MoveUp(d);
                   changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
                    MoveLeft(a);
                    MoveUp(a);
                    MoveUp(c);
                    MoveRight(c);
                    MoveUp(d);
                    MoveUp(d);
                    MoveRight(d);
                    MoveRight(d);
                    changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
                    MoveUp(a);
                    MoveRight(a);
                    MoveRight(c);
                    MoveDown(c);
                    MoveRight(d);
                    MoveRight(d);
                    MoveDown(d);
                    MoveDown(d);
                   changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
                    MoveRight(a);
                    MoveDown(a);
                    MoveUp(c);
                    MoveRight(c);
                    MoveUp(b);
                    MoveUp(b);
                    MoveRight(b);
                    MoveRight(b);
                    changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
                    MoveDown(a);
                    MoveLeft(a);
                    MoveRight(b);
                    MoveRight(b);
                    MoveDown(b);
                    MoveDown(b);
                    MoveRight(c);
                    MoveDown(c);
                    changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
                    MoveLeft(a);
                    MoveUp(a);
                    MoveDown(c);
                    MoveLeft(c);
                    MoveDown(b);
                    MoveDown(b);
                    MoveLeft(b);
                    MoveLeft(b);
                    changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
                    MoveUp(a);
                    MoveRight(a);
                    MoveLeft(b);
                    MoveLeft(b);
                    MoveUp(b);
                    MoveUp(b);
                    MoveLeft(c);
                    MoveUp(c);
                    changeForm();
                    break;
                }
                break;
            case "o":
                break;
            case "s":
                if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveDown(a);
                    MoveLeft(a);
                    MoveLeft(c);
                    MoveUp(c);
                    MoveUp(d);
                    MoveUp(d);
                    changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveUp(a);
                    MoveRight(a);
                    MoveRight(c);
                    MoveDown(c);
                    MoveDown(d);
                    MoveDown(d);
                   changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveDown(a);
                    MoveLeft(a);
                    MoveLeft(c);
                    MoveUp(c);
                    MoveUp(d);
                    MoveUp(d);
                    changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveUp(a);
                    MoveRight(a);
                    MoveRight(c);
                    MoveDown(c);
                    MoveDown(d);
                    MoveDown(d);
                   changeForm();
                    break;
                }
                break;
            case "t":
                if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
                    MoveUp(a);
                    MoveRight(a);
                    MoveDown(d);
                    MoveLeft(d);
                    MoveLeft(c);
                    MoveUp(c);
                 changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
                    MoveRight(a);
                    MoveDown(a);
                    MoveLeft(d);
                    MoveUp(d);
                    MoveUp(c);
                    MoveRight(c);
                 changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
                    MoveDown(a);
                    MoveLeft(a);
                    MoveUp(d);
                    MoveRight(d);
                    MoveRight(c);
                    MoveDown(c);
                    changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
                    MoveLeft(a);
                    MoveUp(a);
                    MoveRight(d);
                    MoveDown(d);
                    MoveDown(c);
                    MoveLeft(c);
                 changeForm();
                    break;
                }
                break;
            case "z":
                if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveUp(b);
                    MoveRight(b);
                    MoveLeft(c);
                    MoveUp(c);
                    MoveLeft(d);
                    MoveLeft(d);
                changeForm();
                    break;
                }
                if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    MoveDown(b);
                    MoveLeft(b);
                    MoveRight(c);
                    MoveDown(c);
                    MoveRight(d);
                    MoveRight(d);
                 changeForm();
                    break;
                }
                if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveUp(b);
                    MoveRight(b);
                    MoveLeft(c);
                    MoveUp(c);
                    MoveLeft(d);
                    MoveLeft(d);
                    changeForm();
                    break;
                }
                if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    MoveDown(b);
                    MoveLeft(b);
                    MoveRight(c);
                    MoveDown(c);
                    MoveRight(d);
                    MoveRight(d);
                 changeForm();
                    break;
                }
                break;
            case "i":
                if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    MoveUp(a);
                    MoveUp(a);
                    MoveRight(a);
                    MoveRight(a);
                    MoveUp(b);
                    MoveRight(b);
                    MoveDown(d);
                    MoveLeft(d);
               changeForm();
                    break;
                }
                if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    MoveDown(a);
                    MoveDown(a);
                    MoveLeft(a);
                    MoveLeft(a);
                    MoveDown(b);
                    MoveLeft(b);
                    MoveUp(d);
                    MoveRight(d);
                  changeForm();
                    break;
                }
                if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    MoveUp(a);
                    MoveUp(a);
                    MoveRight(a);
                    MoveRight(a);
                    MoveUp(b);
                    MoveRight(b);
                    MoveDown(d);
                    MoveLeft(d);
                    changeForm();
                    break;
                }
                if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    MoveDown(a);
                    MoveDown(a);
                    MoveLeft(a);
                    MoveLeft(a);
                    MoveDown(b);
                    MoveLeft(b);
                    MoveUp(d);
                    MoveRight(d);
                  changeForm();
                    break;
                }
                break;
        }
        }

    public Boolean doesOverlap(Bricks other){
        Bricks o = other;
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
    private void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);

    }

    private void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0)
            rect.setX(rect.getX() - MOVE);
    }

    private void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0)
            rect.setY(rect.getY() - MOVE);
    }

    private void MoveDown() {
        if (a.getY() == YMAX - SIZE || b.getY() == YMAX - SIZE || c.getY() == YMAX - SIZE
                || d.getY() == YMAX - SIZE || moveA() || moveB() || moveC() || moveD()) {
            MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
            MESH[(int) b.getX() / SIZE][(int) b.getY() / SIZE] = 1;
            MESH[(int) c.getX() / SIZE][(int) c.getY() / SIZE] = 1;
            MESH[(int) d.getX() / SIZE][(int) d.getY() / SIZE] = 1;
            //RemoveRows(group);

            Bricks a = nextObj;
            nextObj = Bricks.makeRect();
            //object = a;
            Group group = new Group();
            group.getChildren().addAll(a.a, a.b, a.c, a.d);
           // moveOnKeyPress(a);
        }

        if (a.getY() + MOVE < YMAX && b.getY() + MOVE < YMAX && c.getY() + MOVE < YMAX
                && d.getY() + MOVE < YMAX) {
            int movea = MESH[(int) a.getX() / SIZE][((int) a.getY() / SIZE) + 1];
            int moveb = MESH[(int) b.getX() / SIZE][((int) b.getY() / SIZE) + 1];
            int movec = MESH[(int) c.getX() / SIZE][((int) c.getY() / SIZE) + 1];
            int moved = MESH[(int) d.getX() / SIZE][((int) d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                a.setY(a.getY() + MOVE);
                b.setY(b.getY() + MOVE);
                c.setY(c.getY() + MOVE);
                d.setY(d.getY() + MOVE);
            }
        }
    }

    private boolean moveA() {
        return (MESH[(int) a.getX() / SIZE][((int) a.getY() / SIZE) + 1] == 1);
    }

    private boolean moveB() {
        return (MESH[(int) b.getX() / SIZE][((int) b.getY() / SIZE) + 1] == 1);
    }

    private boolean moveC() {
        return (MESH[(int) c.getX() / SIZE][((int) c.getY() / SIZE) + 1] == 1);
    }

    private boolean moveD() {
        return (MESH[(int) d.getX() / SIZE][((int) d.getY() / SIZE) + 1] == 1);
    }
    private boolean cB(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }

}