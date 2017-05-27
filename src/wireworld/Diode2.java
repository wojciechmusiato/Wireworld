/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import javax.swing.JButton;
import static wireworld.ClickWires.cellDim;
import static wireworld.ClickWires.h;
import static wireworld.ClickWires.w;

/**
 *
 * @author wojboj
 */
public class Diode2 implements ClickWires {
    @Override
    public void put(JButton source, boolean orientation) {
        int i, j;

        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() / cellDim;
        int x = source.getX() / cellDim;

        if (orientation) {                                                      //poziomo
            for (i = 0; i < 10; i++) {                                          //wstawiam 10 przewodnikow 
                if (x + i > w) {                                                //przypadek wychodzenia poza wschodnia sciane grida
                    WireGUI.wireGUI.setColor(x + i - w, y, 1);
                    cellgrid.setCell(y, x + i - w, 1);
                } else {                                                        //przypadek bezkolizyjny
                    WireGUI.wireGUI.setColor(x + i, y, 1);
                    cellgrid.setCell(y, x + i, 1);
                }
            }
            for (i = 0; i < 2; i++) {                                               //no i zaczynamy zabawe
                for (j = 0; j < 3; j++) {                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                    if ((x + i + 4 > w)&&(y-1+j<h+1)&&(y-1+j>0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
                        WireGUI.wireGUI.setColor(x + i + 4 - w, y - 1 + j, 1);
                        cellgrid.setCell(y - 1 + j, x + i + 4 - w, 1);
                    } else if ((x + i +4 > w) && (y - 1 + j > h)) {
                        WireGUI.wireGUI.setColor(x + i + 4 - w, y - 1 + j - h, 1);
                        cellgrid.setCell(y - 1 + j - h, x + i + 4 - w, 1);
                    } else if ((x + i+4 > w) && (y - 1 + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i + 4 - w, y - 1 + j + h, 1);
                        cellgrid.setCell(y - 1 + j + h, x + i + 4 - w, 1);
                    } else if ((y - 1 + j < 1)) {
                        WireGUI.wireGUI.setColor(x + i + 4, y - 1 + j + h, 1);
                        cellgrid.setCell(y - 1 + j + h, x + i + 4, 1);
                    } else if ((y - 1 + j > h)) {
                        WireGUI.wireGUI.setColor(x + i + 4, y - 1 + j - h, 1);
                        cellgrid.setCell(y - 1 + j - h, x + i + 4, 1);
                    } else if (x + i + 4 < 1) {
                        WireGUI.wireGUI.setColor(x + i + 4 + w, y - 1 + j, 1);
                        cellgrid.setCell(y - 1 + j, x + i + 4 + w, 1);
                    } else if ((x + i + 4 < 1) && (y - 1 + j > h)) {
                        WireGUI.wireGUI.setColor(x + i + 4 + w, y - 1 + j - h, 1);
                        cellgrid.setCell(y - 1 + j - h, x + i + 4 + w, 1);
                    } else if ((x + i + 4 < 1) && (y - 1 + j < 0)) {
                        WireGUI.wireGUI.setColor(x + i + 4 + w, y - 1 + j + h, 1);
                        cellgrid.setCell(y - 1 + j + h, x + i + 4 + w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x + i + 4, y - 1 + j, 1);
                        cellgrid.setCell(y - 1 + j, x + i + 4, 1);
                    }
                }
            }
            if (x + 5 > w) {                                                            //tu tylko dodajemy pustą komorkę do diody
                WireGUI.wireGUI.setColor(x + 5 - w, y, 0);                              //tylko 2 przypadki tak jak na początku
                cellgrid.setCell(y, x + 5 - w, 0);
            } else {
                WireGUI.wireGUI.setColor(x + 5, y, 0);
                cellgrid.setCell(y, x + 5, 0);
            }
        } else {                                                                        //i znowu to samo, tylko pionowo :DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDddddff
            for (i = 0; i < 10; i++) {
                if (y + i > h) {
                    WireGUI.wireGUI.setColor(x, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x, 1);
                } else {
                    WireGUI.wireGUI.setColor(x, y + i, 1);
                    cellgrid.setCell(y + i, x, 1);
                }
            }
             for (i = 0; i < 2; i++) {
                for (j = 0; j < 3; j++) {
                    if ((y + i + 4 > h)&&(x-1+j<w+1)&&(x-1+j>0)) {
                        WireGUI.wireGUI.setColor(x - 1 + j, y + i + 4 - h, 1);
                        cellgrid.setCell(y + i + 4 - h, x - 1 + j, 1);
                    } else if ((y + i + 4 > h) && (x - 1 + j > w)) {
                        WireGUI.wireGUI.setColor(x - 1 + j-w, y + i + 4 - h, 1);
                        cellgrid.setCell(y + i + 4 - h, x - 1 + j-w, 1);
                    } else if ((y + i+4 > h) && (x - 1 + j < 1)) {
                        WireGUI.wireGUI.setColor(x - 1 + j+w, y + i + 4 - h, 1);
                        cellgrid.setCell(y + i + 4 - h, x - 1 + j+w, 1);
                    } else if ((x - 1 + j < 1)) {
                        WireGUI.wireGUI.setColor(x - 1 + j+w, y + i + 4, 1);
                        cellgrid.setCell(y + i + 4, x - 1 + j+w, 1);
                    } else if ((x - 1 + j > w)) {
                        WireGUI.wireGUI.setColor(x - 1 + j-w, y + i + 4, 1);
                        cellgrid.setCell(y + i + 4, x - 1 + j-w, 1);
                    } else if (y + i + 4 < 1) {
                        WireGUI.wireGUI.setColor(x - 1 + j, y + i + 4 + h, 1);
                        cellgrid.setCell(y + i + 4 + h, x - 1 + j, 1);
                    } else if ((y + i + 4 < 1) && (x - 1 + j > w)) {
                        WireGUI.wireGUI.setColor(x - 1 + j-w, y + i + 4 + h, 1);
                        cellgrid.setCell(y + i + 4 + h, x - 1 + j-w, 1);
                    } else if ((y + i + 4 < 1) && (x - 1 + j < 0)) {
                        WireGUI.wireGUI.setColor(x - 1 + j+w, y + i + 4 + h, 1);
                        cellgrid.setCell(y + i + 4 + h, x - 1 + j+w, 1);
                    } else {
                        WireGUI.wireGUI.setColor(x - 1 + j, y + i + 4, 1);
                        cellgrid.setCell(y + i + 4, x - 1 + j, 1);
                    }
                }
            }
            if (y + 5 > h) {
                WireGUI.wireGUI.setColor(x, y + 5 - h, 0);
                cellgrid.setCell(y + 5 - h, x, 0);
            } else {
                WireGUI.wireGUI.setColor(x, y + 5, 0);
                cellgrid.setCell(y + 5, x, 0);
            }
        }
    }
}