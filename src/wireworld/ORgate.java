/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import javax.swing.JButton;

/**
 *
 * @author wojboj
 */
class ORgate implements ClickWires {

    @Override
    public void put(JButton source, boolean orientation) {
        int i, j;

        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() /     WireGUI.wireGUI.cellDimension;;
        int x = source.getX() /     WireGUI.wireGUI.cellDimension;;

        if (orientation) {                                                      //poziomo
            for (i = 0; i < 7; i++) {                                          //wstawiam 10 przewodnikow 
                if (x + i > w) {                                                //przypadek wychodzenia poza wschodnia sciane grida
                    WireGUI.wireGUI.setColor(x + i - w, y, 1);
                    cellgrid.setCell(y, x + i - w, 1);
                } else {                                                        //przypadek bezkolizyjny
                    WireGUI.wireGUI.setColor(x + i, y, 1);
                    cellgrid.setCell(y, x + i, 1);
                }
            }
            for (i = 0; i < 7; i++) {                                               //no i zaczynamy zabawe
                for (j = 4; j < 5; j++) {                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                    if ((x + i > w) && (y  + j < h + 1 ) && (y  + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
                        WireGUI.wireGUI.setColor(x + i - w, y + j, 1);
                        cellgrid.setCell(y + j, x + i - w, 1);
                    } else if ((x + i > w) && (y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i - w, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i - w, 1);
                    } else if ((x + i > w) && (y + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i - w, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i - w, 1);
                    } else if ((y + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i, 1);
                    } else if ((y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i, 1);
                    } else if (x + i < 1) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j, 1);
                        cellgrid.setCell(y + j, x + i + w, 1);
                    } else if ((x + i < 1) && (y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i + w, 1);
                    } else if ((x + i < 1) && (y + j < 0)) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i + w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x + i, y + j, 1);
                        cellgrid.setCell(y + j, x + i, 1);
                    }
                }
            }
            for (i = 6; i < 13; i++) {                                               //no i zaczynamy zabawe
                for (j = 2; j < 3; j++) {                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                    if ((x + i > w) && (y  + j < h +1  ) && (y  + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
                        WireGUI.wireGUI.setColor(x + i - w, y + j, 1);
                        cellgrid.setCell(y + j, x + i - w, 1);
                    } else if ((x + i > w) && (y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i - w, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i - w, 1);
                    } else if ((x + i > w) && (y + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i - w, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i - w, 1);
                    } else if ((y + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i, 1);
                    } else if ((y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i, 1);
                    } else if (x + i < 1) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j, 1);
                        cellgrid.setCell(y + j, x + i + w, 1);
                    } else if ((x + i < 1) && (y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i + w, 1);
                    } else if ((x + i < 1) && (y + j < 0)) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i + w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x + i, y + j, 1);
                        cellgrid.setCell(y + j, x + i, 1);
                    }
                }
            }
            for (i = 7; i < 8; i++) {                                               //no i zaczynamy zabawe
                for (j = 1; j < 4; j++) {                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                    if ((x + i > w) && (y  + j < h +1) && (y  + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
                        WireGUI.wireGUI.setColor(x + i - w, y + j, 1);
                        cellgrid.setCell(y + j, x + i - w, 1);
                    } else if ((x + i > w) && (y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i - w, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i - w, 1);
                    } else if ((x + i > w) && (y + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i - w, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i - w, 1);
                    } else if ((y + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i, 1);
                    } else if ((y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i, 1);
                    } else if (x + i < 1) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j, 1);
                        cellgrid.setCell(y + j, x + i + w, 1);
                    } else if ((x + i < 1) && (y + j > h)) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j - h, 1);
                        cellgrid.setCell(y + j - h, x + i + w, 1);
                    } else if ((x + i < 1) && (y + j < 0)) {
                        WireGUI.wireGUI.setColor(x + i + w, y + j + h, 1);
                        cellgrid.setCell(y + j + h, x + i + w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x + i, y + j, 1);
                        cellgrid.setCell(y + j, x + i, 1);
                    }
                }
            }
           
        } else {                                                                        //i znowu to samo, tylko pionowo :DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDddddff
             for (i = 0; i < 7; i++) {
                if (y + i > h) {
                    WireGUI.wireGUI.setColor(x, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x, 1);
                } else {
                    WireGUI.wireGUI.setColor(x, y + i, 1);
                    cellgrid.setCell(y + i, x, 1);
                }
            }
             for (i = 6; i < 13; i++) {
                for (j = 2; j < 3; j++) {
                    if ((y + i  > h)&&(x+j<w+1)&&(x+j>0)) {
                        WireGUI.wireGUI.setColor(x  + j, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j, 1);
                    } else if ((y + i  > h) && (x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j-w, 1);
                    } else if ((y + i > h) && (x  + j < 1)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j+w, 1);
                    } else if ((x  + j < 1)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i , 1);
                        cellgrid.setCell(y + i , x  + j+w, 1);
                    } else if ((x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i , 1);
                        cellgrid.setCell(y + i , x  + j-w, 1);
                    } else if (y + i  < 1) {
                        WireGUI.wireGUI.setColor(x  + j, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j, 1);
                    } else if ((y + i  < 1) && (x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j-w, 1);
                    } else if ((y + i  < 1) && (x  + j < 0)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j+w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x  + j, y + i , 1);
                        cellgrid.setCell(y + i , x  + j, 1);
                    }
                }
            }
              for (i = 0; i < 7; i++) {
                for (j = 4; j < 5; j++) {
                    if ((y + i  > h)&&(x+j<w+1)&&(x+j>0)) {
                        WireGUI.wireGUI.setColor(x  + j, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j, 1);
                    } else if ((y + i  > h) && (x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j-w, 1);
                    } else if ((y + i > h) && (x  + j < 1)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j+w, 1);
                    } else if ((x  + j < 1)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i , 1);
                        cellgrid.setCell(y + i , x  + j+w, 1);
                    } else if ((x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i , 1);
                        cellgrid.setCell(y + i , x  + j-w, 1);
                    } else if (y + i  < 1) {
                        WireGUI.wireGUI.setColor(x  + j, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j, 1);
                    } else if ((y + i  < 1) && (x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j-w, 1);
                    } else if ((y + i  < 1) && (x  + j < 0)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j+w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x  + j, y + i , 1);
                        cellgrid.setCell(y + i , x  + j, 1);
                    }
                }
            }
             for (i = 7; i < 8; i++) {
                for (j = 1; j < 4; j++) {
                    if ((y + i  > h)&&(x+j<w+1)&&(x+j>0)) {
                        WireGUI.wireGUI.setColor(x  + j, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j, 1);
                    } else if ((y + i  > h) && (x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j-w, 1);
                    } else if ((y + i > h) && (x  + j < 1)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i  - h, 1);
                        cellgrid.setCell(y + i  - h, x  + j+w, 1);
                    } else if ((x  + j < 1)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i , 1);
                        cellgrid.setCell(y + i , x  + j+w, 1);
                    } else if ((x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i , 1);
                        cellgrid.setCell(y + i , x  + j-w, 1);
                    } else if (y + i  < 1) {
                        WireGUI.wireGUI.setColor(x  + j, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j, 1);
                    } else if ((y + i  < 1) && (x  + j > w)) {
                        WireGUI.wireGUI.setColor(x  + j-w, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j-w, 1);
                    } else if ((y + i  < 1) && (x  + j < 0)) {
                        WireGUI.wireGUI.setColor(x  + j+w, y + i  + h, 1);
                        cellgrid.setCell(y + i  + h, x  + j+w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x  + j, y + i , 1);
                        cellgrid.setCell(y + i , x  + j, 1);
                    }
                }
            }
           
            
        }
    }
}
