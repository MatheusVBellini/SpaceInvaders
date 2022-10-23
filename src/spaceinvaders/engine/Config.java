package spaceinvaders.engine;

import spaceinvaders.graphics.Scene;

public class Config {
    /*
     *
     * Game Specs
     *
     */
    // constructor
    public Config() {
        swarmHeight = 3;
        swarmWidth = 5;
        frameRate = 60;
        frameTime = 1000 / frameRate;
    }
    
    public Config setFrameRate(long frameRate) {
        this.frameRate = frameRate;
        this.frameTime = 1000 / frameRate;
        return this;
    }
    
    public Config setSwarmSize(int height, int width) {
        this.swarmHeight = height;
        this.swarmWidth = width;
        return this;
    }
    
    public Config setResolution(int height, int width) {
        Scene.setHeight(height);
        Scene.setWidth(width);
        return this;
    }
    
    // frame rate infromation
    private long frameRate;
    private long frameTime;
    public long getFrameRate() {
        return frameRate;
    }
    public long getFrameTime() {
        return frameTime;
    }
    
    // swarm information
    private int swarmHeight;
    private int swarmWidth;
    public int getSwarmHeight() {
        return swarmHeight;
    }
    public int getSwarmWidth() {
        return swarmWidth;
    }
}
