package spaceinvaders.game_objects;

import spaceinvaders.graphics.SceneTemp;
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
        sprite = new CannonSprite(x,y);
        health = 3;
        shot = false;
    }
    
    /**
     * Flag for engine to know whether Cannon has shot
     */
    private boolean shot;
    
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
    public void reload() {
        shot = false;
    }
    
    /**
     * shoot command, actives the shot flag
     */
    public void shoot() {
        shot = true;
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
        int newPivotX = getX() + x;
        if (newPivotX >= 0 && newPivotX < SceneTemp.getWidth()) {
            System.out.println(newPivotX);
            setX(newPivotX);
        }
    }
    
    /**
     * Trivial case - no input, no change of state
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
    public Cannon copy() {
        return new Cannon(getX(), getY());
    }
}
