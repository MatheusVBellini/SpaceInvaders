package spaceinvaders.graphics.sprite;

import spaceinvaders.game_objects.Projectile;

/**
 * ProjectileAllySprite GameObject graphical representation
 */
public class ProjectileAllySprite extends Sprite {
    public ProjectileAllySprite() {
        pixels = new char[Projectile.getHitboxHeight()][Projectile.getHitboxWidth()];
        pixels[0][0] = '\u29BE';
    }
}
