package spaceinvaders.game_objects;

import spaceinvaders.graphics.Sprite;

/**
 *  Abstract class for defining game objects
 * 
 */
public abstract class GameObject {
    /**
     * Height of the collision susceptible box which the object is contained within
     */
    private static int hitboxHeight = 1;
    
    /**
     * Width of the collision susceptible box which the object is contained within
     */
    private static int hitboxWidth = 1;
    
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
        this.x = x - (hitboxWidth / 2);
        this.y = y - (hitboxHeight - 1);
        sprite = new Sprite(this);
    }

    // setters
    
    /**
     * Changes the x-axis coordinate of the pivot coordinate
     * 
     * @param x new pivot position in the x-axis
     */
    public void setPivotX(int x) {
        int coordinate = x - (hitboxWidth / 2);
        this.x = coordinate;
    }

    /**
     * Changes the y-axis coordinate of the pivot coordinate
     * 
     * @param y new pivot position in the y-axis
     */
    public void setPivotY(int y) {
        int coordinate = y - (hitboxHeight - 1);
        this.y = coordinate;
    }
    
    /**
     * Gets the pivot coordinate of the x-axis
     * 
     * @return pivot coordinate of the x-axis
     */
    public int getPivotX() {
        return x + (hitboxWidth / 2);
    }

    /**
     * Gets the pivot coordinate of the y-axis
     * 
     * @return pivot coordinate of the y-axis
     */
    public int getPivotY() {
        return y + (hitboxHeight - 1);
    }

    /**
     * Gets the x-axis coordinate of the top-left-most pixel of the game object
     * 
     * @return x-axis coordinate of the top-left-most pixel of the game object
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-axis coordinate of the top-left-most pixel of the game object
     * 
     * @return y-axis coordinate of the top-left-most pixel of the game object
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the height of the game object's hitbox
     * 
     * @return height of the game object's hitbox
     */
    public static int getHitboxHeight() {
        return hitboxHeight;
    }

    /**
     * Gets the width of the game object's hitbox
     * 
     * @return width of the game object's hitbox
     */
    public static int getHitboxWidth() {
        return hitboxWidth;
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
     * Method to change inner states of the game object
     */
    public abstract void update();
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    public abstract GameObject copy();
}
