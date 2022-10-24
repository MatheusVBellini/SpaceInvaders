package spaceinvaders.engine;

import spaceinvaders.game_objects.*;

public class StateHandler {
    private int alienMovesPerSec;
    
    public StateHandler(GameObjectCollection gameObjectCollection) {
        alienMovesPerSec = gameObjectCollection.getAliens().getSpeed();
    }
    
    public void updateCollection(GameObjectCollection gameObjectCollection) {
        gameObjectCollection.getAllies().forEach(gameObject -> gameObject.update());
        if (alienMovesPerSec > 0) {
            gameObjectCollection.getAliens().update();
            alienMovesPerSec--;
        }
    }
    
    public void resetSpeedStates(GameObjectCollection gameObjectCollection) {
        alienMovesPerSec = gameObjectCollection.getAliens().getSpeed();
    }
            
    /* Hazard codification
    *  Code          Type of Hazard           Solution
    *   0 --           no hazard           -- continue
    *   1 -- swarm collided with barricade -- end game
    */
    public int checkHazards(GameObjectCollection gameobjectCollection) {
        if (swarmCourseComplete(gameobjectCollection)) {
            return 1;
        }
        
        return 0;
    }
    
    private boolean swarmCourseComplete(GameObjectCollection gameObjectCollection) {
        int y = gameObjectCollection.getFirstBarricade().getY();
        for (GameObject alien : gameObjectCollection.getAliens().getArrayOfAliens()) {
            if (alien.getY() + GameObject.getHitboxHeight() - 1 == y) {
                return true; 
            }
        }
        
        return false;
    }
}
