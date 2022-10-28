package spaceinvaders.game_objects;

/*
 * Playable character
 */ 

/**
 *
 * @author matheusbellini
 */
 
public class Cannon extends GameObject {
    /*
    *
    * Attributes
    *
    */
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
     * @param y
     */
    public Cannon(int x, int y) {
        super(x,y);
        health = 3;
    }
    
    /**
     * 
     */
    public void move() {}
    
    // update method for redrawing game objects every frame
    
    /**
     * 
     */
    public void update() {}
    
    /**
     * 
     * @return 
     */
    public Cannon copy() {
        return new Cannon(getPivotX(), getPivotY());
    }
}
