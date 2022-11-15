package spaceinvaders.game_objects;

import spaceinvaders.graphics.sprite.AlienSprite1;
import spaceinvaders.graphics.sprite.AlienSprite2;
import spaceinvaders.graphics.sprite.AlienSprite3;

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
        sprite = new AlienSprite1();
        health = 1;
    }
    
    /**
     * Sets the initial position on screen of the alien, sets its health to 1
     * and assigns a sprite to the object
     * 
     * @param x x-axis alien's pivot position
     * @param y y-axis alien's pivot position
     * @param sel sprite selector
     */
    public Alien(int x, int y, int sel) {
        super(x,y);
        health = 1;
        
        switch(sel) {
            case 1:
                sprite = new AlienSprite1();
                break;
            case 2:
                sprite = new AlienSprite2();
                break;
            case 3:
                sprite = new AlienSprite3();
        }
    }
    
    /**
     * Enum to define if alien is going rightward or leftward
     */
    private enum Direction {
        left, right
    };
    
    /**
     * Enum attribute with default value 'right'
     */
    private Direction direction = Direction.right;

    /**
     * Define the rightward movement of the alien
     */
    private void moveRight() {
        setX(getX() + 1);
    }

    /**
     *  Define the leftward movement of the alien
     */
    private void moveLeft() {
        setX(getX() - 1);
    }

    /**
     * Define the downward movement of the alien
     */
    private void moveDown() {
        setY(getY() + getGameObjectHeight()/3);
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
        updateSprite();
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
        
        updateSprite();
    }
    
    /**
     * Returns a copy of the original object
     * 
     * @return copy of the original object
     */
    @Override
    public Alien copy() {
        return new Alien(getX(), getY());
    }
}
