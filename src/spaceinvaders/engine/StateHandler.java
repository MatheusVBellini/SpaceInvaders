package spaceinvaders.engine;

import java.util.LinkedList;
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
     * rate of updates to be done on the gameObjects based on their general speed
     */
    private int gameObjectsUpdateRate;
    
    /**
     * counter to keep track of how many times the gameObjects have moved in the second
     */
    private int gameObjectsUpdateCounter;
    
    /**
     * Defines values of StateHandler attributes
     * 
     * @param frameRate game's frame-rate
     * @param gameObjectCollection instantiated GameObjectCollection
     */
    public StateHandler(int frameRate, GameObjectCollection gameObjectCollection) {
        alienUpdateRate = frameRate / gameObjectCollection.getAliens().getSpeed();
        alienUpdateCounter = 0;
        gameObjectsUpdateRate = frameRate / GameObject.getSpeed();
        gameObjectsUpdateCounter = 0;
    }
    
    /**
     * Calls GameObject update methods at the correct moment in time
     * and guarantees frame-rate agnostic game speed
     * 
     * @param gameObjectCollection instantiated GameObjectCollection
     * @param dt frame in which the method access was made
     */
    public void updateCollection(GameObjectCollection gameObjectCollection, int dt) {
        // ensures that gameObjects are updated (speed) times per second
        if (dt == gameObjectsUpdateRate * gameObjectsUpdateCounter) {
            gameObjectCollection.getAllies().forEach(gameObject -> gameObject.update());
            gameObjectCollection.getProjectiles().forEach(projectile -> projectile.update());
            gameObjectsUpdateCounter = (gameObjectsUpdateCounter + 1) % GameObject.getSpeed();
        }
        
        // ensures that aliens are updated (speed) times per second
        if (dt == alienUpdateRate * alienUpdateCounter) {
            gameObjectCollection.getAliens().update();
            alienUpdateCounter = (alienUpdateCounter + 1) % gameObjectCollection.getAliens().getSpeed();
        }
    }
    
    
    /**
     * Detect non-fatal hazards, such as collisions
     * 
     * @param gameObjectCollection all instantiated game objects
     */
    public void checkHazards(GameObjectCollection gameObjectCollection) {
        spaceShipCourseComplete(gameObjectCollection);
        cannonShoot(gameObjectCollection);
        kills(gameObjectCollection);
    }
    
    /**
     * Collision between spaceship and end of the screen
     */
    private void spaceShipCourseComplete(GameObjectCollection gameObjectCollection) {
        SpaceShip tmp = new SpaceShip(0,0);
        SpaceShip spaceShip = (SpaceShip)gameObjectCollection.getGameObject(tmp.getClass());
        
        if (spaceShip != null && spaceShip.getPivotX() + (GameObject.getHitboxWidth() / 2) == Scene.getWidth()) {
            spaceShip.takeDamage();
        }
    }
    
    /**
     * Checks if shoot flag is activated in the cannon, if so, instantiates 
     * an ally projectile and turn the flag off
     * 
     * @param gameObjectCollection
     */
    private void cannonShoot(GameObjectCollection gameObjectCollection) {
        Cannon tmp = new Cannon(0,0);
        Cannon cannon = (Cannon)gameObjectCollection.getGameObject(tmp.getClass());
        if (cannon.hasShot()) {
            gameObjectCollection.add(
                    new ProjectileAlly(
                            cannon.getPivotX(), 
                            cannon.getPivotY() - GameObject.getHitboxHeight()
                    ));
            cannon.reload();
        }
    }
    
    /**
     * Check if any alien, projectile, barricade or spaceship is dead
     * 
     * @param gameObjectCollection
     */
    private void kills(GameObjectCollection gameObjectCollection) {
        // check if any aliens are dead
        LinkedList<GameObject> list = gameObjectCollection.getAliens().getListOfAliens();
        for (GameObject alien : list) {
            if (alien.isDead()) {
                list.remove(alien);
            }
        }
        
        // check for dead spaceship and barricades
        list = gameObjectCollection.getAllies();
        for (GameObject ally : list) {
            if (ally.isDead()) {
                list.remove(ally);
            }
        }
        
        // check for collided projectiles
        list = gameObjectCollection.getProjectiles();
        for (GameObject projectile : list) {
            if (projectile.isDead()) {
                list.remove(projectile);
            }
        }
    }
    
    /**
     * Responsible for detecting possible runtime and gameplay fatal hazards
     * 
     * <p>
     * <strong>Fatal Hazard codification</strong>
     * </p>
     * 
     * <table>
     * <caption>Hazard Codification</caption>
     *  <tr>
     *      <th>Code</th>
     *      <th>Type of Hazard</th>
     *      <th>Solution</th>
     *  </tr>
     *  <tr>
     *      <td>0</td>
     *      <td>no hazard</td>
     *      <td>continue</td>
     *  </tr>
     *  <tr>
     *      <td>1</td>
     *      <td>swarm collided with barricade</td>
     *      <td>end game</td>
     *  </tr>
     * </table>
     * 
     * @param gameObjectCollection instantiated GameObjects that need to be verified 
     * @return hazard codification
    */
    public int checkFatalHazards(GameObjectCollection gameObjectCollection) {
        if (swarmCourseComplete(gameObjectCollection.getAliens())) {
            return 1;
        }
        
        return 0;
    }
    
    
    /**
     * Checks if swarm has completed its course, that is, if any alien has hit 
     * a barricade
     * 
     * <p>
     *  if it did, end game, continue otherwise
     * </p>
     * 
     * @param swarm Game's current swarm 
     * @return boolean specifying whether the course is complete
     */
    private boolean swarmCourseComplete(Swarm swarm) {
        int y = Scene.getHeight() - GameObject.getHitboxHeight() - 3;
        
        return swarm.getListOfAliens().getLast().getY() + GameObject.getHitboxHeight() - 1 == y;
    }
}