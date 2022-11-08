package spaceinvaders.graphics.sprite;

import spaceinvaders.game_objects.*;

/**
 * Graphical information game objects
 */
public abstract class Sprite {
    /**
     * Height of the sprite according to the game object's hitbox height
     */
    private final int height = GameObject.getHitboxHeight();
    
    /**
     * Width of the sprite according to the game object's hitbox width
     */
    private final int width = GameObject.getHitboxWidth();
    
    /**
     * Pixel information of the game object sprite
     */
    protected char pixels[][];

    /**
     * Fills the pixel matrix with '.'
     */
    protected Sprite() {
        pixels = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }
    }

    /**
     * return the matrix of pixels
     * 
     * @return pixel matrix
     */
    public char[][] getPixels() {
        return pixels;
    }

}
