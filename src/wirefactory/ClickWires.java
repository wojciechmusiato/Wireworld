package wirefactory;

import GUI.WireGUI;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Interfejs rozszerzany przez klasy odpowiadające za rysowanie elementów na
 * planszy.
 */
public interface ClickWires {

    /**
     * Wysokość planszy
     */
    int h = WireGUI.wireGUI.height;
    /**
     * szerokość planszy
     */
    int w = WireGUI.wireGUI.width;

    /**
     * Rysuje wskazany element, biorąc za punkt odniesienia współrzędne
     * klikniętnego przycisku.
     *
     * @param source przysisk, którego współrzędne będą punktem odniesienia przy
     * rysowaniu elementu.
     * @param orientation jeśli przekazana jest wartość true, element będzie
     * rysowany poziomo, w przeciwnym wypadku pionowo.
     */
    void put(JButton source, boolean orientation);
}
