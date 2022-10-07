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
    private int width = 32;
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
        int offsetX = GameObject.getHitboxWidth();
        int offsetY = GameObject.getHitboxHeight();
        if (gameObject.getClass() == (new Projectile(0,0)).getClass()) {
            offsetX = 0;
            offsetY = 0;
        }
        SpriteTUI sprite = (SpriteTUI)gameObject.getSprite();
        char spritePixels[][] = sprite.getPixels();

        // substitutes pixels in the pixel array
        int a = y - offsetY;
        int b = x - offsetX;
        for (int i = offsetY-1; i >= 0; i++) {
            for (int j = offsetX-1; j >= 0; j++) {
                pixels[a + i][b + j - (offsetX + 1)] = spritePixels[i][j];
            }
        }
    }
}
