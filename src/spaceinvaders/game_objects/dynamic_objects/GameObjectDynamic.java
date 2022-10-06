package spaceinvaders.game_objects.dynamic_objects;

import spaceinvaders.game_objects.GameObject;

public abstract class GameObjectDynamic extends GameObject {
    /*
     * 
     * Attributes
     * 
     */

    /*
     * 
     * Methods
     *
     */
    // constructor
    GameObjectDynamic(int x, int y) {
        super(x,y);
    }

    // move the game object
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
