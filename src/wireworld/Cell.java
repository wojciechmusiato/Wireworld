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
public class Cell extends JButton {
    public  int clickNumber;
    private  int row;
    private  int column;
    private State state;

    public enum State {
        EMPTY,
        ELECTRON_HEAD,
        ELECTRON_TAIL,
        CONDUCTOR
    }

    public Cell(int column, int row) {
        super("");
        setRow(row);
        setColumn(column);
        this.state = State.EMPTY;
        setColor(this);
        clickNumber = 0;
    }

    public Cell(int column, int row, State state) {
        super("");
        setRow(row);
        setColumn(column);
        setState(state);
        setColor(this);
    }

    public void setColor(Cell cell) {
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
    public void setColor(State state){
       this.state = state;
       this.setBackground(Color.BLACK);
    }

    

    public void setState(State state) {
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
