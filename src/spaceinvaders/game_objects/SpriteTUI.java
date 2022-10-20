package spaceinvaders.game_objects;

import spaceinvaders.game_objects.dynamic.Projectile;
import spaceinvaders.game_objects.dynamic.Cannon;
import spaceinvaders.game_objects.dynamic.Alien;

public class SpriteTUI extends Sprite {
    /*
     * 
     * Attributes
     * 
     */
    private char pixels[][];

    /*
     * 
     * Methods
     * 
     */
    SpriteTUI(GameObject gameObject) {
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
            pixels[0][2] = 'H';

            pixels[1][1] = '/';
            pixels[1][2] = '#';
            pixels[1][3] = '\\';

            pixels[2][0] = '[';
            pixels[2][1] = '0';
            pixels[2][2] = '0';
            pixels[2][3] = '0';
            pixels[2][4] = ']';
        }
        //| = = = |
        //H 0 v 0 H
        //H > . < H
        else if (gameObject instanceof Alien) {
            pixels[0][0] = '|';
            pixels[0][1] = '=';
            pixels[0][2] = '=';
            pixels[0][3] = '=';
            pixels[0][4] = '|';

            pixels[1][0] = 'H';
            pixels[1][1] = '0';
            pixels[1][2] = 'v';
            pixels[1][3] = '0';
            pixels[1][4] = 'H';

            pixels[2][0] = 'H';
            pixels[2][1] = '>';
            pixels[2][3] = '<';
            pixels[2][4] = 'H';
        }
        // # # # # #
        // # # # # #
        // # . . . #
        else if (gameObject instanceof Barricade) {
            pixels[0][0] = '#';
            pixels[0][1] = '#';
            pixels[0][2] = '#';
            pixels[0][3] = '#';
            pixels[0][4] = '#';

            pixels[1][0] = '#';
            pixels[1][1] = '#';
            pixels[1][2] = '#';
            pixels[1][3] = '#';
            pixels[1][4] = '#';

            pixels[2][0] = '#';
            pixels[2][4] = '#';
        }
        //~
        else if (gameObject instanceof Projectile) {
            pixels = new char[Projectile.getHitboxHeight()][Projectile.getHitboxWidth()];
            pixels[0][0] = '~';
        }
    }

    // getters
    public char[][] getPixels() {
        return this.pixels;
    }
}
