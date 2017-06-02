/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirefactory;

import GUI.WireGUI;
import javax.swing.JButton;
import static wirefactory.ClickWires.h;
import static wirefactory.ClickWires.w;
import wireworld.CellGrid;

/**
 * Klasa odpowiedzialna za rysowanie bramki logicznej exOR na planszy.
 * 
 */
public class exORgate implements ClickWires {
    /** Rysuje wskazany element, biorąc za punkt odniesienia współrzędne klikniętnego przycisku.  
     * 
     * @param source przysisk, którego współrzędne będą punktem odniesienia przy rysowaniu elementu.
     * @param orientation jeśli przekazana jest wartość true, element będzie rysowany poziomo, w przeciwnym wypadku pionowo.
     */
    @Override
    public void put(JButton source, boolean orientation) {
        int i, j;

        CellGrid cellgrid = (CellGrid) CellGrid.boards.get(CellGrid.count);
        int y = source.getY() / WireGUI.wireGUI.cellDimension;;
        int x = source.getX() / WireGUI.wireGUI.cellDimension;;

        if (orientation) {                                                      //poziomo
            for (i = 0; i < 4; i++) {                                          //wstawiam 10 przewodnikow 
                if (x + i > w) {                                                //przypadek wychodzenia poza wschodnia sciane grida
                    WireGUI.wireGUI.setColor(x + i - w, y, 1);
                    cellgrid.setCell(y, x + i - w, 1);
                } else {                                                        //przypadek bezkolizyjny
                    WireGUI.wireGUI.setColor(x + i, y, 1);
                    cellgrid.setCell(y, x + i, 1);
                }
            }

            for (i = 6; i < 10; i++) {                                               //no i zaczynamy zabawe
                j = 3;                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 0; i < 4; i++) {                                               //no i zaczynamy zabawe
                j = 6;                                         //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 3; i < 7; i++) {                                               //no i zaczynamy zabawe
                for (j = 2; j < 5; j++) {                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                    if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 4; i < 5; i++) {                                               //no i zaczynamy zabawe
                j = 5;                                     //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 4; i < 5; i++) {                                               //no i zaczynamy zabawe
                j = 1;                                         //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 4; i < 6; i++) {
                j = 3;
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + j, 0);
                    cellgrid.setCell(y + j, x + i - w, 0);
                } else if ((x + i > w) && (y + j > h)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + j - h, 0);
                    cellgrid.setCell(y + j - h, x + i - w, 0);
                } else if ((x + i > w) && (y + j < 1)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + j + h, 0);
                    cellgrid.setCell(y + j + h, x + i - w, 0);
                } else if ((y + j < 1)) {
                    WireGUI.wireGUI.setColor(x + i, y + j + h, 0);
                    cellgrid.setCell(y + j + h, x + i, 0);
                } else if ((y + j > h)) {
                    WireGUI.wireGUI.setColor(x + i, y + j - h, 0);
                    cellgrid.setCell(y + j - h, x + i, 0);
                } else if (x + i < 1) {
                    WireGUI.wireGUI.setColor(x + i + w, y + j, 0);
                    cellgrid.setCell(y + j, x + i + w, 0);
                } else if ((x + i < 1) && (y + j > h)) {
                    WireGUI.wireGUI.setColor(x + i + w, y + j - h, 0);
                    cellgrid.setCell(y + j - h, x + i + w, 0);
                } else if ((x + i < 1) && (y + j < 0)) {
                    WireGUI.wireGUI.setColor(x + i + w, y + j + h, 0);
                    cellgrid.setCell(y + j + h, x + i + w, 0);
                } else {
                    WireGUI.wireGUI.setColor(x + i, y + j, 0);
                    cellgrid.setCell(y + j, x + i, 0);
                }

            }

        } else {                                                                        //i znowu to samo, tylko pionowo :DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDddddff
            for (i = 0; i < 4; i++) {                                          //wstawiam 10 przewodnikow 
                if (y + i > h) {                                                //przypadek wychodzenia poza wschodnia sciane grida
                    WireGUI.wireGUI.setColor(x, y + i - h, 1);
                    cellgrid.setCell(y + i - h, x, 1);
                } else {                                                        //przypadek bezkolizyjny
                    WireGUI.wireGUI.setColor(x, y+i, 1);
                    cellgrid.setCell(y+i, x , 1);
                }
            }

            for (i = 3; i < 4; i++) {                                               //no i zaczynamy zabawe
                for(j=6;j<10;j++){                                         //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 6; i < 7; i++) {                                               //no i zaczynamy zabawe
                for(j=0;j<4;j++){                                     //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 2; i < 5; i++) {                                               //no i zaczynamy zabawe
                for (j = 3; j < 7; j++) {                                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                    if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 5; i < 6; i++) {                                               //no i zaczynamy zabawe
                for(j = 4; j < 5; j++)   {                           //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 1; i < 2; i++) {                                               //no i zaczynamy zabawe
                for(j = 4; j < 5; j++){                                  //dodanie sześciu przewodnikow, żeby zrobić diodę
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {                  //sprawdzanie wszystkich przypadkow (jest 9 razem, niektore chyba nie trzeba w tym przypadku sprawdzac)
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
            for (i = 3; i < 4; i++) {
                for(j = 4; j < 6; j++)
                if ((x + i > w) && (y + j < h + 1) && (y + j > 0)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + j, 0);
                    cellgrid.setCell(y + j, x + i - w, 0);
                } else if ((x + i > w) && (y + j > h)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + j - h, 0);
                    cellgrid.setCell(y + j - h, x + i - w, 0);
                } else if ((x + i > w) && (y + j < 1)) {
                    WireGUI.wireGUI.setColor(x + i - w, y + j + h, 0);
                    cellgrid.setCell(y + j + h, x + i - w, 0);
                } else if ((y + j < 1)) {
                    WireGUI.wireGUI.setColor(x + i, y + j + h, 0);
                    cellgrid.setCell(y + j + h, x + i, 0);
                } else if ((y + j > h)) {
                    WireGUI.wireGUI.setColor(x + i, y + j - h, 0);
                    cellgrid.setCell(y + j - h, x + i, 0);
                } else if (x + i < 1) {
                    WireGUI.wireGUI.setColor(x + i + w, y + j, 0);
                    cellgrid.setCell(y + j, x + i + w, 0);
                } else if ((x + i < 1) && (y + j > h)) {
                    WireGUI.wireGUI.setColor(x + i + w, y + j - h, 0);
                    cellgrid.setCell(y + j - h, x + i + w, 0);
                } else if ((x + i < 1) && (y + j < 0)) {
                    WireGUI.wireGUI.setColor(x + i + w, y + j + h, 0);
                    cellgrid.setCell(y + j + h, x + i + w, 0);
                } else {
                    WireGUI.wireGUI.setColor(x + i, y + j, 0);
                    cellgrid.setCell(y + j, x + i, 0);
                }

            }

        }

    }
}
