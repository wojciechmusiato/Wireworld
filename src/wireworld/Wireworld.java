/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.EventQueue;
import javax.swing.SwingUtilities;

/**
 *
 * @author wojboj
 */
public class Wireworld {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WireStartGUI();
            }
        });
    }
}
