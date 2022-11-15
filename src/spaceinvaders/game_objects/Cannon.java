package spaceinvaders.game_objects;

import spaceinvaders.engine.GameEngine;
import spaceinvaders.graphics.sprite.CannonSprite;

/**
 * Playable character of the game
 */
public class Cannon extends GameObject {
    /**
     * Sets the initial position on screen of the cannon, sets its health to 3
     * and assigns a sprite to the object
     * 
     * @param x x-axis cannon's pivot position
     * @param y y-axis cannon's pivot position
     */
    public Cannon(int x, int y) {
        super(x,y);
        sprite = new CannonSprite();
        health = 3;
        shot = false;
    }
    
    /**
     * Flag for engine to know whether Cannon has shot
     */
    private boolean shot;
    
    /**
     * Flag to know whether previous bullet is still on the screen
     */
    private boolean bulletAlive;
    
    /**
     * Get the boolean value of the shot flag
     * 
     * @return boolean that is true when the cannon has shot 
     * and false when it hasn't
     */
    public boolean hasShot() {
        return shot;
    }
    
    /**
     * turn off shot flag
     */
    public void recoil() {
        shot = false;
    }
    
    /**
     * shoot command, actives the shot flag
     */
    public void shoot() {
        shot = true;
        bulletAlive = true;
    }
    
    /**
     * Guarantees one shot at a time in the game
     */
    public boolean canShoot() {
        return !bulletAlive;
    }
    
    /**
     * makes bulletAlive false when bullet hit the target
     */
    public void hit() {
        bulletAlive = false;
    }
    
    /**
     * get the Player health
     * @return player's health
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * Cannon relies on user's input, if there's no input, then it does not move
     */
    private void move() {}
    
    /**
     * Move cannon in the x-axis
     * 
     * <p><i>Limits the movement to the game screen</i></p>
     * 
     * @param x how much the cannon is to be moved in the x-axis
     */
    public void move(int x) {
        int newPivotX = getX() + 10 * x;
        if (newPivotX >= 0 && newPivotX < GameEngine.settings().getResWidth()) {
            setX(newPivotX);
        }
    }
    
    /**
     * Trivial case - no input, no change of state
     */
    @Override
    public void update() {
        move();
        updateSprite();
    }
        
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public Cannon copy() {
        return new Cannon(getX(), getY());
    }
}
