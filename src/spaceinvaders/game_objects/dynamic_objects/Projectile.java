package spaceinvaders.game_objects.dynamic_objects;

public class Projectile extends GameObjectDynamic {
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
    public Projectile(int x, int y) {
        super(x,y,objectType.Projectile);
    }

    // update method for redrawing game objects every frame
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
