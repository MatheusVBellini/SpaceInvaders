package spaceinvaders.game_objects;


/*
 * Abstract class for defining game objects
 */
public abstract class GameObject {
    /*
    *
    * Attributes
    *
    */
    // game object geometry
    private static int hitboxHeight = 3;
    private static int hitboxWidth = 5;

    // game object position (pivot)
    private int x;
    private int y;

    // game object sprite
    protected Sprite sprite;

    /*
     * 
     * Methods
     * 
     */
    // constructor
    protected GameObject(int x, int y) {
        this.x = x - (hitboxWidth / 2);
        this.y = y - (hitboxHeight - 1);
        sprite = new Sprite(this);
    }

    // setters
    public void setPivotX(int x) {
        int coordinate = x - (hitboxWidth / 2);
        this.x = coordinate;
    }

    public void setPivotY(int y) {
        int coordinate = y - (hitboxHeight - 1);
        this.y = coordinate;
    }

    // getters
    public int getPivotX() {
        return x + (hitboxWidth / 2);
    }

    public int getPivotY() {
        return y + (hitboxHeight - 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getHitboxHeight() {
        return hitboxHeight;
    }

    public static int getHitboxWidth() {
        return hitboxWidth;
    }

    public Sprite getSprite() {
        return sprite;
    }

    // update method for redrawing game objects every frame
    public abstract void update();
}
