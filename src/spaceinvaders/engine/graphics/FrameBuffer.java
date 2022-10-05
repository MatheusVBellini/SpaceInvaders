package spaceinvaders.engine.graphics;

public class FrameBuffer {
    /*
    *
    * Attributes
    *
    */
    private final int height = Scene.getHeight();
    private final int width = Scene.getWidth();
    private int pixel[][];

    /*
    *
    * Methods
    *
    */
    // constructor
    FrameBuffer() {
        this.pixel = new int[height][width];

        // intializes the pixels with zeros
        clear();
    }

    // clears the frame buffer
    public void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.pixel[i][j] = 0;
            }
        }
    }

    // draws x and y coordinates on the screen
    public void draw(int x, int y) {
        this.pixel[y][x] = 255;
    }
}
