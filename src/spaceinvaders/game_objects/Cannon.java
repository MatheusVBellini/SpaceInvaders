package spaceinvaders.game_objects;


/*
 * Playable character
 */ 
public class Cannon extends GameObject {
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

    private void move() {}
    
    // update method for redrawing game objects every frame
    @Override
    public void update() {}
    
    @Override
    public Cannon copy() {
        return new Cannon(getPivotX(), getPivotY());
    }
}
