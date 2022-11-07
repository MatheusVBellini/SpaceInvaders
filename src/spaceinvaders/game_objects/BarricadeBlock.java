package spaceinvaders.game_objects;

import java.util.LinkedList;

/**
 * Group of point-wise barricades 
 * 
 * @author matheusbellini
 */
public class BarricadeBlock implements Updatable {   
    /**
     * Collection of barricades
     */
    private LinkedList<Barricade> barricades;
    
    /**
     * Instantiate the Barricade block composed of 3 barricades, 
     * based on a pivot coordinate
     */
    public BarricadeBlock(int x, int y) {
        barricades = new LinkedList<>();
        barricades.add(new Barricade(x,y));
        barricades.add(new Barricade(x-1,y));
        barricades.add(new Barricade(x+1,y));
    }
    
    /**
     * Apply update method in the entire collection
     */
    public void update() {
        barricades.forEach(barricade -> barricade.update());
    }
}
