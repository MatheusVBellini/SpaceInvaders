package spaceinvaders.graphics;

import java.util.ArrayList;

import spaceinvaders.game_objects.GameObject;
import spaceinvaders.game_objects.Projectile;
import spaceinvaders.game_objects.GameObjectCollection;

/**
 * Canvas that define the game screens
 */
public class Scene {   
    /**
     * Y-axis size of the scene
     */
    private static int height = 26;
    
    /**
     * X-axis size of the scene
     */
    private static int width = 30;
    
    /**
     * pixels that compose the scene imagery
     */
    private char pixels[][];

    // no arguments for standard game screen
    
    /**
     * Initializes pixels with main game screen information 
     */
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
    
    /**
     * Gets scene default height
     * 
     * @return scene height 
     */
    public static int getHeight() {
        return height;
    }

    /**
     * Gets scene default width
     * 
     * @return scene width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * Gets the center of the scene relative to the x-axis
     * 
     * @return center coordinate of x-axis
     */
    public static int getCenterX() {
        return width / 2;
    }

    /**
     * Gets the center of the scene relative to the y-axis
     * 
     * @return center coordinate of y-axis
     */
    public static int getCenterY() {
        return height / 2;
    }
    
    /**
     * Sets a new height for the scenes
     * 
     * @param height scene height
     */
    public static void setHeight(int height) {
        Scene.height = height;
    }
    
    /**
     * Sets a new width for the scenes
     * 
     * @param width scene width
     */
    public static void setWidth(int width) {
        Scene.width = width;
    }
    
    /**
     * Clears the terminal window
     */
    private void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    /**
     * Prints the composed scene out on the terminal screen
     */
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
    
    /**
     * Adds GameObject Sprite information in the pixels attribute
     * 
     * @param gameObject gameObject to be drawn
     */
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

    /**
     * Adds the information of a entire collection's Sprite to the pixels attribute
     * 
     * @param gameObjectCollection collection with all the GameObjects to be drawn
     */
    private void draw(ArrayList<GameObject> gameObjectCollection) {
        gameObjectCollection.forEach(gameObject -> draw(gameObject));
    }

    /**
     *  
     */
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

    /**
     * 
     */
    private void clean(ArrayList<GameObject> gameObjectCollection) {
        gameObjectCollection.forEach(gameObject -> clean(gameObject));
    }

    // renders current estabilished scene
    
    /**
     * 
     * @param gameObjectCollection
     */
    public void render(GameObjectCollection gameObjectCollection) {
        draw(gameObjectCollection.getAllies());
        draw(gameObjectCollection.getAliens().getArrayOfAliens());
        build();
        clean(gameObjectCollection.getAllies());
        clean(gameObjectCollection.getAliens().getArrayOfAliens());
    }
}
