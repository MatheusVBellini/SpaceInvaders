package spaceinvaders.game_objects;

import spaceinvaders.engine.GameEngine;
import spaceinvaders.graphics.sprite.Sprite;

/**
 *  Abstract class for defining game objects
 * 
 */
public abstract class GameObject {    
    /**
     * Maximum moving speed of game objects
     */
    private static final int speed = 3;
    
    /**
     *  x-axis position of object
     */
    private int x;
    
    /**
     *  y-axis position of object
     */
    private int y;
    
    /**
     * Attribute that specifies how the object is supposed to be drawn
     */
    protected Sprite sprite;
    
    /**
     * Health of a GameObjects (helps determine whether it's alive)
     */
    protected int health;
    
    /**
     * object width defined by screen size
     */
    private static final int gameObjectWidth = GameEngine.settings().getResWidth()/20;
    
    /**
     * object height defined by screen size
     */
    private static final int gameObjectHeight = GameEngine.settings().getResHeight()/30;

    
    /**
     * Sets the game object coordinates
     * 
     * @param x
     * @param y
     */
    protected GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Changes the x-axis coordinate of the coordinate
     * 
     * @param x new position in the x-axis
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Changes the y-axis coordinate of the coordinate
     * 
     * @param y new position in the y-axis
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the x-axis coordinate of the object
     * 
     * @return x-axis coordinate of the object
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-axis coordinate of the object
     * 
     * @return y-axis coordinate of the object
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the sprite of game object
     * 
     * @return sprite of the game object
     */
    public Sprite getSprite() {
        return sprite;
    }
    
    /**
     * @return object width on the screen
     */
    public static int getGameObjectWidth() {
        return gameObjectWidth;
    }
    
    /**
     * @return object height on the screen 
     */
    public static int getGameObjectHeight() {
        return gameObjectHeight;
    }
    
    /**
     * Gets the general speed of gameObjects
     * 
     * @return speed of gameObjects
     */
    public static int getSpeed() {
        return speed;
    }
    
    /**
     * Method to change inner states of the game object
     */
    public abstract void update();
    
    /**
     * Method for updating visual information of the object
     */
    protected void updateSprite() {
        sprite.getImage().setTranslateX(getX());
        sprite.getImage().setTranslateY(getY());
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    public abstract GameObject copy();
    
    /**
     * Decreases 1 unit of life of the GameObject
     */
    public void takeDamage() {
        health -= 1;
    }
    
    /**
     * Checks if GameObject is dead
     * 
     * @return boolean, true if object is dead, false if it's not
     */
    public boolean isDead() {
        return health <= 0;
    }
}
