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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author wojboj
 */
public class WireGUI extends JFrame {

    private final int cellDimension = 14;
    private final int width, height;
    private final JPanel menuPanel;
    private final JPanel cellPanel;
    private final Generation generation;
    private final JScrollPane scrollPane;
    private final JButton Start = new JButton();
    private final JButton Next;
    private final JButton Prev;
    private final JButton Clear;
    private final JButton Generate;
    private final JButton CellButton[][];
    private final JPanel cellGridPanel;
    private final WireGUI wireGui;
    private final int cellPanelSizeY = 3600;
    private final int cellPanelSizeX = 3600;
    // private final JButton Stop;
    //private final JButton Edytuj;

    public WireGUI(int height, int width) throws Exception {
        super("Wireworld!");
        new CellGrid(height, width);
        if ((height <= 0) && (width <= 0)) {
            throw new Exception("Niepoprawne wymiary planszy");
        }
        this.wireGui = this;
        this.width = width;
        this.height = height;
        menuPanel = new JPanel();
        cellPanel = new JPanel();
        generation = new Generation();
        Next = new JButton(">");
        Prev = new JButton("<");
        menuPanel.setPreferredSize(new Dimension(200, 800));
        cellPanel.setPreferredSize(new Dimension(800, 800));

        this.add(menuPanel, BorderLayout.WEST);

        menuPanel.setBackground(Color.WHITE);
        cellPanel.setBackground(Color.BLACK);
        cellGridPanel = new JPanel();
        cellPanel.add(cellGridPanel, BorderLayout.WEST);

        scrollPane = new JScrollPane(cellPanel);
        cellPanel.setPreferredSize(new Dimension(cellPanelSizeX, cellPanelSizeY));
        scrollPane.getViewport().setViewPosition(new java.awt.Point(1400, 0));
        this.getContentPane().add(scrollPane);
        Clear = new JButton("Wyczyść");
        Generate = new JButton("Start");
        Generate.setPreferredSize(new Dimension(150, 30));
        menuPanel.add(Clear);
        menuPanel.add(Generate);
        menuPanel.add(Prev);
        menuPanel.add(Next);
        MenuHandler handler = new MenuHandler();
        MouseHandler mousehandler = new MouseHandler();
        Clear.addActionListener(handler);
        Generate.addActionListener(handler);
        Next.addActionListener(handler);
        Prev.addActionListener(handler);

        /* Tworzenie planszy - tablica komorek w GUI */
        CellButton = new JButton[height + 2][width + 2];
        cellGridPanel.setLayout(new GridLayout(height + 2, width + 2));
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                CellButton[i][j] = new JButton("");
                CellButton[i][j].addMouseListener(mousehandler);
                cellGridPanel.add(CellButton[i][j]);
                CellButton[i][j].setPreferredSize(new Dimension(cellDimension, cellDimension));
                CellButton[i][j].setBackground(Color.BLACK);
            }

        }
        for (int i = 0; i < width + 2; i++) {

            CellButton[0][i].setVisible(false);
            CellButton[height + 1][i].setVisible(false);
        }
        for (int i = 0; i < height + 2; i++) {
            CellButton[i][0].setVisible(false);
            CellButton[i][width + 1].setVisible(false);

        }
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }

    public void updateCellGridPanel(CellGrid returnedGrid) {
        int v = 0;
        for (int i = 1; i < returnedGrid.getHeights() + 1; i++) {
            for (int j = 1; j < returnedGrid.getWidths() + 1; j++) {
                v = returnedGrid.getCell(i, j).getValue();

                switch (v) {
                    case (1):
                        CellButton[i][j].setBackground(Color.YELLOW);
                        break;
                    case (2):
                        CellButton[i][j].setBackground(Color.BLUE);
                        break;
                    case (3):
                        CellButton[i][j].setBackground(Color.RED);
                        break;
                    case (0):
                        CellButton[i][j].setBackground(Color.BLACK);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

            JButton source = (JButton) me.getSource();
            if (source.getBackground() == Color.BLACK) {
                source.setBackground(Color.YELLOW);
                CellGrid.cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 1);
            } else if (source.getBackground() == Color.YELLOW) {
                source.setBackground(Color.BLUE);
                CellGrid.cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 2);
            } else if (source.getBackground() == Color.BLUE) {
                source.setBackground(Color.RED);
                CellGrid.cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 3);
            } else {
                source.setBackground(Color.BLACK);
                CellGrid.cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 0);

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

        private boolean startstop = true;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Clear) {
                CellGrid.cellgrid.clear();
                for (int i = 0; i < CellButton.length; i++) {
                    for (int j = 0; j < CellButton[i].length; j++) {
                        CellButton[i][j].setBackground(Color.BLACK);
                    }
                }
            }
            if (e.getSource() == Next) {

                new CellGrid(height, width);
                generation.Fill(CellGrid.cellgrid);
                CellGrid.cellgrid.update(generation.generate(CellGrid.cellgrid));
                wireGui.updateCellGridPanel(CellGrid.cellgrid);
            }
            if (e.getSource() == Prev) {

                new CellGrid(height, width);
                generation.Fill(CellGrid.cellgrid);
                CellGrid.cellgrid.update(generation.generateprev(CellGrid.cellgrid));
                wireGui.updateCellGridPanel(CellGrid.cellgrid);
            }
            if (e.getSource() == Generate) {
              /* if (startstop) {
                    Generate.setText("Stop");
                    startstop = false;
                    Next.setVisible(false);
                    Prev.setVisible(false);
                } else {
                    Generate.setText("Start");
                    startstop = true;
                    Next.setVisible(true);
                    Prev.setVisible(true);
                }*/

                new CellGrid(height, width);
                generation.Fill(CellGrid.cellgrid);
                CellGrid.cellgrid.update(generation.generate(CellGrid.cellgrid));
                wireGui.updateCellGridPanel(CellGrid.cellgrid);

            }
        }
    }

}

