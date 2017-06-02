package wirefactory;

import javax.swing.JButton;

/**
 * Fabryka elementów rysowanych na planszy.
 *
 */
public class WireFactory {

    /**
     * Wybiera element, który fabryka ma stworzyć.
     *
     * @param wireType reprezentuje typ elementu, który przez fabrykę ma
     * być stworzony.
     * @param me przysisk, którego współrzędne będą punktem odniesienia przy
     * rysowaniu elementu.
     * @param orientation jeśli przekazana jest wartość true, element będzie
     * rysowany poziomo, w przeciwnym wypadku pionowo.
     */
    public void getWire(String wireType, JButton me, boolean orientation) {
        if (wireType.equalsIgnoreCase("Diode1")) {
            Diode1 d1 = new Diode1();
            d1.put(me, orientation);
        } else if (wireType.equalsIgnoreCase("Diode2")) {
            Diode2 d2 = new Diode2();
            d2.put(me, orientation);
        } else if (wireType.equalsIgnoreCase("HorizontalWire")) {
            HorizontalWire w1 = new HorizontalWire();
            w1.put(me, orientation);
        } else if (wireType.equalsIgnoreCase("DiagonalWire")) {
            DiagonalWire w2 = new DiagonalWire();
            w2.put(me, orientation);
        } else if (wireType.equalsIgnoreCase("ORgate")) {
            ORgate g1 = new ORgate();
            g1.put(me, orientation);
        } else if (wireType.equalsIgnoreCase("exORgate")) {
            exORgate g2 = new exORgate();
            g2.put(me, orientation);
        } else {
            SingleCell singleCell = new SingleCell();
            singleCell.put(me, orientation);
        }
    }
}
