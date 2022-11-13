package spaceinvaders.engine;

import spaceinvaders.graphics.SceneTemp;

/**
 * Class containing default values of in-game and meta-game 
 * variables and methods for resetting them
 */
public class Config {    
    /**
     * Game's running frame-rate in frames-per-second
     */
    private int frameRate;
    
    /**
     * Game's frame-time in milliseconds
     */
    private int frameTime;
    
    /**
     * Height of the swarm in units of alien
     */
    private int swarmHeight;
    
    /**
     * Width of the swarm in units of alien
     */
    private int swarmWidth;
    
    /**
     * Height of the game window
     */
    private int resHeight;
    
    /**
     * Width of the game window
     */
    private int resWidth;
    
    /**
     * Height of game grid
     */
    private int gameGridHeight;
    
    /**
     * Width of game grid
     */
    private int gameGridWidth;
    
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
        swarmHeight = 5;
        swarmWidth = 9;
        frameRate = 60;
        frameTime = 1000 / frameRate;
        resHeight = 600;
        resWidth = 400;
        gameGridHeight = 25;
        gameGridWidth = 20;
    }
    
    /**
     * Sets the frame-rate of the game
     * 
     * @throws IllegalArgumentException argument smaller than 1
     * @param frameRate game running frame-rate 
     * @return this
     */
    public Config setFrameRate(int frameRate) throws IllegalArgumentException {
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
     * Sets game resolution 
     * 
     * @param height y-axis number of pixels
     * @param width x-axis number of pixels
     * @return this
     * @throws IllegalArgumentException game objects don't fit in specified resolution
     */
    public Config setResolution(int height, int width) {  
        resHeight = height;
        resWidth = width;
        return this;
    }
    
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
    
    /**
     * Gets the height of the game window
     * 
     * @return resolution height
     */
    public int getResHeight() {
        return resHeight;
    }
    
    /**
     * Gets the height of the game window
     * 
     * @return resolution height
     */
    public int getResWidth() {
        return resWidth;
    }
    
    /**
     * Gets the height of the game grid
     * 
     * @return game grid height
     */
    public int getGameGridHeight() {
        return gameGridHeight;
    }
    
    /**
     * Gets the width of the game grid
     * 
     * @return game grid width
     */
    public int getGameGridWidth() {
        return gameGridWidth;
    }
}
