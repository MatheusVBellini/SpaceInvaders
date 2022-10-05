package spaceinvaders.engine.graphics;

public class ScreenMap {
    /*
     * 
     * Attributes
     * 
     */
    private static FrameBuffer currentFrame;
    private static FrameBuffer nextFrame;

    /*
     * 
     * Methods
     * 
     */
    // getters
    public static FrameBuffer getCurrentFrame() {
        return ScreenMap.currentFrame;
    }

    public static FrameBuffer getNextFrame() {
        return ScreenMap.nextFrame;
    }
}
