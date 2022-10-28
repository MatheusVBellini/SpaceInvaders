package spaceinvaders.game_objects;

/*
 * Define the barricade that defends player 
 */

/**
 *
 * @author matheusbellini
 */

public class Barricade extends GameObject {
    /*
    *
    * Attributes
    *
    */
    // game object geometry

    // game object stats

    /*
    *
    * Methods
    *
    */
    // constructor
    
    /**
     * 
     * @param x
     * @param x
     * @param y
     */
    public Barricade(int x, int y) {
        super(x,y);
        health = 1;
    }
    
    /**
     * 
     */
    public void update() {}
    
    /**
     * 
     * @return 
     * @return  
     */
    public Barricade copy() {
        return new Barricade(getPivotX(), getPivotY());
    }
}
