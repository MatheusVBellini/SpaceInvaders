package spaceinvaders.game_objects;

import spaceinvaders.graphics.Scene;
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
        int newPivotX = getPivotX() + x;
        if (newPivotX >= 0 && newPivotX < Scene.getWidth()) {
            System.out.println(newPivotX);
            setPivotX(newPivotX);
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
        return new Cannon(getPivotX(), getPivotY());
    }
}
