package spaceinvaders.game_objects;

public class Barricade extends GameObject {
    /*
    *
    * Attibutes
    *
    */
    private static int height = 10;
    private static int width = 10;

    /*
    *
    * Methods
    *
    */
    // constructor
    public Barricade(int x, int y) {
        super(x,y);
    }

    // update method for redrawing game objects every frame
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}