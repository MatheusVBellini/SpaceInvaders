package spaceinvaders.game_objects;

import java.util.LinkedList;

/**
 * Collection of game elements (GameObjects, Swarm)
 */
public class GameObjectCollection {
    /**
     * List of non-enemies (Cannon, Spaceship, Barricade, Projectile)
     */
    private LinkedList<GameObject> allies;
    
    /**
     * Collection of enemies defined within the Swarm class
     */
    private Swarm aliens;
    
    /**
     * Define initial parameters to be followed when 
     * instantiating the GameObjectColection
     * 
     * @param swarmHeight height of the swarm of aliens of the game
     * @param swarmWidth width of the swarm of aliens of the game
     */
    public GameObjectCollection(int swarmHeight, int swarmWidth) {
        allies = new LinkedList<>();
        aliens = new Swarm(swarmHeight,swarmWidth);
    }
    
    /**
     * General method for adding objects to collections
     * 
     * @param gameObject object to be added
     */
    public void add(GameObject gameObject) {
        allies.add(gameObject);
    }
    
    /**
     * Get the list of non-enemy game objects
     * 
     * @return list of non-enemy game objects
     */
    public LinkedList<GameObject> getAllies() {
        return allies;
    }
    
    /**
     * Get the object containing game enemies
     * 
     * @return  object containing game enemies
     */
    public Swarm getAliens() {
        return aliens;
    }
    
    /**
     * Get the space ship in the gameObjectCollection
     * 
     * @return space ship in gameObjectCollection or null pointer 
     * if it does not exist
     */
    public GameObject getSpaceShip() {
        for (GameObject gameObject : this.allies) {
            if (gameObject instanceof SpaceShip) {
                return gameObject;
            }
        }
        
        return null;
    }
}
