package spaceinvaders.game_objects;

public class Projectile extends GameObject {
    /*
     * 
     * Attributes
     * 
     */
    // game object geometry
    private static int hitboxHeight = 1;
    private static int hitboxWidth = 1;


    /*
     * 
     * Methods
     *
     */
    // constructor
    public Projectile(int x, int y) {
        super(x + (GameObject.getHitboxWidth() / 2), y + (GameObject.getHitboxHeight() - 1));
    }

    // getters
    public static int getHitboxHeight() {
        return hitboxHeight;
    }

    public static int getHitboxWidth() {
        return hitboxWidth;
    }

    // setters
    @Override
    public void setPivotX(int x) {
        super.setPivotX(x + (hitboxWidth / 2));
    }

    @Override
    public void setPivotY(int y) {
        super.setPivotY(y + (hitboxHeight - 1));
    }

    @Override
    public int getPivotX() {
        return getX();
    }

    @Override
    public int getPivotY() {
        return getY();
    }
    
    private void move() {}

    // update method for redrawing game objects every frame
    @Override
    public void update() {}
}
