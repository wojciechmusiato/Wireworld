/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author wojboj
 */
public class GridSaveRead implements Serializable {
    private final JFileChooser Saver = new JFileChooser();
    private GridSaveRead ok;
    public GridSaveRead() {
        ok= this;
    }

    public void Save() throws FileNotFoundException, IOException  {
       CellGrid cells = (CellGrid) CellGrid.boards.get(CellGrid.count);

        FileOutputStream fout = new FileOutputStream("bork.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(null);
        oos.close();
        fout.close();
      
    }

    public void Read() {

        WireStartGUI.startGUI.Chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = WireStartGUI.startGUI.Chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = WireStartGUI.startGUI.Chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }
}
