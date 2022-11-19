package spaceinvaders.game_objects;

import java.util.LinkedList;

/**
 * Collection of game elements (GameObjects, Swarm)
 */
public class GameObjectCollection {
    /**
     * List of non-enemies (Cannon, Spaceship, Barricade)
     */
    private LinkedList<GameObject> allies;
    
    /**
     * List of all projectiles
     */
    private LinkedList<GameObject> projectiles;
    
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
        projectiles = new LinkedList<>();
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
     * Adds projectile to the projectile linked list
     * 
     * @param projectile projectile to be added
     */
    public void add(Projectile projectile) {
        projectiles.add(projectile);
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
     * Get the list of projectiles
     * 
     * @return list of projectiles
     */
    public LinkedList<GameObject> getProjectiles() {
        return projectiles;
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
     * Set the swarm once emptied
     */
    public void setAliens(Swarm swarm) {
        this.aliens = swarm;
    }
    
    /**
     * Get a specific GameObject in the gameObjectCollection
     * 
     * @param c class of the sought object
     * @return GameObject in gameObjectCollection or null pointer 
     * if it does not exist
     */
    public GameObject getGameObject(Class c) {
        for (GameObject gameObject : this.allies) {
            if (gameObject.getClass().equals(c)) {
                return gameObject;
            }
        }
        
        return null;
    }
}
