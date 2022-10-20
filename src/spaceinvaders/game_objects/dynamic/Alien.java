package spaceinvaders.game_objects.dynamic;

import spaceinvaders.game_objects.GameObject;

/*
 * Base enemy class
 */
public class Alien extends GameObjectDynamic {
    /*
    *
    * Attributes
    *
    */

    // game object stats
    private int health;


    /*
    *
    * Methods
    *
    */
    // constructor
    public Alien(int x, int y) {
        super(x,y);
        this.health = 1;
    }

    boolean isAlive() {
        if (this.health == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    void move() {}

    // update method for redrawing game objects every frame
    @Override
    public void update() {}
}
