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
class SingleCell implements ClickWires {

    @Override
    public void put(JButton source, boolean orientation) {
        int i;
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() / cellDim;
        int x = source.getX() / cellDim;
        if (source.getBackground() == Color.BLACK) {
            source.setBackground(Color.YELLOW);
            cellgrid.setCell(y, x, 1);
        } else if (source.getBackground() == Color.YELLOW) {
            source.setBackground(Color.BLUE);
            cellgrid.setCell(y, x, 2);
        } else if (source.getBackground() == Color.BLUE) {
            source.setBackground(Color.RED);
            cellgrid.setCell(y, x, 3);
        } else {
            source.setBackground(Color.BLACK);
            cellgrid.setCell(y, x, 0);

        }
    }

}
