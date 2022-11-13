package spaceinvaders.game_objects;

/**
 * Damage inflicting game objects that can be shot
 */
public abstract class Projectile extends GameObject {

    /**
     * Set the coordinates of the game object and its health to 1
     * 
     * @param x x-axis coordinate
     * @param y y-axis coordinate
     */
    protected Projectile(int x, int y) {
        super(x, y);
        health = 1;
    }
    
    /**
     * Move the projectile on the screen according to it's shooter
     */
    protected abstract void move();

    /**
     * Move the projectile according to its move() method
     */
    @Override
    public void update() {
        move();
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public abstract Projectile copy();
    
}
