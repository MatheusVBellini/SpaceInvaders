package spaceinvaders.graphics;

import java.util.ArrayList;

import spaceinvaders.game_objects.GameObject;
import spaceinvaders.game_objects.Sprite;
import spaceinvaders.game_objects.Projectile;
import spaceinvaders.game_objects.GameObjectCollection;

public class Scene {
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
    // no arguments for standard game screen
    public Scene() {
        pixels = new char[height][width];
        // initalizes pixels with '.'
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }
        
        // score
        pixels[0][0] = 'S';
        pixels[0][1] = 'C';
        pixels[0][2] = 'O';
        pixels[0][3] = 'R';
        pixels[0][4] = 'E';
        pixels[0][5] = ':';
        pixels[0][6] = '0';
        
        // lives
        pixels[0][width-1] = '\u2661';
        pixels[0][width-2] = '\u2661';
        pixels[0][width-3] = '\u2661';
        pixels[0][width-9] = 'L';
        pixels[0][width-8] = 'I';
        pixels[0][width-7] = 'V';
        pixels[0][width-6] = 'E';
        pixels[0][width-5] = 'S';
        pixels[0][width-4] = ':';
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
    
    // config setters
    public static void setHeight(int height) {
        Scene.height = height;
    }
    
    public static void setWidth(int width) {
        Scene.width = width;
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
        Sprite sprite = gameObject.getSprite();
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
    public void render(GameObjectCollection gameObjectCollection) {
        draw(gameObjectCollection.getAllies());
        draw(gameObjectCollection.getAliens().getArrayOfAliens());
        build();
        clean(gameObjectCollection.getAllies());
        clean(gameObjectCollection.getAliens().getArrayOfAliens());
    }
}
