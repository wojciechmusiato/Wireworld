
package Cell;

/**
 * Przewodnik
 * @author wojboj
 */
public class Conductor extends Cell{

    /**
     * tworzy komórkę "Przewodnik"
     * @param y współrzędna Y komórki
     * @param x współrzędna X komórki
     */
    public Conductor(int y, int x){
        super(y,x);
        value = 1;
    }
} 

