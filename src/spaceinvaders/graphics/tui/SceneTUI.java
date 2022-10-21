package spaceinvaders.graphics.tui;

import java.util.ArrayList;

import spaceinvaders.graphics.Scene;
import spaceinvaders.game_objects.GameObject;
import spaceinvaders.game_objects.SpriteTUI;
import spaceinvaders.game_objects.Projectile;

public class SceneTUI extends Scene {
    /*
     * 
     * Attributes
     * 
     */
    private static int height = 34;
    private static int width = 60;
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
    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static int getCenterX() {
        return width / 2;
    }

    public static int getCenterY() {
        return height / 2;
    }

    // clears the terminal
    private void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // builds the scene in the screen
    private void build() {
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

    private void draw(GameObject gameObject) {
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

    private void draw(ArrayList<GameObject> gameObjectCollection) {
        gameObjectCollection.forEach(gameObject -> draw(gameObject));
    }

    private void clean(GameObject gameObject) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        int objectHeight = GameObject.getHitboxHeight();
        int objectWidth = GameObject.getHitboxWidth();
        if (gameObject instanceof Projectile) {
            objectHeight = Projectile.getHitboxHeight();
            objectWidth = Projectile.getHitboxWidth();
        }

        // substitutes pixels in the pixel array
        for (int i = 0; i < objectHeight; i++) {
            for (int j = 0; j < objectWidth; j++) {
                pixels[y + i][x + j] = '.';
            }
        }
    }

    private void clean(ArrayList<GameObject> gameObjectCollection) {
        gameObjectCollection.forEach(gameObject -> clean(gameObject));
    }

    // renders current estabilished scene
    public void render(ArrayList<GameObject> gameObjectCollection) {
        draw(gameObjectCollection);
        build();
        clean(gameObjectCollection);
    }
}
