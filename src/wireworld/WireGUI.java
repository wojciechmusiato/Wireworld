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
        CellGrid cellGrid = new CellGrid();
        cellPanel.add(cellGrid,BorderLayout.WEST);
        scrollPane = new JScrollPane(cellPanel);
        cellPanel.setPreferredSize(new Dimension(3600,3600));
        scrollPane.getViewport().setViewPosition(new java.awt.Point(1400,0));
        //scrollPane.getHorizontalScrollBar().setValue(WIDTH);
        this.getContentPane().add(scrollPane);
        Clear = new JButton("Wyczyść");
        menuPanel.add(Clear);
        MenuHandler handler = new MenuHandler();
        Clear.addActionListener(handler);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }

    private class MenuHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Clear) {
                CellGrid.clear();
            }
        }
    }

}
