/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wojboj
 */
public class WireStartGUI extends JFrame {

    private final JPanel openPanel;
    private final JButton Generuj;
    private final JTextField heightField;
    private final JTextField widthField;
    private final JLabel Label1;
    private final JLabel Label2;
    private final JLabel Label3;
    private final JButton wczytaj;
    private final JFileChooser Chooser = new JFileChooser();

    public WireStartGUI() {
        super("Wireworld");

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

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Generuj) {
                int h = Integer.parseInt(heightField.getText());
                int w = Integer.parseInt(widthField.getText());
                try {
                    new WireGUI(h, w);
                } catch (Exception ex) {
                    Logger.getLogger(WireStartGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                new CellGrid(h, w);
                setVisible(false);
                dispose();
            } 
            if(wczytaj == e.getSource()){
                System.out.println("chuj");
                Chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = Chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = Chooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }

            }
        }
    }

}
