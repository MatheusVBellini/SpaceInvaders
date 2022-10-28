package spaceinvaders.game_objects;

/**
 * Barricade that defends the player's cannon from incoming bullets from the aliens
 */
public class Barricade extends GameObject {
    /**
     * Set barricade pivot position and its health to 1
     * 
     * @param x x-axis barricade's pivot position
     * @param y y-axis barricade's pivot position
     */
    public Barricade(int x, int y) {
        super(x,y);
        health = 1;
    }
    
    /**
     * Static object, does nothing when updated
     */
    @Override
    public void update() {}
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public Barricade copy() {
        return new Barricade(getPivotX(), getPivotY());
    }
}
