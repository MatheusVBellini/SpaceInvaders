package spaceinvaders.game_objects;

/**
 * Special ship that, if hit by player, gives a bonus score
 */
public class SpaceShip extends GameObject {
    /**
     * Sets the initial position on screen of the spaceship and 
     * sets its health to 1
     * 
     * @param x x-axis alien's pivot position
     * @param y y-axis alien's pivot position
     */
    public SpaceShip(int x, int y) {
        super(x,y);
        health = 1;
    }
    
    /**
     * Move the ship one pixel rightwards
     */
    private void move() {
        setPivotX(getPivotX() + 1);
    }
    
    /**
     * Updates the position of the ship
     */
    @Override
    public void update() {
        move();
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public SpaceShip copy() {
        return new SpaceShip(getPivotX(), getPivotY());
    }
}
