package wireworld;

import javax.swing.JButton;

/**
 *
 * @author wojboj
 */
class HorizontalWire implements ClickWires {

    @Override
    public void put(JButton source, boolean orientation) {
        int i, j;
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() / cellDim;
        int x = source.getX() / cellDim;

        if (orientation) {
            for (i = 0; i < 6; i++) {
                if (x + i > w) {
                    WireGUI.wireGUI.setColor(x + i - w, y, 1);
                    cellgrid.setCell(y, x + i - w, 1);
                } else {
                    WireGUI.wireGUI.setColor(x + i, y, 1);
                    cellgrid.setCell(y, x + i, 1);
                }
            }
        } else {
            for (i = 0; i < 6; i++) {
                if (y + i > h) {
                    WireGUI.wireGUI.setColor(x, y+i-h, 1);
                    cellgrid.setCell(y+i-h, x, 1);
                } else {
                    WireGUI.wireGUI.setColor(x, y+i, 1);
                    cellgrid.setCell(y+i, x, 1);
                }
            }

        }
    }

}
