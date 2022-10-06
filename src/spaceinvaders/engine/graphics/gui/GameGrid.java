package spaceinvaders.engine.graphics.gui;

import spaceinvaders.game_objects.GameObject;

/*
 * 64x128
 */
public class GameGrid {
    /*
     * 
     * Attributes
     * 
     */
    private static int height = 64;
    private static int width = 128;
    private static int centerX = width / 2;
    private static int centerY = height / 2;


    /* 
     * 
     * Methods
     * 
     */
    // getters
    static int getCenterX() {
        return GameGrid.centerX;
    }

    static int getCenterY() {
        return GameGrid.centerY;
    }

    // misc
    static void draw(GameObject gameObject) {
        // TODO Auto-generated method stub
    }
        
}
