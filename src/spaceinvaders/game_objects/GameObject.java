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
    private int height;
    private int width;

    // game object position
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
    GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // update method for redrawing game objects every frame
    public abstract void update();
}