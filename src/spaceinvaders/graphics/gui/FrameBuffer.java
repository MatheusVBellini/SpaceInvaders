package spaceinvaders.graphics.gui;

public class FrameBuffer {
    /*
    *
    * Attributes
    *
    */
    private int height;
    private int width;
    private int pixel[][];

    /*
    *
    * Methods
    *
    */
    // constructor
    FrameBuffer(int width, int height) {
        this.height = height;
        this.width = width;
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
