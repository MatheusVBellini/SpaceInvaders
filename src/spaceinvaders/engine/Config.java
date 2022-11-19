package spaceinvaders.engine;


/**
 * Class containing default values of in-game and meta-game 
 * variables and methods for resetting them
 */
public class Config {    
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
     * Constructor that instantiate variables with default values
     * 
     * <p><strong>Default values:</strong></p>
     *  <ul>
     *      <li>Height of the swarm = 5 aliens</li>
     *      <li>Width of the swarm = 9 aliens</li>
     *      <li>Window resolution height = 600</li>
     *      <li>Window resolution width = 500</li>
     *  </ul> 
     */
    public Config() {
        swarmHeight = 5;
        swarmWidth = 9;
        resHeight = 600;
        resWidth = 500;
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
   
}
