/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author wojboj
 */
public class Cell {
    protected  int value;
    protected  int x;
    protected  int y;


    public Cell(int x, int y) {
        this.y=y;
        this.x=x;
        value = 0;
    }


   /* public void setColor(Cell cell) {
        if (cell.state == State.EMPTY) {
            cell.setBackground(Color.BLACK);
            clickNumber = 0;
        } else if (cell.state == State.CONDUCTOR) {
            cell.setBackground(Color.YELLOW);
            clickNumber = 1;
        } else if (cell.state == State.ELECTRON_HEAD) {
            cell.setBackground(Color.BLUE);
            clickNumber = 2;
        } else if (cell.state == State.ELECTRON_TAIL) {
            cell.setBackground(Color.RED);
            clickNumber = 3;
        }
    }
*/
    public  void setValue(int v){
        this.value = v;
    }
    public int getValue(){
        return value;
    }
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    };

}
