package spaceinvaders.engine;

import spaceinvaders.graphics.Scene;

/**
 * Class containing default values of in-game and meta-game 
 * variables and methods for resetting them
 */
public class Config {    
    /**
     * Constructor that instantiate variables with default values
     * 
     * <p><strong>Default values:</strong></p>
     *  <ul>
     *      <li>Height of the swarm = 4 aliens</li>
     *      <li>Width of the swarm = 5 aliens</li>
     *      <li>Game's frame-rate = 60 fps</li>
     *      <li>Time spent in a frame = 16 ms</li>
     *  </ul> 
     */
    public Config() {
        swarmHeight = 4;
        swarmWidth = 5;
        frameRate = 60;
        frameTime = 1000 / frameRate;
    }
    
    /**
     * Sets the frame-rate of the game
     * 
     * @throws IllegalArgumentException argument smaller than 1
     * @param frameRate game's running frame-rate 
     * @return this
     */
    public Config setFrameRate(int frameRate) {
        if (frameRate < 1) {
            throw new IllegalArgumentException("Framerate must be a positive integer value.");
        }
        
        this.frameRate = frameRate;
        this.frameTime = 1000 / frameRate;
        return this;
    }
    
    /**
     * Sets the size of game's main swarm
     * 
     * @param height swarm height
     * @param width swarm width
     * @return this
     */
    public Config setSwarmSize(int height, int width) {
        this.swarmHeight = height;
        this.swarmWidth = width;
        return this;
    }
    
    /**
     * Sets game's resolution 
     * 
     * @param height y-axis number of pixels
     * @param width x-axis number of pixels
     * @return this
     */
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
    
    /**
     * Game's running frame-rate in frames-per-second
     */
    private int frameRate;
    
    /**
     * Game's frame-time in milliseconds
     */
    private int frameTime;
    
    /**
     * Gets the value of the game's set frame-rate in frames-per-second
     * 
     * @return frame-rate
     */
    public int getFrameRate() {
        return frameRate;
    }
    
    /**
     * Gets the value of the frame-tie in milliseconds
     * 
     * @return frame-time
     */
    public int getFrameTime() {
        return frameTime;
    }
    
    /**
     * Height of the swarm in units of alien
     */
    private int swarmHeight;
    
    /**
     * Width of the swarm in units of alien
     */
    private int swarmWidth;
    
    /**
     * Gets the height of the swarm in alien
     * 
     * @return swarm height
     */
    public int getSwarmHeight() {
        return swarmHeight;
    }
    
    /**
     * Gets the width of the swarm in alien
     * 
     * @return swarm width
     */
    public int getSwarmWidth() {
        return swarmWidth;
    }
}
