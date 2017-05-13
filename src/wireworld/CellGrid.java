/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import wireworld.Cell.State;

/**
 *
 * @author wojboj
 */
public class CellGrid extends JPanel implements MouseListener {

    private static int height;
    private static int width;
    private static Cell grid[][];
    //ok

    public CellGrid() {
        
        grid = new Cell[width + 2][height + 2];
        setLayout(new GridLayout(width + 2, height + 2));
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                grid[i][j] = new Cell(i, j);
                grid[i][j].addMouseListener(this);
                add(grid[i][j]);
                grid[i][j].setPreferredSize(new Dimension(14, 14));

            }
        }
        grid[0][0].setVisible(false);
        grid[0][height + 1].setVisible(false);
        grid[width + 1][0].setVisible(false);
        grid[width  + 1][height + 1].setVisible(false);
        for (int i = 0; i <= height; i++) {
            grid[0][i].setVisible(false);
            grid[width  + 1][i].setVisible(false);
        }
        for (int i = 1; i <= width ; i++) {
            grid[i][0].setVisible(false);
            grid[i][height + 1].setVisible(false);
        }

    }

    public static void clear() {
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                grid[i][j].setColor(State.EMPTY);
                grid[i][j].clickNumber = 0;
            }
        }
    }

    public static int getHeights() {
        return height;
    }

    public static void setHeight(int height) {
        CellGrid.height = height;
    }

    public static int getWidths() {
        return width;
    }

    public static void setWidth(int width) {
        CellGrid.width = width;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        Cell source = (Cell) me.getSource();
        switch (source.clickNumber) {
            case 0:
                grid[source.getColumn()][source.getRow()].setBackground(Color.YELLOW);
                break;
            case 1:
                grid[source.getColumn()][source.getRow()].setBackground(Color.BLUE);
                break;
            case 2:
                grid[source.getColumn()][source.getRow()].setBackground(Color.RED);
                break;
            case 3:
                grid[source.getColumn()][source.getRow()].setBackground(Color.BLACK);
                break;
            default:
                break;
        }
        source.clickNumber++;
        if (source.clickNumber == 4) {
            source.clickNumber = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
