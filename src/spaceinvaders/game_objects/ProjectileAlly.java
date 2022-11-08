package spaceinvaders.game_objects;

import spaceinvaders.graphics.sprite.ProjectileAllySprite;

/**
 * Projectiles shot by the cannon
 */
public class ProjectileAlly extends Projectile {
    /**
     * Set the coordinates of the projectile and assigns a sprite to it
     * 
     * @param x x-axis coordinate
     * @param y y-axis coordinate
     */
    public ProjectileAlly(int x, int y) {
        super(x,y);
        sprite = new ProjectileAllySprite();
    }
    
    /**
     * Move the projectile a pixel upwards
     */
    @Override
    protected void move() {
        setPivotY(getPivotY() - 1);
    }
     
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public ProjectileAlly copy() {
        return new ProjectileAlly(getPivotX(),getPivotY());
    } 
}
