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
    public void move() {
        setPivotY(getPivotY() + 1);
    }
    
    @Override
    public ProjectileAlien copy() {
        return new ProjectileAlien(getPivotX(),getPivotY());
    } 
}
