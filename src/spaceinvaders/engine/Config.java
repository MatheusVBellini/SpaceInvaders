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
        swarmHeight = 4;
        swarmWidth = 5;
        frameRate = 60;
        frameTime = 1000 / frameRate;
    }
    
    public Config setFrameRate(long frameRate) {
        if (frameRate < 1) {
            throw new IllegalArgumentException("Framerate must be a positive integer value.");
        }
        
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
        int minResBySwarm = swarmWidth + 2 * (swarmWidth - 1) + 3;
        if (width < minResBySwarm) {
            if (minResBySwarm < 16) {
                throw new IllegalArgumentException("Unable to render UI, please enter a resolution width greater than 15.");
            }
            throw new IllegalArgumentException("Swarm not able to render, please enter a resolution width greater than " + (minResBySwarm-1) + ".");
        } else if (width < 16) {
            throw new IllegalArgumentException("Unable to render UI, please enter a resolution width greater than 15.");
        } 
        
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
