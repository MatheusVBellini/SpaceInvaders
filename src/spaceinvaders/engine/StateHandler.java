package spaceinvaders.engine;

import spaceinvaders.game_objects.*;
import java.util.ArrayList;

public class StateHandler {
    public void updateCollection(ArrayList<GameObject> gameObjectColletion) {
        // render default movement
        gameObjectColletion.forEach(gameObject -> gameObject.update());

        // treat collision
    }

}
