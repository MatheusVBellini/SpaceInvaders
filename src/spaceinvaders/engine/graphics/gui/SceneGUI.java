package spaceinvaders.engine.graphics.gui;

import spaceinvaders.engine.graphics.Scene;

public class SceneGUI extends Scene {
    /*
    *
    * Attributes
    * 
    */
    // resolution
    private static int height = 480;
    private static int width = 640;

    // screen map
    private ScreenMap screenMap;

    // game grid
    private GameGrid gameGrid;

    /*
    *
    * Methods
    *
    */
    // constructor
    public SceneGUI() {
        // initializes the screen map
        this.screenMap = new ScreenMap();

        // initializes the game grid
        this.gameGrid = new GameGrid();
    }

    // getters
    public static int getHeight() {
        return SceneGUI.height;
    }

    public static int getWidth() {
        return SceneGUI.width;
    }

    // setters
    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero");
        }
        this.height = height;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero");
        }
        this.width = width;
    }

    // builds the scene in the screen
    public void build() {}
}
