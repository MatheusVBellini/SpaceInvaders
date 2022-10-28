package spaceinvaders.game_objects;

/**
 * Projectiles shot by the cannon
 */
public class ProjectileAlly extends Projectile {
    /**
     * Set the coordinates of the projectile
     * 
     * @param x x-axis coordinate
     * @param y y-axis coordinate
     */
    ProjectileAlly(int x, int y) {
        super(x,y);
    }
    
    /**
     * Move the projectile a pixel upwards
     */
    public void move() {
        setPivotY(getPivotY() - 1);
    }
     
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    public ProjectileAlly copy() {
        return new ProjectileAlly(getPivotX(),getPivotY());
    } 
}
