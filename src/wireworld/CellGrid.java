package wireworld;

import Cell.Head;
import Cell.Empty;
import Cell.Tail;
import Cell.Conductor;
import Cell.Cell;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wojboj
 */
public class CellGrid implements Serializable {

    /**
     * liczba, która wskazuje na numer generacji, która jest aktualnie
     * wyświetlana na ekranie.
     */
    public static int count = -1;

    /**
     * Lista zawierająca generacje plansz.
     */
    public static ArrayList boards = new ArrayList<CellGrid>();
    /**
     * wysokość planszy (w komórkach)
     */
    public int height;
    /**
     * szerokość planszy (w komórkach)
     */
    public int width;
    /**
     * Dwuwymiarowa tablica zawierająca wszystkie komórki z danej generacji.
     */
    public final Cell grid[][];

    /**
     * 
     * @param height wysokość planszy (w komórkach)
     * @param width szerokość planszy (w komórkach)
     */
    public CellGrid(int height, int width) {
        this.width = width;
        this.height = height;
        CellGrid.count++;
        boards.add(this);
        grid = new Cell[height + 2][width + 2];
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }


    /**
     * Zwraca komórkę o zadanych współrzędnych
     * @param y współrzędna Y
     * @param x współrzędna X
     * @return
     */
    public Cell getCell(int y, int x) {
        return grid[y][x];
    }

    /**
     * Zeruje listę generacji do zera i ustawia stan wszystkich komórek na 0 - puste.
     */
    public void clear() {

        CellGrid.boards.subList(1, CellGrid.boards.size()).clear();
        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(0);
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                cellgrid.grid[i][j].setValue(0);
            }
        }

    }

    /**
     * Ustawia stan komórki dla danych współrzędnych.
     * @param y współrzędna Y
     * @param x współrzędna X
     * @param v Stan komórki. 0 - pusta, 1 - przewodnik, 2 - ogon elektronu, 3- głowa elektronu.
     */
    public void setCell(int y, int x, int v) {
        Cell c;
        switch (v) {
            case 0: {
                c = new Empty(y, x);
                break;
            }
            case 1: {
                c = new Conductor(y, x);
                break;
            }
            case 2: {
                c = new Tail(y, x);
                break;
            }
            case 3: {
                c = new Head(y, x);
                break;
            }
            default: {
                c = new Cell(y, x);
                break;
            }
        }
        if (x > width) {

            throw new ArrayIndexOutOfBoundsException("x > width");
        }
        if (y > height) {
            throw new ArrayIndexOutOfBoundsException("y > height");
        }
        if (x < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (y < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        grid[y][x] = c;
    }

    /**
     * Zwraca wysokość planszy (w komórkach).
     * @return wysokość planszy (w komórkach).
     */
    public int getHeights() {
        return height;
    }
    /**
     * Zwraca szerokość planszy (w komórkach)
     * @return szerokość planszy (w komórkach)
     */
    public int getWidths() {
        return width;
    }

 

    /**
     * Uaktualnia planszę
     * @param basicgrid plansza, na podstawie której będzie tworzona nowa.
     */
    public void Update(CellGrid basicgrid) {
        for (int i = 1; i < height + 1; i++) {
            for (int j = 1; j < width + 1; j++) {
                grid[i][j] = basicgrid.getCell(i, j);
            }
        }
    }

    /**
     * Liczy sąsiadów komórki "Głowa elektronu"
     * @param y współrzędna Y
     * @param x współrzędna X
     * @return liczba sąsiadów głowy elektronu
     */
    public int countHeadNeighbours(int y, int x) {
        int counter = 0;
        if (getCell(y, x).getValue() == 3) {
            counter--;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getCell(y - 1 + i, x - 1 + j).getValue() == 3) {
                    counter++;
                }
            }
        }
        return counter;

    }

}
