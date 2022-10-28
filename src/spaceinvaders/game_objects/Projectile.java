package spaceinvaders.game_objects;

/**
 *
 * @author matheusbellini
 */
public abstract class Projectile extends GameObject {
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
     * @param x
     * @param y
     */
    protected Projectile(int x, int y) {
        super(x + (GameObject.getHitboxWidth() / 2), y + (GameObject.getHitboxHeight() - 1));
        health = 1;
    }

    // getters
    
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

    // setters
    
    /**
     * 
     * @param x
     */
    public void setPivotX(int x) {
        super.setPivotX(x + (hitboxWidth / 2));
    }

    /**
     * 
     * @param y
     * @param y
     */
    public void setPivotY(int y) {
        super.setPivotY(y + (hitboxHeight - 1));
    }

    /**
     * 
     * @return 
     * @return  
     */
    public int getPivotX() {
        return getX();
    }

    /**
     * 
     * @return 
     * @return  
     */
    public int getPivotY() {
        return getY();
    }
    
    /**
     * 
     */
    public abstract void move();

    // update method for redrawing game objects every frame

    /**
     * 
     */
    public void update() {
        move();
    }
    
    /**
     * 
     * @return 
     * @return  
     */
    public abstract Projectile copy();
    
}
