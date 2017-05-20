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

    }

    public void copy(CellGrid basicgrid) {
        for (int i = 1; i < extendedgrid.getHeights() - 1; i++) {
            for (int j = 1; j < extendedgrid.getWidths() - 1; j++) {
                extendedgrid.setCell(i,j,basicgrid.getCell(i - 1, j - 1).getValue());
            }
        }
        //Jeszcze boki trzeba dorobić
        extendedgrid.setCell(0, 0, basicgrid.getCell(basicgrid.getHeights()-1, 0).getValue());
        extendedgrid.setCell(0, extendedgrid.getWidths()-1, basicgrid.getCell(basicgrid.getHeights()-1, basicgrid.getWidths()-1).getValue());
        extendedgrid.setCell(extendedgrid.getHeights()-1, 0, basicgrid.getCell(0, 0).getValue());
        extendedgrid.setCell(extendedgrid.getHeights()-1, extendedgrid.getWidths()-1, basicgrid.getCell(0, basicgrid.getWidths()-1).getValue());
    }

    public void cut() {
        for (int i = 0; i < this.toreturngrid.getHeights(); i++) {
            for (int j = 0; j < this.toreturngrid.getWidths(); j++) {
                this.toreturngrid.getCell(i, j).setValue(extendedgrid.getCell(i + 1, j + 1).getValue());
            }
        }
    }

    public CellGrid generate(CellGrid basicgrid) {
        copy(basicgrid);
        toreturngrid.clear();
        for (int i = 1; i < extendedgrid.getHeights() - 1; i++) {
            for (int j = 1; j < extendedgrid.getWidths() - 1; i++) {
                if (extendedgrid.getCell(i, j).getValue() == 0) {

                } else if (extendedgrid.getCell(i, j).getValue() == 3) {
                    toreturngrid.setCell(i, j, 2);
                } else if (extendedgrid.getCell(i, j).getValue() == 2) {
                    toreturngrid.setCell(i, j, 1);
                } else if ((extendedgrid.countHeadNeighbours(i, j) == 2) && (extendedgrid.countHeadNeighbours(i, j) == 1)) {
                    toreturngrid.setCell(i, j, 3);
                } else {
                    toreturngrid.setCell(i, j, 1);
                }

            }
        }
        cut();

        return toreturngrid;
    }
}


