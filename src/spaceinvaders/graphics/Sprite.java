package spaceinvaders.graphics;

import spaceinvaders.game_objects.*;

/**
 * Graphical information game objects
 */
public class Sprite {
    /**
     * Height of the sprite according to the game object's hitbox height
     */
    private int height = GameObject.getHitboxHeight();
    
    /**
     * Width of the sprite according to the game object's hitbox width
     */
    private int width = GameObject.getHitboxWidth();
    
    /**
     * Pixel information of the game object sprite
     */
    private char pixels[][];

    /**
     * Fills the pixel matrix with the gameObject sprite information
     * 
     * @param gameObject GameObject that has the sprite
     */
    public Sprite(GameObject gameObject) {
        pixels = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }

        if (gameObject instanceof Cannon) {
            pixels[0][0] = '\u26E2';
        } else if (gameObject instanceof Alien) {
            pixels[0][0] = '\u2689';
        } else if (gameObject instanceof Barricade) {
            pixels[0][0] = '\u2617';
        } else if (gameObject instanceof Projectile) {
            pixels = new char[Projectile.getHitboxHeight()][Projectile.getHitboxWidth()];
            if (gameObject instanceof ProjectileAlien) {
                pixels[0][0] = '\u29BF';
            } else {
                pixels[0][0] = '\u29BE';
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
