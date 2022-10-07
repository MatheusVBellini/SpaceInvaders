package spaceinvaders.engine.graphics.tui;

import spaceinvaders.engine.graphics.Scene;

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
}
