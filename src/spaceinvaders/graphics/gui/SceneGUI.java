package spaceinvaders.graphics.gui;

import spaceinvaders.graphics.Scene;
import spaceinvaders.game_objects.GameObject;

import java.util.ArrayList;

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
        this.screenMap = new ScreenMap(width, height);

        // initializes the game grid
        this.gameGrid = new GameGrid();
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

    // setters
    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero");
        }
        SceneGUI.height = height;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero");
        }
        SceneGUI.width = width;
    }

    // renders the scene
    public void render(ArrayList<GameObject> gameObjectCollection) {}
}
