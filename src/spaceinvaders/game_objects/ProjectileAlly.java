package spaceinvaders.game_objects;

/**
 *
 * @author matheusbellini
 */
public class ProjectileAlly extends Projectile {
    /**
     * 
     */
    ProjectileAlly(int x, int y) {
        super(x,y);
    }
    
    /**
     * 
     */
    public void move() {
        setPivotY(getPivotY() - 1);
    }
     
    /**
     * 
     * @return 
     * @return  
     */
    public ProjectileAlly copy() {
        return new ProjectileAlly(getPivotX(),getPivotY());
    } 
}
