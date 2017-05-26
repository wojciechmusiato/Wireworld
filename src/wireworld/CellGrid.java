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
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author wojboj
 */
public class CellGrid {

    public static int count = -1;
    public static ArrayList boards = new ArrayList<CellGrid>();
    private int height;
    private int width;
    final Cell grid[][];

    public CellGrid(int height, int width) {
        this.width = width;
        this.height = height;
        CellGrid.count++;
        boards.add(this);
        System.out.println(CellGrid.count);
        grid = new Cell[height + 2][width + 2];
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public CellGrid getGrid() {
        return ((CellGrid) CellGrid.boards.get(CellGrid.count));
    }

    public Cell[][] getCellGrid() {
        return grid;
    }

    public Cell getCell(int y, int x) {
        return grid[y][x];
    }

    public void clear() {

        CellGrid.boards.subList(1, CellGrid.boards.size()).clear();
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(0);
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                cellgrid.grid[i][j].setValue(0);
            }
        }

    }

    public void setCell(int y, int x, int v) {
        Cell c;
        switch (v) {
            case 0: {
                c = new Empty(y, x);
                break;
            }
            case 1: {
                c = new Conductor(y, x);
                break;
            }
            case 2: {
                c = new Tail(y, x);
                break;
            }
            case 3: {
                c = new Head(y, x);
                break;
            }
            default: {
                c = new Cell(y, x);
                break;
            }
        }
        if (x > width) {

            throw new ArrayIndexOutOfBoundsException("x > width");
        }
        if (y > height) {
            throw new ArrayIndexOutOfBoundsException("y > height");
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

    public void Update(CellGrid basicgrid) {
        for (int i = 1; i < height + 1; i++) {
            for (int j = 1; j < width + 1; j++) {
                grid[i][j] = basicgrid.getCell(i, j);
            }
        }
    }

    public int countHeadNeighbours(int y, int x) {
        int counter = 0;
        if (getCell(y, x).getValue() == 3) {
            counter--;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getCell(y - 1 + i, x - 1 + j).getValue() == 3) {
                    counter++;
                }
            }
        }
        return counter;

    }

    public int countTailNeighbours(int y, int x) {
        int counter = 0;
        if (getCell(y, x).getValue() == 3) {
            counter--;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getCell(y - 1 + i, x - 1 + j).getValue() == 2) {
                    counter++;
                }
            }
        }
        return counter;

    }

}
