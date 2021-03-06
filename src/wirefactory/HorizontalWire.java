package wirefactory;

import wirefactory.ClickWires;
import GUI.WireGUI;
import javax.swing.JButton;
import wireworld.CellGrid;

/**
 * Klasa odpowiedzialna za rysowanie pionowego/poziomego kabla na planszy.
 * 
 */
class HorizontalWire implements ClickWires {
    /** Rysuje wskazany element, biorąc za punkt odniesienia współrzędne klikniętnego przycisku.  
     * 
     * @param source przysisk, którego współrzędne będą punktem odniesienia przy rysowaniu elementu.
     * @param orientation jeśli przekazana jest wartość true, element będzie rysowany poziomo, w przeciwnym wypadku pionowo.
     */
    @Override
    public void put(JButton source, boolean orientation) {
        int i, j;
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() /     WireGUI.wireGUI.cellDimension;;
        int x = source.getX() /     WireGUI.wireGUI.cellDimension;;

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
