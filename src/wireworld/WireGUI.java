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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author wojboj
 */
public class WireGUI extends JFrame {

    int ile;
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
    private final JTextField numOfGen;
    private JLabel genNumber;
    private final JButton nextGen;
    //private final JButton Edytuj;

    public WireGUI(int height, int width) throws Exception {
        super("Wireworld!");

        if ((height <= 0) && (width <= 0)) {
            throw new Exception("Niepoprawne wymiary planszy");
        }
        this.wireGui = this;
        this.width = width;
        this.height = height;
        menuPanel = new JPanel();
        cellPanel = new JPanel();
        generation = new Generation();
        nextGen = new JButton("Następna");
        Next = new JButton(">");
        Prev = new JButton("<");
        menuPanel.setPreferredSize(new Dimension(200, 800));
        cellPanel.setPreferredSize(new Dimension(800, 800));

        this.add(menuPanel, BorderLayout.WEST);

        menuPanel.setBackground(Color.WHITE);
        cellPanel.setBackground(Color.BLACK);
        cellGridPanel = new JPanel();
        cellPanel.add(cellGridPanel, BorderLayout.WEST);
        genNumber = new JLabel("Generacja nr 0");
        numOfGen = new JTextField("30");
        scrollPane = new JScrollPane(cellPanel);
        cellPanel.setPreferredSize(new Dimension(cellPanelSizeX, cellPanelSizeY));
        scrollPane.getViewport().setViewPosition(new java.awt.Point(1400, 0));
        this.getContentPane().add(scrollPane);
        Clear = new JButton("Wyczyść");
        Generate = new JButton("Start");
        Generate.setPreferredSize(new Dimension(150, 30));
        
        menuPanel.add(Clear);
        menuPanel.add(Generate);
        menuPanel.add(numOfGen);
        menuPanel.add(Prev);
        menuPanel.add(Next);
        menuPanel.add(genNumber);
        menuPanel.add(nextGen);
        MenuHandler handler = new MenuHandler();
        MouseHandler mousehandler = new MouseHandler();
        Clear.addActionListener(handler);
        Generate.addActionListener(handler);
        Next.addActionListener(handler);
        Prev.addActionListener(handler);
        nextGen.addActionListener(handler);
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

    public void updateCellGridPanel() {
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int v = 0;
        for (int i = 1; i < cellgrid.getHeights() + 1; i++) {
            for (int j = 1; j < cellgrid.getWidths() + 1; j++) {
                v = cellgrid.getCell(i, j).getValue();

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
            CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
            JButton source = (JButton) me.getSource();
            if (source.getBackground() == Color.BLACK) {
                source.setBackground(Color.YELLOW);
                cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 1);
            } else if (source.getBackground() == Color.YELLOW) {
                source.setBackground(Color.BLUE);
                cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 2);
            } else if (source.getBackground() == Color.BLUE) {
                source.setBackground(Color.RED);
                cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 3);
            } else {
                source.setBackground(Color.BLACK);
                cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 0);

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
            CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
            if (e.getSource() == Clear) {
                cellgrid.clear();
                CellGrid.count = 0;
                wireGui.updateCellGridPanel();
            }
            if (e.getSource() == Prev) {
                if (CellGrid.count > 0) {
                    CellGrid.count--;
                    wireGui.updateCellGridPanel();
                }
                System.out.println(CellGrid.count);
            }
            
            if (e.getSource() == Next) {
                if (CellGrid.count < CellGrid.boards.size() - 1) {
                    CellGrid.count++;
                }
                wireGui.updateCellGridPanel();
            }
            
            if (e.getSource() == nextGen) {
                new CellGrid(height, width);
                generation.Fill();
                generation.Generate();
                wireGui.updateCellGridPanel();
            }
            
            if (e.getSource() == Generate) {
                ile = Integer.parseInt(numOfGen.getText());
                if (startstop) {
                    Generate.setText("Stop");
                    startstop = false;
                    Next.setVisible(false);
                    Prev.setVisible(false);

                    SwingWorker<Integer, Void> worker
                            = new SwingWorker<Integer, Void>() {

                        @Override
                        public Integer doInBackground() throws InterruptedException {
                            if (!startstop) {
                                while (ile-- > 0) {
                                    new CellGrid(height, width);
                                    generation.Fill();
                                    generation.Generate();
                                    wireGui.updateCellGridPanel();
                                    Thread.sleep(300);

                                }
                            }
                            return 1;
                        }

                    };
                    worker.execute();

                } else {
                    Generate.setText("Start");
                    startstop = true;
                    Next.setVisible(true);
                    Prev.setVisible(true);
                }
            }

            
            genNumber.setText("Generacja nr " + CellGrid.count);
        }
    }
}
