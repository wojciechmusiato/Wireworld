/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

/**
 *
 * @author mihasz
 */
public class Generation {

    public Generation() {

    }

    public void copy(CellGrid basicgrid) {

        for (int i = 1; i < basicgrid.getHeights() +1; i++) {
            for (int j = 1; j < basicgrid.getWidths() + 1; j++) {
                basicgrid.setCell(i, j, basicgrid.getCell(i , j).getValue());
            }
        }
    }

    /*                                                              tutaj jest kopiowanie powłoki do planszy rozszerzonej , jest tu bład
        for (int k = 1; k< basicgrid.grid[.getHeights() - 1; k++) {
            basicgrid.grid[.setCell(k, 0, basicgrid.grid[.getCell(k, basicgrid.grid[.getWidths() - 2).getValue());
            basicgrid.grid[.setCell(k, basicgrid.grid[.getWidths() - 2, basicgrid.grid[.getCell(k, 0).getValue());
            basicgrid.grid[.setCell(0, k, basicgrid.grid[.getCell(basicgrid.grid[.getHeights() - 1, k).getValue());
            basicgrid.grid[.setCell(basicgrid.grid[.getHeights() - 1, k, basicgrid.grid[.getCell(k, 0).getValue());
        }

        basicgrid.grid[.setCell(0, 0, basicgrid.grid[.getCell(basicgrid.grid[.getHeights() - 1, 0).getValue());
        basicgrid.grid[.setCell(0, basicgrid.grid[.getWidths() - 1, basicgrid.grid[.getCell(basicgrid.grid[.getHeights() - 1, basicgrid.grid[.getWidths() - 1).getValue());
        basicgrid.grid[.setCell(basicgrid.grid[.getHeights() - 1, 0, basicgrid.grid[.getCell(0, 0).getValue());
        basicgrid.grid[.setCell(basicgrid.grid[.getHeights() - 1, basicgrid.grid[.getWidths() - 1, basicgrid.grid[.getCell(0, basicgrid.grid[.getWidths() - 1).getValue());
     */
    public void Fill(CellGrid basicgrid) {
        int h = basicgrid.getHeights();
        int w = basicgrid.getWidths();
        basicgrid.grid[0][0] = basicgrid.grid[h][1];
        basicgrid.grid[0][w + 1] = basicgrid.grid[h][w];
        basicgrid.grid[h + 1][0] = basicgrid.grid[1][1];
        basicgrid.grid[h + 1][w + 1] = basicgrid.grid[1][w];

        for (int i = 1; i <= w; i++) {
            basicgrid.grid[0][i] = basicgrid.grid[h][i];
            basicgrid.grid[h + 1][i] = basicgrid.grid[1][i];
        }
        for (int i = 1; i <= h; i++) {
            basicgrid.grid[i][0] = basicgrid.grid[i][w];
            basicgrid.grid[i][w + 1] = basicgrid.grid[i][1];
        }
    }

    public CellGrid generate(CellGrid basicgrid) {

        CellGrid.tmpgrid.clear();
        for (int i = 1; i < basicgrid.getHeights() + 1; i++) {
            for (int j = 1; j < basicgrid.getWidths() + 1; j++) {
                if (basicgrid.getCell(i, j).getValue() == 0) {
                    CellGrid.tmpgrid.setCell(i, j, 0);                          // 3 TO HEAD (RED);  2 TO TAIL (BLUE) ;  1 TO CONDUCTOR (YELLOW)
                } else if (basicgrid.getCell(i, j).getValue() == 3) {
                    CellGrid.tmpgrid.setCell(i, j, 2);
                } else if (basicgrid.getCell(i, j).getValue() == 2) {
                    CellGrid.tmpgrid.setCell(i, j, 1);
                } else if ((basicgrid.countHeadNeighbours(i, j) == 2) || (basicgrid.countHeadNeighbours(i, j) == 1)) {
                    CellGrid.tmpgrid.setCell(i, j, 3);
                } else {
                    CellGrid.tmpgrid.setCell(i, j, 1);
                }

            }
        }

        return CellGrid.tmpgrid;
    }
    public CellGrid generateprev(CellGrid basicgrid) {

        CellGrid.tmpgrid.clear();
        for (int i = 1; i < basicgrid.getHeights() + 1; i++) {
            for (int j = 1; j < basicgrid.getWidths() + 1; j++) {
                if (basicgrid.getCell(i, j).getValue() == 0) {
                    CellGrid.tmpgrid.setCell(i, j, 0);                          // 3 TO HEAD (RED);  2 TO TAIL (BLUE) ;  1 TO CONDUCTOR (YELLOW)
                } else if (basicgrid.getCell(i, j).getValue() == 3) {
                    CellGrid.tmpgrid.setCell(i, j, 1);
                } else if (basicgrid.getCell(i, j).getValue() == 2) {
                    CellGrid.tmpgrid.setCell(i, j, 3);
                } else if ((basicgrid.countTailNeighbours(i, j) == 2) || (basicgrid.countTailNeighbours(i, j) == 1) || (basicgrid.countTailNeighbours(i, j) == 3)){
                    CellGrid.tmpgrid.setCell(i, j, 2);
                } else {
                    CellGrid.tmpgrid.setCell(i, j, 1);
                }

            }
        }

        return CellGrid.tmpgrid;
    }
}
