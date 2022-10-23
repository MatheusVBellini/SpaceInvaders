package spaceinvaders.graphics;

import spaceinvaders.game_objects.*;

public class Sprite {
    /*
     * 
     * Attributes
     * 
     */
    private int height = GameObject.getHitboxHeight();
    private int width = GameObject.getHitboxWidth();
    private char pixels[][];

    /*
     * 
     * Methods
     * 
     */
    public Sprite(GameObject gameObject) {
        pixels = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }

        //. . H . .
        //. / # \ .
        //[ 0 0 0 ]
        if (gameObject instanceof Cannon) {
            pixels[0][0] = '\u26E2';
        }
        //| = = = |
        //H 0 v 0 H
        //H > . < H
        else if (gameObject instanceof Alien) {
            pixels[0][0] = '\u2689';
        }
        // # # # # #
        // # # # # #
        // # . . . #
        else if (gameObject instanceof Barricade) {
            pixels[0][0] = '\u2617';
        }
        //~
        else if (gameObject instanceof Projectile) {
            pixels = new char[Projectile.getHitboxHeight()][Projectile.getHitboxWidth()];
            if (gameObject instanceof ProjectileAlien) {
                pixels[0][0] = '\u29BF';
            } else {
                pixels[0][0] = '\u29BE';
            } 
        }
    }

    // getters
    public char[][] getPixels() {
        return this.pixels;
    }

}
