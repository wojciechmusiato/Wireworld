
package wirefactory;

import GUI.WireGUI;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author wojboj
 */
public interface ClickWires{
    int h = WireGUI.wireGUI.height;
    int w = WireGUI.wireGUI.width;
    void put(JButton source,boolean orientation);
}
