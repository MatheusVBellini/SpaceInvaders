package spaceinvaders.game_objects;

/**
 * Projectiles shot by aliens
 */
public class ProjectileAlien extends Projectile {   
    /**
     * Set the coordinates of the projectile
     * 
     * @param x x-axis coordinate
     * @param y y-axis coordinate
     */
    ProjectileAlien(int x, int y) {
        super(x,y);
    }
    
    /**
     * Move the projectile a pixel downwards
     */
    @Override
    protected void move() {
        setPivotY(getPivotY() + 1);
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public ProjectileAlien copy() {
        return new ProjectileAlien(getPivotX(),getPivotY());
    } 
}
