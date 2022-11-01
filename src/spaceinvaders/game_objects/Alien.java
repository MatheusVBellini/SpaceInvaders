package spaceinvaders.game_objects;

import spaceinvaders.graphics.sprite.AlienSprite;

/**
 * Base enemy class
 */
public class Alien extends GameObject {  
    /**
     * Sets the initial position on screen of the alien, sets its health to 1
     * and assigns a sprite to the object
     * 
     * @param x x-axis alien's pivot position
     * @param y y-axis alien's pivot position
     */
    public Alien(int x, int y) {
        super(x,y);
        sprite = new AlienSprite();
        health = 1;
    }
    
    /**
     * Enum to define if alien is going rightward or leftward
     */
    private enum Direction {
        left, right
    };
    
    /**
     * Enum attribute with deafult value 'right'
     */
    private Direction direction = Direction.right;

    /**
     * Define the rightward movement of the alien
     */
    private void moveRight() {
        setPivotX(getPivotX() + 1);
    }

    /**
     *  Define the leftward movement of the alien
     */
    private void moveLeft() {
        setPivotX(getPivotX() - 1);
    }

    /**
     * Define the downward movement of the alien
     */
    private void moveDown() {
        setPivotY(getPivotY() + 1);
    }

    /**
     * Move the alien according to the direction attribute value
     */
    private void move() {
        if (direction == Direction.left) {
            moveLeft();
        } else {
            moveRight();
        }
    }
    
    /**
     * Change the direction the alien is going
     */
    private void switchDirection() {
        if (direction == Direction.left) {
            direction = Direction.right;
        } else {
            direction = Direction.left;
        }
    }
    
    /**
     * Move the aliens
     */
    @Override
    public void update() {
        move();
    }
    
    /**
     * <p>If swarm hit a wall</p>
     * Switch direction of movement and go down
     * 
     * <p>Else</p>
     * Move the aliens like the trivial case
     * 
     * @param hitwall boolean defining whether the alien hit a wall
     */
    public void update(boolean hitwall) {
        if (hitwall) {
            switchDirection();
            moveDown();
            move();
        } else {
            move();
        }
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public Alien copy() {
        return new Alien(getPivotX(), getPivotY());
    }
}
