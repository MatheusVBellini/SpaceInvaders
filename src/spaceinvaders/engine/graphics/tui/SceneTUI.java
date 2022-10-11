package spaceinvaders.engine.graphics.tui;

import spaceinvaders.engine.graphics.Scene;
import spaceinvaders.game_objects.GameObject;
import spaceinvaders.game_objects.Sprite;
import spaceinvaders.game_objects.SpriteTUI;
import spaceinvaders.game_objects.dynamic_objects.Projectile;

public class SceneTUI extends Scene {
    /*
     * 
     * Attributes
     * 
     */
    private int height = 32;
    private int width = 60;
    private char pixels[][];

    /*
     * 
     * Methods
     * 
     */
    // constructor
    public SceneTUI() {
        this.pixels = new char[height][width];
        // initalizes pixels with '.'
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }
    }

    // getters
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getCenterX() {
        return this.width / 2;
    }

    public int getCenterY() {
        return this.height / 2;
    }

    // clears the terminal
    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // builds the scene in the screen
    public void build() {
        this.clearTerminal();
        // draws pixels values in the terminal
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(pixels[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    // draw an object
    public void draw(GameObject gameObject) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        int objectHeight = GameObject.getHitboxHeight();
        int objectWidth = GameObject.getHitboxWidth();
        if (gameObject instanceof Projectile) {
            objectHeight = Projectile.getHitboxHeight();
            objectWidth = Projectile.getHitboxWidth();
        }
        SpriteTUI sprite = (SpriteTUI)gameObject.getSprite();
        char spritePixels[][] = sprite.getPixels();

        // substitutes pixels in the pixel array
        for (int i = 0; i < objectHeight; i++) {
            for (int j = 0; j < objectWidth; j++) {
                pixels[y + i][x + j] = spritePixels[i][j];
            }
        }
    }
}
