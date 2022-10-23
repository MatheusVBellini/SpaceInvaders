package spaceinvaders.game_objects;

/**
 *
 * @author matheusbellini
 */
public class ProjectileAlly extends Projectile {
    ProjectileAlly(int x, int y) {
        super(x,y);
    }
    
    @Override
    protected void move() {
        setPivotY(getPivotY() - 1);
    }
}
