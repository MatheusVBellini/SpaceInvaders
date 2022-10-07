package spaceinvaders.game_objects;

import spaceinvaders.SpaceInvaders;

/*
 * Abstract class for defining game objects
 */
public abstract class GameObject {
    /*
    *
    * Attributes
    *
    */
    // object types
    protected static enum objectType {
        Cannon, Alien, Barricade, Projectile
    };

    // game object geometry
    protected static int hitbox_height = 7;
    protected static int hitbox_width = 7;

    // game object position (pivot)
    private int x;
    private int y;

    // game object sprite
    protected Sprite sprite;

    /*
     * 
     * Methods
     * 
     */
    // constructor
    public GameObject(int x, int y, objectType type) {
        this.x = x;
        this.y = y;
        sprite = (SpaceInvaders.getGameGraphicOption()) ? new SpriteTUI(type) : new SpriteGUI(type);
    }

    // setters
    public void setX(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("X coordinate must be greater than zero");
        }
        this.x = x;
    }

    public void setY(int y) {
        if (y <= 0) {
            throw new IllegalArgumentException("Y coordinate must be greater than zero");
        }
        this.y = y;
    }

    // getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // update method for redrawing game objects every frame
    public abstract void update();
}
