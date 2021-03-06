
package wirefactory;

import GUI.WireGUI;
import javax.swing.JButton;
import wireworld.CellGrid;

/**
 * Klasa odpowiedzialna za rysowanie ukośnego kabla na planszy.
 * 
 */
class DiagonalWire implements ClickWires {
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

        if (orientation) {
            for (i = 0; i < 6; i++) {                                           //dodanie sześciu przewodnikow+4, żeby zrobić diodę
                if ((x + i > w) && (y + i < h + 1) && (y + i > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
                    WireGUI.wireGUI.setColor(x + i - w, y + i, 1);
                    cellgrid.setCell(y + i, x + i - w, 1);
                } else if ((x + i > w) && (y + i > h)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x + i - w, 1);
                } else if ((x + i > w) && (y + i < 1)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + i + h, 1);
                    cellgrid.setCell(y + i + h, x + i - w, 1);
                } else if ((y + i < 1)) {
                    WireGUI.wireGUI.setColor(x + i, y + i + h, 1);
                    cellgrid.setCell(y + i + h, x + i, 1);
                } else if ((y + i > h)) {
                    WireGUI.wireGUI.setColor(x + i, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x + i, 1);
                } else if (x + i < 1) {
                    WireGUI.wireGUI.setColor(x + i + w, y + i, 1);
                    cellgrid.setCell(y + i, x + i + w, 1);
                } else if ((x + i < 1) && (y + i > h)) {
                    WireGUI.wireGUI.setColor(x + i + w, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x + i + w, 1);
                } else if ((x + i < 1) && (y + i < 0)) {
                    WireGUI.wireGUI.setColor(x + i + w, y + i + h, 1);
                    cellgrid.setCell(y + i + h, x + i + w, 1);
                } else {
                    WireGUI.wireGUI.setColor(x + i, y + i, 1);
                    cellgrid.setCell(y + i, x + i, 1);
                }
            }
        } else {
            for (i = 0; i < 6; i++) {
                if ((y + i > h) && (x - 1 + i < w + 1) && (x - 1 + i > 0)) {
                    WireGUI.wireGUI.setColor(x - i, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x - i, 1);
                } else if ((y + i > h) && (x - i > w)) {
                    WireGUI.wireGUI.setColor(x - i - w, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x - i - w, 1);
                } else if ((y + i > h) && (x - i < 1)) {
                    WireGUI.wireGUI.setColor(x - i + w, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x - i + w, 1);
                } else if ((x - i < 1)) {
                    WireGUI.wireGUI.setColor(x - i + w, y + i, 1);
                    cellgrid.setCell(y + i, x - i + w, 1);
                } else if ((x - i > w)) {
                    WireGUI.wireGUI.setColor(x - i - w, y + i, 1);
                    cellgrid.setCell(y + i, x - i - w, 1);
                } else if (y + i < 1) {
                    WireGUI.wireGUI.setColor(x - i, y + i + h, 1);
                    cellgrid.setCell(y + i + h, x - i, 1);
                } else if ((y + i < 1) && (x - i > w)) {
                    WireGUI.wireGUI.setColor(x - i - w, y + i + h, 1);
                    cellgrid.setCell(y + i + h, x - i - w, 1);
                } else if ((y + i < 1) && (x - i < 0)) {
                    WireGUI.wireGUI.setColor(x - i + w, y + i + h, 1);
                    cellgrid.setCell(y + i + h, x - i + w, 1);
                } else {
                    WireGUI.wireGUI.setColor(x - i, y + i, 1);
                    cellgrid.setCell(y + i, x - i, 1);
                }
            }

        }
    }

}
