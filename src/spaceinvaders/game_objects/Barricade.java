package spaceinvaders.game_objects;

/*
 * Define the barricade that defends player 
 */
public class Barricade extends GameObject {
    /*
    *
    * Attributes
    *
    */
    // game object geometry

    // game object stats

    /*
    *
    * Methods
    *
    */
    // constructor
    public Barricade(int x, int y) {
        super(x,y);
        health = 3;
    }

    // update method for redrawing game objects every frame
    @Override
    public void update() {}
    
    @Override
    public Barricade copy() {
        return new Barricade(getPivotX(), getPivotY());
    }
}
