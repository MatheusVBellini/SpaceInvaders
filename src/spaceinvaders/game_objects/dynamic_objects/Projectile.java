package spaceinvaders.game_objects.dynamic_objects;

import spaceinvaders.game_objects.GameObject;

public class Projectile extends GameObjectDynamic {
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
        super(x + (GameObject.getHitboxWidth() / 2), y + (GameObject.getHitboxHeight() - 1), objectType.Projectile);
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
    public void setX(int x) {
        super.setX(x + (hitboxWidth / 2));
    }

    @Override
    public void setY(int y) {
        super.setY(y + (hitboxHeight - 1));
    }

    // update method for redrawing game objects every frame
    @Override
    public void update() {}
}
