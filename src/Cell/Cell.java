
package Cell;

import java.io.Serializable;

/**
 * Klasa reprezentująca abstrakcyjną komórkę.
 * @author wojboj
 */
public class Cell implements Serializable{

    /**
     * Stan komórki. 0 - pusta, 1 - przewodnik, 2 - ogon elektronu, 3- głowa elektronu.
     */
    protected  int value;

    /**
     * współrzędna x komórki
     */
    protected  int x;

    /**
     * współrzędna y komórki
     */
    protected  int y;

    /**
     *
     * @param y współrzędna y komórki
     * @param x współrzędna x komórki
     */
    public Cell(int y, int x) {
        this.y=y;
        this.x=x;
        value = 0;
    }


    /**
     * Ustawia stan komórki. 0 - pusta, 1 - przewodnik, 2 - ogon elektronu, 3- głowa elektronu.
     * @param v stan komórki
     */

    public  void setValue(int v){
        this.value = v;
    }

    /**
     * Zwraca stan komórki. 0 - pusta, 1 - przewodnik, 2 - ogon elektronu, 3- głowa elektronu.
     * @return liczba oznaczająca stan komórki
     */
    public int getValue(){
        return value;
    }

    /**
     * Zwraca współrzędną Y komórki.
     * @return współrzędna Y komórki.
     */
    public int getY() {
        return y;
    }

    /**
     * Zwraca współrzędną X komórki.
     * @return współrzędna X komórki.
     */
    public int getX() {
        return x;
    }

    /**
     * Ustawia współrzędną Y komórki.
     * @return współrzędna Y komórki.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Ustawia współrzędną X komórki.
     * @return współrzędna X komórki.
     */
    public void setX(int x) {
        this.x = x;
    };

}
