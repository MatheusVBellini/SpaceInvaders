package spaceinvaders.game_objects;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Collection of game elements (GameObjects, Swarm)
 */
public class GameObjectCollection {
    /**
     * HashMap containing all collection attributes
     */
    private HashMap<String,? extends Updatable> gameObjectMap;
    
    /**
     * Cannon that the player controls
     */
    private Cannon cannon;
    
    /**
     * Special space ship in the game
     */
    private SpaceShip spaceShip;
    
    /**
     * Game barricades
     */
    private LinkedList<BarricadeBlock> barricadeBlocks;
    
    /**
     * Projectiles shot by the cannon
     */
    private LinkedList<ProjectileAlly> cannonShots;
    
    /**
     * Projectiles shot by the aliens
     */
    private LinkedList<ProjectileEnemy> alienShots;
    
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
        barricadeBlocks = new LinkedList<>();
        cannonShots = new LinkedList<>();
        alienShots = new LinkedList<>();
        aliens = new Swarm(swarmHeight,swarmWidth);
    }
    
    /**
     * Instantiates a cannon in the collection
     * 
     * @param cannon 
     */
    public void add(Cannon cannon) {
        this.cannon = cannon;
    }
    
    /**
     * Instantiates a space ship in the collection
     * 
     * @param spaceShip
     */
    public void add(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }
    
    /**
     * Instantiates a barricade block in the collection
     * 
     * @param barricadeBlock
     */
    public void add(BarricadeBlock barricadeBlock) {
        barricadeBlocks.add(barricadeBlock);
    }
    
    /**
     * Instantiates an enemy projectile in the collection
     * 
     * @param projectile
     */
    public void add(ProjectileEnemy projectile) {
        alienShots.add(projectile);
    }
    
    /**
     * Instantiates an ally projectile in the collection
     * 
     * @param projectile
     */
    public void add(ProjectileAlly projectile) {
        cannonShots.add(projectile);
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
        return spaceShip;
    }
}
