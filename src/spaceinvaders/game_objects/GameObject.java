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
        sprite = (true) ? new SpriteTUI(this) : new SpriteGUI(this);
    }

    // setters
    public void setX(int x) {
        int coordinate = x - (hitboxWidth / 2);
        if (coordinate <= 0) {
            throw new IllegalArgumentException("Object collision detected! Operation aborted.");
        }
        this.x = coordinate;
    }

    public void setY(int y) {
        int coordinate = y - (hitboxHeight - 1);
        if (coordinate <= 0) {
            throw new IllegalArgumentException("Object collision detected! Operation aborted.");
        }
        this.y = coordinate;
    }

    // getters
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
