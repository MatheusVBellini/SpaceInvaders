package spaceinvaders.game_objects.dynamic;

import spaceinvaders.game_objects.GameObject;


/*
 * Playable character
 */ 
public class Cannon extends GameObjectDynamic {
    /*
    *
    * Attributes
    *
    */
    // game object stats


    /*
    *
    * Methods
    *
    */
    // constructor
    public Cannon(int x, int y) {
        super(x,y);
    }

    void move() {}
    
    // update method for redrawing game objects every frame
    @Override
    public void update() {}
}
