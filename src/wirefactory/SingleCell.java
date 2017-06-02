
package wirefactory;

import GUI.WireGUI;
import java.awt.Color;
import javax.swing.JButton;
import wireworld.CellGrid;

/**
 * Klasa odpowiedzialna za rysowanie i zmienianie stanu komórki na planszy.
 * 
 */
class SingleCell implements ClickWires {
    /** Rysuje wskazany element, biorąc za punkt odniesienia współrzędne klikniętnego przycisku.  
     * 
     * @param source przysisk, którego współrzędne będą punktem odniesienia przy rysowaniu elementu.
     * @param orientation jeśli przekazana jest wartość true, element będzie rysowany poziomo, w przeciwnym wypadku pionowo.
     */
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
