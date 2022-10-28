package spaceinvaders.game_objects;

import spaceinvaders.graphics.Sprite;


/*
 * Abstract class for defining game objects
 */

/**
 *
 * @author matheusbellini
 */

public abstract class GameObject {
    /*
    *
    * Attributes
    *
    */
    // game object geometry
    
    /**
     * 
     */
    private static int hitboxHeight = 1;
    
    /**
     * 
     */
    private static int hitboxWidth = 1;

    // game object position (pivot)
    
    /**
     * 
     */
    private int x;
    
    /**
     * 
     */
    private int y;

    // game object sprite
    
    /**
     * 
     */
    protected Sprite sprite;
    
    // game object stats
    
    /**
     * 
     */
    protected int health;

    /*
     * 
     * Methods
     * 
     */
    // constructor
    
    /**
     * 
     * @param x
     * @param y
     * @param y
     */
    protected GameObject(int x, int y) {
        this.x = x - (hitboxWidth / 2);
        this.y = y - (hitboxHeight - 1);
        sprite = new Sprite(this);
    }

    // setters
    
    /**
     * 
     * @param x
     */
    public void setPivotX(int x) {
        int coordinate = x - (hitboxWidth / 2);
        this.x = coordinate;
    }

    /**
     * 
     * @param y
     */
    public void setPivotY(int y) {
        int coordinate = y - (hitboxHeight - 1);
        this.y = coordinate;
    }

    // getters
    
    /**
     * 
     * @return 
     */
    public int getPivotX() {
        return x + (hitboxWidth / 2);
    }

    /**
     * 
     * @return 
     */
    public int getPivotY() {
        return y + (hitboxHeight - 1);
    }

    /**
     * 
     * @return 
     * @return  
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @return 
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @return 
     * @return  
     */
    public static int getHitboxHeight() {
        return hitboxHeight;
    }

    /**
     * 
     * @return 
     * @return  
     */
    public static int getHitboxWidth() {
        return hitboxWidth;
    }

    /**
     * 
     * @return 
     */
    public Sprite getSprite() {
        return sprite;
    }

    // update method for redrawing game objects every frame
    
    /**
     * 
     */
    public abstract void update();
    
    /**
     * 
     * @return 
     * @return  
     */
    public abstract GameObject copy();
}
