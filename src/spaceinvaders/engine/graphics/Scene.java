package spaceinvaders.engine.graphics;

public class Scene {
    /*
    *
    * Attributes
    * 
    */
    // resolution
    private int height = 480;
    private int width = 640;

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
    public Scene() {
        // initializes the screen map
        this.screenMap = new ScreenMap();

        // initializes the game grid
        this.gameGrid = new GameGrid();
    }

    // getters
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
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
}
