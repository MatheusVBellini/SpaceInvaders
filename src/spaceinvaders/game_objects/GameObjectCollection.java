package spaceinvaders.game_objects;

import java.util.ArrayList;

public class GameObjectCollection {
    private ArrayList<GameObject> allies;
    private Swarm aliens;
    
    public GameObjectCollection(int swarmHeight, int swarmWidth) {
        allies = new ArrayList<>();
        aliens = new Swarm(swarmHeight,swarmWidth);
    }
    
    public void add(GameObject gameObject) {
        allies.add(gameObject);
    }
    
    public ArrayList<GameObject> getAllies() {
        return allies;
    }
    
    public Swarm getAliens() {
        return aliens;
    }
    
    public Barricade getFirstBarricade() {
        for (GameObject ally : allies) {
            if (ally instanceof Barricade) {
                return ((Barricade)ally).copy();
            }
        }
        
        return new Barricade(-1,-1);
    }
}
