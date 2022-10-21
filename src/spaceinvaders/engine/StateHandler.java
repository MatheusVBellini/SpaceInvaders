package spaceinvaders.engine;

import spaceinvaders.game_objects.*;
import java.util.ArrayList;

public class StateHandler {
    public void updateCollection(ArrayList<GameObject> gameObjectColletion) {
        gameObjectColletion.forEach(gameObject -> gameObject.update());
    }
    
    public void updateSwarm(Swarm swarm) {
        swarm.update();
    }

}
