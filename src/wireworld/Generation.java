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

    private CellGrid extendedgrid;
    private CellGrid toreturngrid;

    public Generation(CellGrid basicgrid) {
        this.extendedgrid = new CellGrid(basicgrid.getHeights() + 2, basicgrid.getWidths() + 2);
        this.toreturngrid = new CellGrid(basicgrid.getHeights(), basicgrid.getWidths());

        System.out.println("Extended Height = " + extendedgrid.getHeights() + " Extended Width = " + extendedgrid.getWidths());

        System.out.println("Basic Height = " + toreturngrid.getHeights() + " Basic Width = " + toreturngrid.getWidths());

    }

    public void copy(CellGrid basicgrid) {

        for (int i = 1; i < extendedgrid.getHeights() - 1; i++) {
            for (int j = 1; j < extendedgrid.getWidths() - 1; j++) {
                extendedgrid.setCell(i, j, basicgrid.getCell(i - 1, j - 1).getValue());
            }
        }
            /*                                                                  tutaj jest kopiowanie powłoki do planszy rozszerzonej , jest tu bład
        for (int k = 1; k< extendedgrid.getHeights() - 1; k++) {
            extendedgrid.setCell(k, 0, basicgrid.getCell(k, basicgrid.getWidths() - 2).getValue());
            extendedgrid.setCell(k, extendedgrid.getWidths() - 2, basicgrid.getCell(k, 0).getValue());
            extendedgrid.setCell(0, k, basicgrid.getCell(basicgrid.getHeights() - 1, k).getValue());
            extendedgrid.setCell(extendedgrid.getHeights() - 1, k, basicgrid.getCell(k, 0).getValue());
        }

        extendedgrid.setCell(0, 0, basicgrid.getCell(basicgrid.getHeights() - 1, 0).getValue());
        extendedgrid.setCell(0, extendedgrid.getWidths() - 1, basicgrid.getCell(basicgrid.getHeights() - 1, basicgrid.getWidths() - 1).getValue());
        extendedgrid.setCell(extendedgrid.getHeights() - 1, 0, basicgrid.getCell(0, 0).getValue());
        extendedgrid.setCell(extendedgrid.getHeights() - 1, extendedgrid.getWidths() - 1, basicgrid.getCell(0, basicgrid.getWidths() - 1).getValue());
     */
    }

    public CellGrid generate(CellGrid basicgrid) {
        extendedgrid.clear();
        copy(basicgrid);
        toreturngrid.clear();
        for (int i = 1; i < extendedgrid.getHeights() - 1; i++) {
            for (int j = 1; j < extendedgrid.getWidths() - 1; j++) {
                if (extendedgrid.getCell(i, j).getValue() == 0) {
                    toreturngrid.setCell(i - 1, j - 1, 0);                          // 3 TO HEAD (RED);  2 TO TAIL (BLUE) ;  1 TO CONDUCTOR (YELLOW)
                } else if (extendedgrid.getCell(i, j).getValue() == 3) {
                    toreturngrid.setCell(i - 1, j - 1, 2);
                } else if (extendedgrid.getCell(i, j).getValue() == 2) {
                    toreturngrid.setCell(i - 1, j - 1, 1);
                } else if ((extendedgrid.countHeadNeighbours(i, j) == 2) || (extendedgrid.countHeadNeighbours(i, j) == 1)) {
                    toreturngrid.setCell(i - 1, j - 1, 3);
                } else {
                    toreturngrid.setCell(i - 1, j - 1, 1);
                }

            }
        }

        return toreturngrid;
    }
}
