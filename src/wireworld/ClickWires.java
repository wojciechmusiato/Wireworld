/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author wojboj
 */
public interface ClickWires{
    int cellDim = WireGUI.wireGUI.cellDimension;
    int h = WireGUI.wireGUI.height;
    int w = WireGUI.wireGUI.width;
    void put(JButton source,boolean orientation);
}
