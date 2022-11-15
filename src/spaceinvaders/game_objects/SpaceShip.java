package spaceinvaders.game_objects;

import spaceinvaders.graphics.sprite.SpaceShipSprite;

/**
 * Special ship that, if hit by player, gives a bonus score
 */
public class SpaceShip extends GameObject {
    /**
     * Sets the initial position on screen of the spaceship,
     * sets its health to 1 and assigns a sprite to it
     * 
     * @param x x-axis alien's pivot position
     * @param y y-axis alien's pivot position
     */
    public SpaceShip(int x, int y) {
        super(x,y);
        sprite = new SpaceShipSprite();
        health = 1;
    }
    
    /**
     * Move the ship one pixel rightwards
     */
    private void move() {
        setX(getX() + 1);
    }
    
    /**
     * Updates the position of the ship
     */
    @Override
    public void update() {
        for (int i = 0; i < getSpeed(); i++) {
            move();
            updateSprite();
        }
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public SpaceShip copy() {
        return new SpaceShip(getX(), getY());
    }
}
