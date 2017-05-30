/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import static wireworld.CellGrid.boards;

/**
 *
 * @author wojboj
 */
public class GridSaveRead implements Serializable {

    private final JFileChooser Saver = new JFileChooser();

    public GridSaveRead() {

    }

    public void Save() throws FileNotFoundException, IOException {
        CellGrid cells = (CellGrid) CellGrid.boards.get(CellGrid.count);

        FileOutputStream fout = new FileOutputStream("bork.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(cells);
        oos.close();
        fout.close();
        WireStartGUI.startGUI.Popup("wypierdalaj xdddddf");

    }

    public boolean Read() throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        boolean goodFile = false;
        WireStartGUI.startGUI.Chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = WireStartGUI.startGUI.Chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            CellGrid loadedGrid = null;
            try{
            File selectedFile = WireStartGUI.startGUI.Chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            FileInputStream inputFileStream = new FileInputStream(selectedFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputFileStream);
            loadedGrid = (CellGrid) objectInputStream.readObject();
         
            objectInputStream.close();
            inputFileStream.close();
            }catch(java.io.StreamCorruptedException ex){
                    WireStartGUI.startGUI.Popup("Plik niekompatybilny lub uszkodzony");
                    return false;
                    
                    }catch(java.lang.NullPointerException e){
                       return false;
                    }
            new WireGUI(loadedGrid.height,loadedGrid.width);
            CellGrid.count++;
            boards.add(loadedGrid);
            System.out.println(CellGrid.count);
            WireGUI.wireGUI.updateCellGridPanel();
        }
        return goodFile;
    }
}
