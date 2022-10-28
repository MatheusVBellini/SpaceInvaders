package spaceinvaders.engine;

import spaceinvaders.game_objects.*;
import spaceinvaders.graphics.Scene;

/**
 * Class responsible for updating and verifying hazards and collision between GameObjects
 */
public class StateHandler {
    /**
     * rate of updates to be done on the swarm based on its speed
     */
    private int alienUpdateRate;
    
    /**
     * counter to keep track of how many times the swarm has moved in the second
     */
    private int alienUpdateCounter;
    
    /**
     * Defines values of StateHandler attributes
     * 
     * @param frameRate game's frame-rate
     * @param gameObjectCollection instantiated GameObjectCollection
     */
    public StateHandler(int frameRate, GameObjectCollection gameObjectCollection) {
        alienUpdateRate = frameRate / gameObjectCollection.getAliens().getSpeed();
        alienUpdateCounter = 0;
    }
    
    /**
     * Calls GameObject update methods at the correct moment in time
     * 
     * @param gameObjectCollection instantiated GameObjectCollection
     * @param dt frame in which the method access was made
     */
    public void updateCollection(GameObjectCollection gameObjectCollection, int dt) {
        gameObjectCollection.getAllies().forEach(gameObject -> gameObject.update());
        if (dt == alienUpdateRate * alienUpdateCounter) {
            gameObjectCollection.getAliens().update();
            alienUpdateCounter = (alienUpdateCounter + 1) % gameObjectCollection.getAliens().getSpeed();
        }
    }
    
            
    /**
     * Responsible for handling possible runtime and gameplay hazards
     * 
     * <p>
     * <strong>Hazard codification</strong>
     * </p>
     * 
     * 
     * <ul>
     *  <li><strong><i>Code    --    Type of Hazard     --    Solution</i></strong></li>
     *  <li> 0 --           no hazard           -- continue</li>
     *  <li> 1 -- swarm collided with barricade -- end game</li>
     * </ul>
     * 
     * 
     * @param gameobjectCollection instantiated GameObjects that need to be verified 
     * @return hazard codification
    */
    public int checkHazards(GameObjectCollection gameobjectCollection) {
        if (swarmCourseComplete(gameobjectCollection)) {
            return 1;
        }
        
        return 0;
    }
    
    /**
     * Checks if swarm has completed its course
     * 
     * <p>
     *  if it did, end game, continue otherwise
     * </p>
     * 
     * @param gameobjectCollection instantiated GameObjects in order to access the swarm
     * @return boolean specifying whether the course is complete
     */
    private boolean swarmCourseComplete(GameObjectCollection gameObjectCollection) {
        int y = Scene.getHeight() - GameObject.getHitboxHeight() - 3;
        for (GameObject alien : gameObjectCollection.getAliens().getArrayOfAliens()) {
            if (alien.getY() + GameObject.getHitboxHeight() - 1 == y) {
                return true; 
            }
        }
        
        return false;
    }
}