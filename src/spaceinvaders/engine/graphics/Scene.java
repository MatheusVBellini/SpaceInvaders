package spaceinvaders.engine.graphics;

import spaceinvaders.game_objects.GameObject;

public abstract class Scene {
    /*
     *
     *
     *
     */

    /*
     * 
     * Methods
     * 
     */
    public abstract void build();

    public abstract void draw(GameObject gameObject);
}
