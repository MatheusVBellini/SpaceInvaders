package spaceinvaders.game_objects;

import spaceinvaders.game_objects.GameObject.objectType;

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
    SpriteTUI(objectType type) {
        pixels = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }

        //. . . # . . .
        //. . . # . . .
        //. . # # # . .
        //. # # # # # .
        //# # # # # # #
        if (type == objectType.Cannon) {
            for (int i = height - 1; i >= height - 3; i--) {
                for (int j = (width - 1) - i; j <= i; j++) {
                    pixels[i][j] = '#';
                }
            }
            pixels[0][width / 2] = '#';
            pixels[1][width / 2] = '#';
        }
        //. # # # # # .
        //# # . . . # #
        //# . # # # . #
        //# . . # . . #
        //# # . . . # #
        else if (type == objectType.Alien) {

        } else if (type == objectType.Barricade) {

        }
        //~
        else if (type == objectType.Projectile) {
            pixels = new char[1][1];
            pixels[0][0] = '~';
        }
    }

    // getters
    public char[][] getPixels() {
        return this.pixels;
    }
}
