
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
 * Moduł odpowiadający za zapis i wczytywanie planszy do Wireworlda.
 * @author wojboj
 */
public class GridSaveRead implements Serializable {

    /**
     *
     */
    public GridSaveRead() {

    }

    /**
     * Zapisuje aktualną generację do pliku. Zapisywane pliki mają rozszerzenie .ser i są serializowanymi obiektami CellGrid.
     * @throws FileNotFoundException
     * @throws IOException
     */
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

    /**
     * Otwiera okno wczytywania pliku oraz inicjuje Wireworlda wraz z konfiguracją z pliku.
     * @return zwraca wartość false, jeśli nie powiedzie się wczytywanie pliku.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public boolean Read() throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        boolean goodFile = false;
        JFileChooser fileChooser = new JFileChooser();
        File f = new File(new File(".").getCanonicalPath());
        fileChooser.setCurrentDirectory(f);
        int result = fileChooser.showOpenDialog(null);
        if (result == fileChooser.APPROVE_OPTION) {
            CellGrid loadedGrid = null;
            try {
                File selectedFile = fileChooser.getSelectedFile();
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
