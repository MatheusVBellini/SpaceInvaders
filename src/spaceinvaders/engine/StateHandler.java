package spaceinvaders.engine;

import spaceinvaders.game_objects.*;

public class StateHandler {
    private int alienUpdateRate;
    private int alienUpdateCounter;
    
    public StateHandler(int frameRate, GameObjectCollection gameObjectCollection) {
        alienUpdateRate = frameRate / gameObjectCollection.getAliens().getSpeed();
        alienUpdateCounter = 0;
    }
    
    public void updateCollection(GameObjectCollection gameObjectCollection, int dt) {
        gameObjectCollection.getAllies().forEach(gameObject -> gameObject.update());
        if (dt == alienUpdateRate * alienUpdateCounter) {
            gameObjectCollection.getAliens().update();
            alienUpdateCounter = (alienUpdateCounter + 1) % gameObjectCollection.getAliens().getSpeed();
        }
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
