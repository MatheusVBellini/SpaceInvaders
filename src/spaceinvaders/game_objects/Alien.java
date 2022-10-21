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

    private void move_right() {
        setPivotX(getPivotX() + 1);
    }

    private void move_left() {
        setPivotX(getPivotX() - 1);
    }

    private void move_down() {
        setPivotY(getPivotY() + 1);
    }

    private void move() {
        if (direction == Direction.left) {
            move_left();
        } else {
            move_right();
        }
    }

    // if hits a wall descend and switch direction
    @Override
    public void update() {
        move();
        if (getX() <= 0) {
            direction = Direction.right;
            move_down();
            move();
        } else if (getX() + getHitboxWidth() >= Scene.getWidth()) {
            direction = Direction.left;
            move_down();
            move();
        }
    }
}
