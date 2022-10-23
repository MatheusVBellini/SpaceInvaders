package spaceinvaders.game_objects;

/**
 *
 * @author matheusbellini
 */
public class ProjectileAlien extends Projectile {
    ProjectileAlien(int x, int y) {
        super(x,y);
    }
    
    @Override
    protected void move() {
        setPivotY(getPivotY() + 1);
    }
}
