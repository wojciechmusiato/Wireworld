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


    public void Fill() {
        CellGrid basicgrid =  (CellGrid) CellGrid.boards.get(CellGrid.count-1);
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

    public CellGrid Generate() {
        CellGrid nextGrid =  (CellGrid) CellGrid.boards.get(CellGrid.count);
        CellGrid basicgrid =  (CellGrid) CellGrid.boards.get(CellGrid.count-1);
        for (int i = 1; i < basicgrid.getHeights() + 1; i++) {
            for (int j = 1; j < basicgrid.getWidths() + 1; j++) {
                if (basicgrid.getCell(i, j).getValue() == 0) {
                    nextGrid.setCell(i, j, 0);                          // 3 TO HEAD (RED);  2 TO TAIL (BLUE) ;  1 TO CONDUCTOR (YELLOW)
                } else if (basicgrid.getCell(i, j).getValue() == 3) {
                    nextGrid.setCell(i, j, 2);
                } else if (basicgrid.getCell(i, j).getValue() == 2) {
                    nextGrid.setCell(i, j, 1);
                } else if ((basicgrid.countHeadNeighbours(i, j) == 2) || (basicgrid.countHeadNeighbours(i, j) == 1)) {
                    nextGrid.setCell(i, j, 3);
                } else {
                    nextGrid.setCell(i, j, 1);
                }

            }
        }

        return nextGrid;
    }

}
