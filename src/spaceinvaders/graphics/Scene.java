package spaceinvaders.graphics;

import spaceinvaders.game_objects.GameObject;

import java.util.ArrayList;

public abstract class Scene {
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

    public abstract void render(ArrayList<GameObject> gameObjectCollection);

    public abstract int getHeight();
    public abstract int getWidth();
    public abstract int getCenterX();
    public abstract int getCenterY();
}
