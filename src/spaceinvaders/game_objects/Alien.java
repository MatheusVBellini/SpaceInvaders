package spaceinvaders.game_objects;

/*
 * Base enemy class
 */
public class Alien extends GameObjectDynamic {
    /*
    *
    * Attributes
    *
    */

    // game object geometry
    private static int height = 10;
    private static int width = 10;

    // game object stats
    private int health;


    /*
    *
    * Methods
    *
    */
    // constructor
    Alien(int x, int y) {
        super(x,y);
        this.health = 1;
    }

    // checkes whether the alien is alive
    boolean isAlive() {
        if (this.health == 1) {
            return true;
        } else {
            return false;
        }
    }

    // update method for redrawing game objects every frame
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
