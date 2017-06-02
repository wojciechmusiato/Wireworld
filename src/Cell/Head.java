
package Cell;

/**
 * Głowa elektronu
 * @author wojboj
 */
public class Head extends Cell{

    /**
     * tworzy komórkę "Głowa elektronu"
     * @param y współrzędna Y komórki
     * @param x współrzędna X komórki
     */
    public Head(int y, int x){
        super(y,x);
        value = 3;
    }
}
