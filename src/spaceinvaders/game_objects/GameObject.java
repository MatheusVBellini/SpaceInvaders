package spaceinvaders.game_objects;

import spaceinvaders.graphics.sprite.Sprite;

/**
 *  Abstract class for defining game objects
 * 
 */
public abstract class GameObject {    
    /**
     * Maximum moving speed of game objects
     */
    private static final int speed = 6;
    
    /**
     *  x-axis position of object's pivot
     */
    private int x;
    
    /**
     *  y-axis position of object's pivot
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
     * Sets the game object's pivot coordinates
     * 
     * @param x
     * @param y
     */
    protected GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        sprite.setX(x);
        sprite.setY(y);
    }
    
    /**
     * Changes the x-axis coordinate of the pivot coordinate
     * 
     * @param x new pivot position in the x-axis
     */
    public void setX(int x) {
        sprite.setX(x);
    }

    /**
     * Changes the y-axis coordinate of the pivot coordinate
     * 
     * @param y new pivot position in the y-axis
     */
    public void setY(int y) {
        sprite.setY(y);
    }

    /**
     * Gets the x-axis coordinate of the top-left-most pixel of the game object
     * 
     * @return x-axis coordinate of the top-left-most pixel of the game object
     */
    public int getX() {
        return (int)sprite.getX();
    }

    /**
     * Gets the y-axis coordinate of the top-left-most pixel of the game object
     * 
     * @return y-axis coordinate of the top-left-most pixel of the game object
     */
    public int getY() {
        return (int)sprite.getY();
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
