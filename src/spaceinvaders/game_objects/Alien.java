package spaceinvaders.game_objects;

import spaceinvaders.graphics.Scene;

/*
 * Base enemy class
 */
public class Alien extends GameObject {
    /*
    *
    * Attributes
    *
    */

    // game object stats
    private int health;


    /*
    *
    * Methods
    *
    */
    // constructor
    public Alien(int x, int y) {
        super(x,y);
        this.health = 1;
    }

    boolean isAlive() {
        if (this.health == 1) {
            return true;
        } else {
            return false;
        }
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
        setPivotY(getPivotY() + getHitboxHeight());
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
        //move();
        //if (getX() < 0 || getX() > Scene.getWidth() - getHitboxWidth()) {
            switchDirection();
            moveDown();
            move();
        //}
    }
}
