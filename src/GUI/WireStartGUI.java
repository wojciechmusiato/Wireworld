
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import wireworld.CellGrid;
import wireworld.GridSaveRead;

/**
 *
 * @author wojboj
 */
public class WireStartGUI extends JFrame {

    public static WireStartGUI startGUI;
    private final JPanel openPanel;
    private final JButton Generuj;
    private final JTextField heightField;
    private final JTextField widthField;
    private final JLabel Label1;
    private final JLabel Label2;
    private final JLabel Label3;
    private final JButton wczytaj;
    public final JFileChooser Chooser = new JFileChooser();

    public WireStartGUI() {
        super("Wireworld");
        startGUI = this;
        openPanel = new JPanel();
        this.add(openPanel);

        heightField = new JTextField("30", 5);
        widthField = new JTextField("30", 5);

        Label1 = new JLabel("Wybierz szerokość i wysokość planszy:");
        Label2 = new JLabel("Wysokość");
        Label3 = new JLabel("Szerokość");

        openPanel.add(Label1);
        openPanel.add(Label2);
        openPanel.add(heightField);
        openPanel.add(Label3);
        openPanel.add(widthField);
        wczytaj = new JButton("Wczytaj z pliku...");
        Generuj = new JButton("Generuj");
        Generuj.setSize(200, 40);
        openPanel.add(Generuj);
        openPanel.add(wczytaj);
        ListenForButton lForButton = new ListenForButton();
        Generuj.addActionListener(lForButton);
        wczytaj.addActionListener(lForButton);
        this.setSize(300, 120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void Popup(String message) {
        JFrame frame;
        frame = new JFrame("Info");
        JOptionPane.showMessageDialog(frame, message);
    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int h = 251;
            int w = 251;
            try {
                h = Integer.parseInt(heightField.getText());
                w = Integer.parseInt(widthField.getText());
            } catch (Exception ex) {
                Popup("Nie wiem co tam wpisałeś ale to na pewno nie liczby ");
            }
            if (e.getSource() == Generuj) {
                if (h > 251 || w > 251) {
                    Popup("Wymiary za duże! Żaden wymiar nie może przekraczać 250");
                } else if (h < 0 || w < 0) {
                    Popup("Ujemne wymiary? Kto to o czymś takim słyszał ");
                } else if (h == 0 || w == 0) {
                    Popup("Tak powodzenia z zerową wysokością lub szerokością ");
                } else if (h < 10 || w < 10) {
                    Popup("Oba rozmiary planszy powinny mieścić się w zakresie 10-250");
                } else if (h > 9 && h < 251 && w > 9 && w < 251) {

                    try {
                        new WireGUI(h, w);
                    } catch (Exception ex) {
                        Logger.getLogger(WireStartGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    new CellGrid(h, w);

                    setVisible(false);
                    dispose();
                } else {

                }
            }
            if (wczytaj == e.getSource()) {
                GridSaveRead saveread = new GridSaveRead();
                try {
                    if(saveread.Read()){
                        setVisible(false);
                        dispose();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(WireStartGUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(WireStartGUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(WireStartGUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                
                

            }
        }
    }

}
