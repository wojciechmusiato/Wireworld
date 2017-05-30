
package wirefactory;

import GUI.WireGUI;
import java.awt.Color;
import javax.swing.JButton;
import wireworld.CellGrid;

/**
 *
 * @author wojboj
 */
class SingleCell implements ClickWires {

    @Override
    public void put(JButton source, boolean orientation) {
        int i;
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() /     WireGUI.wireGUI.cellDimension;;
        int x = source.getX() /     WireGUI.wireGUI.cellDimension;;
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
