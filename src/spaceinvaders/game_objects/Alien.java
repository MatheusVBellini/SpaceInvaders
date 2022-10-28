package spaceinvaders.game_objects;

/**
 * Base enemy class
 */
public class Alien extends GameObject {  
    /**
     * Sets the initial position on screen of the alien and sets its health to 1
     * 
     * @param x x-axis alien's pivot position
     * @param y y-axis alien's pivot position
     */
    public Alien(int x, int y) {
        super(x,y);
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
    public void move() {
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
     * Switch direction of movement and go down
     * 
     * <p><i>should be called only when alien hits the wall</i></p>
     */
    @Override
    public void update() {
        switchDirection();
        moveDown();
        move();
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
