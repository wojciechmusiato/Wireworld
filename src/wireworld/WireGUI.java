/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author wojboj
 */
public class WireGUI extends JFrame {

    private final JPanel menuPanel;
    private final JPanel cellPanel;
    private final JScrollPane scrollPane;
    private final JButton Start = new JButton();
    private final JButton Clear;
    private final JButton Cell[][];
    private final JPanel cellGrid;
    // private final JButton Stop;
    //private final JButton Edytuj;

    public WireGUI() {
        super("Wireworld!");

        menuPanel = new JPanel();
        cellPanel = new JPanel();

        menuPanel.setPreferredSize(new Dimension(200, 800));
        cellPanel.setPreferredSize(new Dimension(800, 800));

        this.add(menuPanel, BorderLayout.WEST);

        menuPanel.setBackground(Color.WHITE);
        cellPanel.setBackground(Color.BLACK);
        cellGrid = new JPanel();
        cellPanel.add(cellGrid,BorderLayout.WEST);
        cellGrid.setLayout(new GridLayout(20, 20));
        
        scrollPane = new JScrollPane(cellPanel);
        cellPanel.setPreferredSize(new Dimension(3600,3600));
        scrollPane.getViewport().setViewPosition(new java.awt.Point(1400,0));
        this.getContentPane().add(scrollPane);
        Clear = new JButton("Wyczyść");
        menuPanel.add(Clear);
        MenuHandler handler = new MenuHandler();
        MouseHandler mousehandler = new MouseHandler();
        Clear.addActionListener(handler);
        Cell = new JButton[20][20];
        cellGrid.setLayout(new GridLayout(20, 20));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Cell[i][j] = new JButton("");
                Cell[i][j].addMouseListener(mousehandler);
                cellGrid.add(Cell[i][j]);
                Cell[i][j].setPreferredSize(new Dimension(14, 14));
                Cell[i][j].setBackground(Color.BLACK);
            }
        }
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }

    private class MouseHandler implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class MenuHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Clear) {
                //CellGrid.clear();
            }
        }
    }
    

}
