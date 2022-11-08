package spaceinvaders.graphics.sprite;

import spaceinvaders.game_objects.Projectile;

/**
 * ProjectileEnemy GameObject graphical representation
 */
public class ProjectileEnemySprite extends Sprite {
    public ProjectileEnemySprite() {
        pixels = new char[Projectile.getHitboxHeight()][Projectile.getHitboxWidth()];
        pixels[0][0] = '\u29BF';
    }
}
