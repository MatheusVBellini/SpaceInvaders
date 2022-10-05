package spaceinvaders.engine.graphics;

public class Scene {
    /*
    *
    * Attributes
    * 
    */
    // resolution
    private static int height = 480;
    private static int width = 640;

    // screen map
    private static ScreenMap screenMap;

    // game grid
    private static GameGrid gameGrid;

    /*
    *
    * Methods
    *
    */
    // getters
    public static int getHeight() {
        return Scene.height;
    }

    public static int getWidth() {
        return Scene.width;
    }

    // setters
    public static void setHeight(int height) {
        Scene.height = height;
    }

    public static void setWidth(int width) {
        Scene.width = width;
    }
}
