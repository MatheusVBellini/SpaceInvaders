package spaceinvaders.game_objects;

import java.util.ArrayList;

/**
 *
 * @author matheusbellini
 */
public class GameObjectCollection {
    /**
     * 
     */
    private ArrayList<GameObject> allies;
    
    /**
     * 
     */
    private Swarm aliens;
    
    /**
     * 
     * @param swarmHeight
     * @param swarmWidth
     */
    public GameObjectCollection(int swarmHeight, int swarmWidth) {
        allies = new ArrayList<>();
        aliens = new Swarm(swarmHeight,swarmWidth);
    }
    
    /**
     * 
     * @param gameObject
     * @param gameObject
     */
    public void add(GameObject gameObject) {
        allies.add(gameObject);
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<GameObject> getAllies() {
        return allies;
    }
    
    /**
     * 
     * @return 
     * @return  
     */
    public Swarm getAliens() {
        return aliens;
    }
}
