/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author wojboj
 */
public class CellGrid {
    public static CellGrid cellgrid;
    private int height;
    private int width;
    private final Cell grid[][];

    public CellGrid(int height, int width) {
        this.width= width;
        this.height = height;
        cellgrid = this;
        grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(j, i);
            }
        }
    }
    public CellGrid getGrid(){
        return cellgrid;
    }
    public void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j].setValue(0);
            }
        }
    }

    public void setCell(int x, int y, int v) {
        Cell c;
        switch (v) {
            case 0: {
                c = new Empty(x,y);
                break;
            }
            case 1: {
                c = new Conductor(x,y);
                break;
            }
            case 2: {
                c = new Tail(x,y);
                break;
            }
            case 3: {
                c = new Head(x,y);
                break;
            }
            default: {
                c = new Cell(x,y);
                break;
            }
        }
        if (x > grid[y][x].getX()) {
            
            throw new ArrayIndexOutOfBoundsException();
        }
        if (y > grid[y][x].getY()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (x < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (y < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }


        grid[y][x] = c;
    }

    public int getHeights() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidths() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
}
