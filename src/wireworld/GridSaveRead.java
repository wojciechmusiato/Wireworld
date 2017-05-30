
package wireworld;

import GUI.WireGUI;
import GUI.WireStartGUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Zapisz obecną generację");
        File f = new File(new File(".").getCanonicalPath());
        fileChooser.setCurrentDirectory(f);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();
            FileOutputStream fout = new FileOutputStream(saveFile + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(cells);
            oos.close();
            fout.close();

        }
    }

    public boolean Read() throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        boolean goodFile = false;
        File f = new File(new File(".").getCanonicalPath());
        WireStartGUI.startGUI.Chooser.setCurrentDirectory(f);
        int result = WireStartGUI.startGUI.Chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            CellGrid loadedGrid = null;
            try {
                File selectedFile = WireStartGUI.startGUI.Chooser.getSelectedFile();
                FileInputStream inputFileStream = new FileInputStream(selectedFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputFileStream);
                loadedGrid = (CellGrid) objectInputStream.readObject();
                objectInputStream.close();
                inputFileStream.close();
            } catch (java.io.StreamCorruptedException ex) {
                WireStartGUI.startGUI.Popup("Plik niekompatybilny lub uszkodzony");
                return false;

            } catch (java.lang.NullPointerException e) {
                return false;
            }
            new WireGUI(loadedGrid.height, loadedGrid.width);
            CellGrid.count++;
            boards.add(loadedGrid);
            System.out.println(CellGrid.count);
            WireGUI.wireGUI.updateCellGridPanel();
        }
        return goodFile;
    }
}
