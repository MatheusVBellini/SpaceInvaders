package spaceinvaders.game_objects;

public abstract class GameObject {
    /*
    *
    * Attibutes
    *
    */
    // game object geometry
    private int height;
    private int width;

    // game object position
    private int x;
    private int y;

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

    // update method for redrawing game objects every frame
    public abstract void update();
}