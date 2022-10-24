package spaceinvaders.game_objects;

/*
 * Base enemy class
 */
public class Alien extends GameObject {
    /*
    *
    * Attributes
    *
    */


    /*
    *
    * Methods
    *
    */
    // constructor
    public Alien(int x, int y) {
        super(x,y);
        health = 1;
    }

    // movement methods
    private enum Direction {
        left, right
    };
    private Direction direction = Direction.right;

    private void moveRight() {
        setPivotX(getPivotX() + 1);
    }

    private void moveLeft() {
        setPivotX(getPivotX() - 1);
    }

    private void moveDown() {
        setPivotY(getPivotY() + 1);
    }

    public void move() {
        if (direction == Direction.left) {
            moveLeft();
        } else {
            moveRight();
        }
    }
    
    private void switchDirection() {
        if (direction == Direction.left) {
            direction = Direction.right;
        } else {
            direction = Direction.left;
        }
    }

    // if hits a wall descend and switch direction
    @Override
    public void update() {
        switchDirection();
        moveDown();
        move();
    }
    
    @Override
    public Alien copy() {
        return new Alien(getPivotX(), getPivotY());
    }
}
