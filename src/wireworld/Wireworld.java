
package wireworld;

import GUI.WireStartGUI;
import javax.swing.SwingUtilities;

/**
 * 
 * @author wojboj
 */
public class Wireworld {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WireStartGUI();
            }
        });
    }
}
