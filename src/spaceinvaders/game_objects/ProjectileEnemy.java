package spaceinvaders.game_objects;

import spaceinvaders.graphics.sprite.ProjectileEnemySprite;

/**
 * Projectiles shot by aliens
 */
public class ProjectileEnemy extends Projectile {   
    /**
     * Set the coordinates of the projectile and assigns a sprite to it
     * 
     * @param x x-axis coordinate
     * @param y y-axis coordinate
     */
    ProjectileEnemy(int x, int y) {
        super(x,y);
        sprite = new ProjectileEnemySprite();
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
    public ProjectileEnemy copy() {
        return new ProjectileEnemy(getPivotX(),getPivotY());
    } 
}
