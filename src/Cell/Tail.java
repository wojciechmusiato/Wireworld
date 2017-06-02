
package Cell;

/**
 * Ogon elektronu
 * @author wojboj
 */
public class Tail extends Cell{
    
    /**
     * Tworzy komórkę ze stanem "Ogon elektronu"
     * @param y współrzędna Y komórki
     * @param x współrzędna X komórki
     */
    public Tail(int y, int x){
        super(y,x);
        value = 2;
    }
}
