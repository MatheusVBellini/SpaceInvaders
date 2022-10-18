package spaceinvaders.graphics.gui;

public class ScreenMap {
    /*
     * 
     * Attributes
     * 
     */
    private FrameBuffer currentFrame;
    private FrameBuffer nextFrame;

    /*
     * 
     * Methods
     * 
     */
    // constructor
    public ScreenMap(int width, int height) {
        currentFrame = new FrameBuffer(width, height);
        nextFrame = new FrameBuffer(width, height);
    }

    // getters
    public FrameBuffer getCurrentFrame() {
        return this.currentFrame;
    }

    public FrameBuffer getNextFrame() {
        return this.nextFrame;
    }
}
