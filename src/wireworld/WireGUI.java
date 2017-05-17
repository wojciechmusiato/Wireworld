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
    private final int width,height;
    private final JPanel menuPanel;
    private final JPanel cellPanel;
    private final JScrollPane scrollPane;
    private final JButton Start = new JButton();
    private final JButton Clear;
    private final JButton CellButton[][];
    private final JPanel cellGrid;
    // private final JButton Stop;
    //private final JButton Edytuj;

    public WireGUI(int width, int height) {
        super("Wireworld!");
        this.width= width;
        this.height = height;
        menuPanel = new JPanel();
        cellPanel = new JPanel();

        menuPanel.setPreferredSize(new Dimension(200, 800));
        cellPanel.setPreferredSize(new Dimension(800, 800));

        this.add(menuPanel, BorderLayout.WEST);

        menuPanel.setBackground(Color.WHITE);
        cellPanel.setBackground(Color.BLACK);
        cellGrid = new JPanel();
        cellPanel.add(cellGrid, BorderLayout.WEST);
        cellGrid.setLayout(new GridLayout(width, height));
        scrollPane = new JScrollPane(cellPanel);
        cellPanel.setPreferredSize(new Dimension(3600, 3600));
        scrollPane.getViewport().setViewPosition(new java.awt.Point(1400, 0));
        this.getContentPane().add(scrollPane);
        Clear = new JButton("Wyczyść");
        menuPanel.add(Clear);
        MenuHandler handler = new MenuHandler();
        MouseHandler mousehandler = new MouseHandler();
        Clear.addActionListener(handler);
        CellButton = new JButton[width][height];
        cellGrid.setLayout(new GridLayout(width, height));
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                CellButton[i][j] = new JButton("");
                CellButton[i][j].addMouseListener(mousehandler);
                cellGrid.add(CellButton[i][j]);
                CellButton[i][j].setPreferredSize(new Dimension(14, 14));
                CellButton[i][j].setBackground(Color.BLACK);
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
            
            JButton source = (JButton) me.getSource();
            if (source.getBackground() == Color.BLACK) {
                source.setBackground(Color.YELLOW);
                CellGrid.cellgrid.setCell(source.getX()/14,source.getY()/14,1);
            } else if (source.getBackground() == Color.YELLOW) {
                source.setBackground(Color.BLUE);
                CellGrid.cellgrid.setCell(source.getX()/14,source.getY()/14,2);
            } else if (source.getBackground() == Color.BLUE) {
                source.setBackground(Color.RED);
                CellGrid.cellgrid.setCell(source.getX()/14,source.getY()/14,3);
            } else {
                source.setBackground(Color.BLACK);
                CellGrid.cellgrid.setCell(source.getX()/14,source.getY()/14,0);
                System.out.println(source.getX());
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }

    private class MenuHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Clear) {
                CellGrid.cellgrid.clear();
                for(int i = 0; i<CellButton.length;i++)
                    for(int j = 0;j<CellButton.length;j++)
                     CellButton[i][j].setBackground(Color.BLACK);
                    
            }
        }
    }
}
