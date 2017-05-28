/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author wojboj
 */
public class GridSaveRead implements Serializable {

    public GridSaveRead()  {
        
    }
    public void Save() throws FileNotFoundException, IOException{
        FileOutputStream fout = new FileOutputStream("bork.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(CellGrid.boards);
    }
}
