package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import wireworld.CellGrid;
import wireworld.Generation;
import wireworld.GridSaveRead;
import wirefactory.WireFactory;

/**
 *
 * @author wojboj
 */
public class WireGUI extends JFrame {

    public static WireGUI wireGUI;
    int ile;
    public int cellDimension = 14;
    public final int width, height;
    private final JPanel menuPanel;
    private final JPanel cellPanel;
    private final Generation generation;
    private final JScrollPane scrollPane;
    private final JButton Start = new JButton();
    private final JButton Next;
    private final JButton Prev;
    private final JButton Clear;
    private final JButton Generate;
    public final JButton CellButton[][];
    private final JPanel cellGridPanel;
    private final int cellPanelSizeY = 3600;
    private final int cellPanelSizeX = 3600;
    private final JTextField numOfGen;
    private final JLabel genNumber;
    private final JButton nextGen;
    private final JButton Stop;
    private final JRadioButton Diode1;
    private final JRadioButton Eraser;
    private final JRadioButton Diode2;
    private final JRadioButton singleCell;
    private final JRadioButton diagonalWire;
    private final JRadioButton horizontalWire;
    private final JRadioButton exORgate;
    private final JCheckBox Orientation;
    private final JRadioButton ORgate;
    public final JButton Save;

    public WireGUI(int height, int width) throws Exception {
        super("Wireworld!");

        WireGUI.wireGUI = this;
        this.width = width;
        this.height = height;
        if (width > 100 || height > 100) {
            cellDimension = 10;
        }
        if (width > 150 || height > 150) {
            cellDimension = 9;
        }
        menuPanel = new JPanel();
        cellPanel = new JPanel();
        cellGridPanel = new JPanel();
        generation = new Generation();
        nextGen = new JButton("Następna Generacja");
        Next = new JButton(">");
        Prev = new JButton("<");
        Stop = new JButton("   Stop    ");
        Clear = new JButton("Wyczyść planszę");
        Generate = new JButton("Start");
        genNumber = new JLabel("Generacja nr 0");
        numOfGen = new JTextField("30");
        Diode1 = new JRadioButton("Dioda1");
        Diode2 = new JRadioButton("Dioda2");
        horizontalWire = new JRadioButton("Kabel1");
        diagonalWire = new JRadioButton("Kabel2");
        singleCell = new JRadioButton("Komórka");
        Eraser = new JRadioButton("Gumka");
        Save = new JButton("Zapisz Generację");
        ORgate = new JRadioButton("OR gate");
        Orientation = new JCheckBox("Wstaw Pionowo");
        exORgate = new JRadioButton("exOR gate");
        menuPanel.setPreferredSize(new Dimension(200, 800));
        cellPanel.setPreferredSize(new Dimension(800, 800));

        this.add(menuPanel, BorderLayout.WEST);

        menuPanel.setBackground(Color.WHITE);
        cellPanel.setBackground(Color.BLACK);

        cellPanel.add(cellGridPanel, BorderLayout.WEST);

        scrollPane = new JScrollPane(cellPanel);
        cellPanel.setPreferredSize(new Dimension(cellPanelSizeX, cellPanelSizeY));
        scrollPane.getViewport().setViewPosition(new java.awt.Point(1400, 0));
        this.getContentPane().add(scrollPane);

        menuPanel.add(Clear);
        Clear.setPreferredSize(new Dimension(200, 30));
        menuPanel.add(Stop);
        Stop.setEnabled(false);
        menuPanel.add(Generate);
        menuPanel.add(numOfGen);
        menuPanel.add(Prev);
        menuPanel.add(Next);
        menuPanel.add(genNumber);
        menuPanel.add(nextGen);
        nextGen.setPreferredSize(new Dimension(200, 30));
        menuPanel.add(horizontalWire);
        menuPanel.add(Diode1);
        menuPanel.add(Diode2);
        menuPanel.add(diagonalWire);
        menuPanel.add(singleCell);
        menuPanel.add(Eraser);
        menuPanel.add(ORgate);
        menuPanel.add(exORgate);
        menuPanel.add(Orientation);
        menuPanel.add(Save, BorderLayout.SOUTH);

        Save.setPreferredSize(new Dimension(200, 30));
        ButtonGroup group = new ButtonGroup();
        group.add(Diode1);
        group.add(horizontalWire);
        group.add(Diode2);
        group.add(diagonalWire);
        group.add(singleCell);
        group.add(Eraser);
        group.add(ORgate);
        group.add(exORgate);
        MenuHandler handler = new MenuHandler();
        MouseHandler mousehandler = new MouseHandler();
        Clear.addActionListener(handler);
        Generate.addActionListener(handler);
        Next.addActionListener(handler);
        Prev.addActionListener(handler);
        nextGen.addActionListener(handler);
        Stop.addActionListener(handler);
        Orientation.addActionListener(handler);
        Save.addActionListener(handler);

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

    public void setColor(int x, int y, int v) {
        switch (v) {
            case 0:
                CellButton[y][x].setBackground(Color.black);
                break;
            case 1:
                CellButton[y][x].setBackground(Color.yellow);
                break;
            case 2:
                CellButton[y][x].setBackground(Color.blue);
                break;
            case 3:
                CellButton[y][x].setBackground(Color.red);
                break;
        }
    }

    private class MouseHandler implements MouseListener {

        WireFactory wireFactory = new WireFactory();
        public boolean orientation = true;

        @Override
        public void mouseClicked(MouseEvent me) {
            JButton source = (JButton) me.getSource();

            int y = source.getY() / cellDimension;
            int x = source.getX() / cellDimension;
            CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);

            if (Orientation.isSelected()) {
                orientation = false;
            } else {
                orientation = true;
            }

            if (Diode1.isSelected()) {
                wireFactory.getWire("Diode1", source, orientation);
            } else if (Diode2.isSelected()) {
                wireFactory.getWire("Diode2", source, orientation);
            } else if (horizontalWire.isSelected()) {
                wireFactory.getWire("horizontalWire", source, orientation);
            } else if (diagonalWire.isSelected()) {
                wireFactory.getWire("diagonalWire", source, orientation);
            } else if (ORgate.isSelected()) {
                wireFactory.getWire("ORgate", source, orientation);
            } else if (exORgate.isSelected()) {
                wireFactory.getWire("exORgate", source, orientation);
            } else {
                wireFactory.getWire("SingleCell", source, orientation);
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
            if (Eraser.isSelected()) {
                CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
                JButton source = (JButton) me.getSource();
                source.setBackground(Color.BLACK);
                cellgrid.setCell(source.getY() / cellDimension, source.getX() / cellDimension, 0);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }

    private class MenuHandler implements ActionListener {

        private Worker worker;
        private boolean startstop = true;

        @Override
        public void actionPerformed(ActionEvent e) {

            CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
            if (e.getSource() == Clear) {
                cellgrid.clear();
                CellGrid.count = 0;
                wireGUI.updateCellGridPanel();
            }
            if (e.getSource() == Prev) {
                if (CellGrid.count > 0) {
                    CellGrid.count--;
                    wireGUI.updateCellGridPanel();
                }
                System.out.println(CellGrid.count);
            }

            if (e.getSource() == Next) {

                if (CellGrid.count < CellGrid.boards.size() - 1) {
                    CellGrid.count++;
                }
                wireGUI.updateCellGridPanel();
            }

            if (e.getSource() == nextGen) {
                new CellGrid(height, width);
                generation.Fill();
                generation.Generate();
                wireGUI.updateCellGridPanel();
            }
            if (e.getSource() == Stop) {
                worker.cancel(true);
                Stop.setEnabled(false);
                Generate.setEnabled(true);
                Next.setVisible(true);
                Prev.setVisible(true);
                Clear.setEnabled(true);
                nextGen.setEnabled(true);

            }
            if (e.getSource() == Generate) {
                worker = new Worker();
                try {
                    ile = Integer.parseInt(numOfGen.getText());
                } catch (Exception ex) {
                    WireStartGUI.startGUI.Popup("Błąd, wpisz dodatnią liczbę ");
                }
                if (ile < 1) {
                    WireStartGUI.startGUI.Popup("Błąd, wpisz dodatnią liczbę");
                } else {
                    Stop.setEnabled(true);
                    Generate.setEnabled(false);
                    Clear.setEnabled(false);
                    nextGen.setEnabled(false);
                    startstop = false;
                    Next.setVisible(false);
                    Prev.setVisible(false);
                    worker.execute();
                }
            }
            if (e.getSource()
                    == Save) {
                GridSaveRead save = new GridSaveRead();
                try {
                    save.Save();
                } catch (IOException ex) {
                    Logger.getLogger(WireGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            genNumber.setText(
                    "Generacja nr " + CellGrid.count);
        }
    }

    class Worker extends SwingWorker<Void, Void> {

        int counter = 0;

        @Override
        protected Void doInBackground() throws Exception {
            while (ile-- > 0) {
                new CellGrid(height, width);
                generation.Fill();
                generation.Generate();
                wireGUI.updateCellGridPanel();
                genNumber.setText("Generacja nr " + CellGrid.count);
                Thread.sleep(600);
            }
            return null;
        }
    }
}
