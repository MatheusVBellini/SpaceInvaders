package spaceinvaders.engine;

import java.util.LinkedList;
import java.util.Stack;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import spaceinvaders.game_objects.*;
import spaceinvaders.graphics.sprite.AlienSprite1;
import spaceinvaders.graphics.sprite.AlienSprite2;
import spaceinvaders.graphics.sprite.AlienSprite3;

/**
 * Class responsible for updating and verifying hazards and collision between GameObjects
 */
public class StateHandler {       
    /**
     * Calls GameObject update methods at the correct moment in time
     * and guarantees frame-rate agnostic game speed
     * 
     * @param gameObjectCollection instantiated GameObjectCollection
     */
    public void updateCollection(GameObjectCollection gameObjectCollection) {
        
        gameObjectCollection.getAllies().forEach(gameObject -> gameObject.update());
        gameObjectCollection.getProjectiles().forEach(projectile -> projectile.update());
        gameObjectCollection.getAliens().update();
        
    }
    
    
    /**
     * Detect non-fatal hazards, such as collisions
     * 
     * @param graphicalObjects
     * @param gameObjectCollection all instantiated game objects
     */
    public void checkHazards(ObservableList<Node> graphicalObjects, GameObjectCollection gameObjectCollection) {
        cannonShoot(graphicalObjects, gameObjectCollection); // checks if cannon has requested to shoot
        alienShoot(graphicalObjects, gameObjectCollection); // checks if any alien has requested to shoot
        projectileCollisions(gameObjectCollection); // Check if a projectile has hit a GameObject
        spaceShipCourseComplete(gameObjectCollection); // check spaceship course completion
        projectileCourseComplete(gameObjectCollection); // check projectiles course completion
        collectCorpses(graphicalObjects, gameObjectCollection); // removes dead GameObjects
    }
    
    /**
     * Collision between spaceship and end of the screen
     */
    private void spaceShipCourseComplete(GameObjectCollection gameObjectCollection) {
        SpaceShip spaceShip = (SpaceShip)gameObjectCollection.getGameObject(SpaceShip.class);
        
        if (spaceShip != null && spaceShip.getX() == GameEngine.settings().getResWidth()) {
            spaceShip.takeDamage();
        }
    }
    
    /**
     * Checks if shoot flag is activated in the cannon, if so, instantiates 
     * an ally projectile and turn the flag off
     * 
     * @param graphicalObjects 
     * @param gameObjectCollection
     */
    private void cannonShoot(ObservableList<Node> graphicalObjects, GameObjectCollection gameObjectCollection) {
        Cannon cannon = (Cannon)gameObjectCollection.getGameObject(Cannon.class);
        if (cannon.hasShot()) {
            ProjectileAlly projectile = new ProjectileAlly(
                                                cannon.getX() + GameObject.getGameObjectWidth()/2 - 2, 
                                                cannon.getY() - GameObject.getGameObjectHeight() - 4
                                        );
            projectile.getSprite().getImage().setTranslateX(projectile.getX());
            projectile.getSprite().getImage().setTranslateY(projectile.getY());
            
            gameObjectCollection.add(projectile);
            graphicalObjects.add(projectile.getSprite().getImage());
            cannon.recoil();
        }
    }
    
    
    /**
     * Checks if shoot flag is activated in any of the aliens, if so, instantiates 
     * an enemy projectile and turn the flag off
     * 
     * @param graphicalObjects
     * @param gameObjectCollection
     */
    private void alienShoot(ObservableList<Node> graphicalObjects, GameObjectCollection gameObjectCollection) {
        for (GameObject alien : gameObjectCollection.getAliens().getListOfAliens()) {
            
            // radomly shoots
            if (GameEngine.getNextRandInt(10000) == 1) {
                ((Alien)alien).shoot();
            }
            
            if (((Alien)alien).hasShot()) {
                ProjectileEnemy projectile = new ProjectileEnemy(
                                                    alien.getX() + GameObject.getGameObjectWidth()/2 - 2, 
                                                    alien.getY() + GameObject.getGameObjectHeight() + 4
                                            );
                projectile.getSprite().getImage().setTranslateX(projectile.getX());
                projectile.getSprite().getImage().setTranslateY(projectile.getY());

                gameObjectCollection.add(projectile);
                graphicalObjects.add(projectile.getSprite().getImage());
                ((Alien)alien).recoil();
            }
        }
    }
    
    /**
     * Check collisions between GameObjects and Projectiles
     */
    private void projectileCollisions(GameObjectCollection gameObjectCollection) {
        LinkedList<GameObject> aliens = gameObjectCollection.getAliens().getListOfAliens();
        LinkedList<GameObject> allies = gameObjectCollection.getAllies();
        LinkedList<GameObject> projectiles = gameObjectCollection.getProjectiles();
        
        for (GameObject projectile : projectiles) {
            // if pointer is null, proceed to next component of the list
            if (projectile == null) {
                continue;
            }
            
            if (projectile instanceof ProjectileAlly) {
                // collision with aliens
                for (GameObject alien : aliens) {
                    if (alien.getSprite()
                             .getImage()
                             .getBoundsInParent()
                             .intersects(projectile.getSprite().getImage().getBoundsInParent())
                        ) {
                        alien.takeDamage();
                        projectile.takeDamage();
                    }
                }      
            }
            
            // rest of the possible collisions
            for (GameObject ally : allies) {
                if (ally.getSprite()
                             .getImage()
                             .getBoundsInParent()
                             .intersects(projectile.getSprite().getImage().getBoundsInParent())
                        ) {
                    ally.takeDamage();
                    projectile.takeDamage();
                    
                    // increases the score for hitting the SpaceShip
                    if (ally.getClass().equals(SpaceShip.class)) {
                        GameEngine.increaseScore(50);
                    }
                }
            }
            
        }
    }
    
    /**
     * Check if projectiles hit screen boundries
     */
    private void projectileCourseComplete(GameObjectCollection gameObjectCollection) {
        LinkedList<GameObject> projectiles = gameObjectCollection.getProjectiles();
        for (GameObject projectile : projectiles) {
            if (projectile instanceof ProjectileAlly && projectile.getY() - 1 < 0) {
                projectile.takeDamage();
            } 
            if (projectile instanceof ProjectileEnemy && projectile.getY() >= GameEngine.settings().getResHeight()) {
                projectile.takeDamage();
            }
        }
    }
    
    /**
     * Check if any alien, projectile, barricade or spaceship is dead
     * 
     * @param gameObjectCollection
     */
    private void collectCorpses(ObservableList<Node> graphicalObjects, GameObjectCollection gameObjectCollection) {
        Stack<GameObject> corpses = new Stack<>();
        GameObject tmp;
        
        // check if any aliens are dead
        LinkedList<GameObject> list = gameObjectCollection.getAliens().getListOfAliens();
        for (GameObject alien : list) {
            if (alien.isDead()) {
                corpses.push(alien);
            }
        }
        
        while (!corpses.empty()) {
            tmp = corpses.pop();
            list.remove(tmp);
            graphicalObjects.remove(tmp.getSprite().getImage());
            
            // selects the correct score according to the type of alien
            if (tmp.getSprite().getClass().equals(AlienSprite1.class)) {
                GameEngine.increaseScore(10);
            }
            if (tmp.getSprite().getClass().equals(AlienSprite2.class)) {
                GameEngine.increaseScore(20);
            }
            if (tmp.getSprite().getClass().equals(AlienSprite3.class)) {
                GameEngine.increaseScore(30);
            }
            
        }
        
        // check for dead spaceship and barricades
        list = gameObjectCollection.getAllies();
        for (GameObject ally : list) {
            if (ally.isDead() && !(ally instanceof Cannon)) {
                corpses.push(ally);
            }
        }
        
        while (!corpses.empty()) {
            tmp = corpses.pop();
            list.remove(tmp);
            graphicalObjects.remove(tmp.getSprite().getImage());
        }
        
        // check for collided projectiles
        list = gameObjectCollection.getProjectiles();
        for (GameObject projectile : list) {
            if (projectile.isDead()) {
                corpses.push(projectile);
                
                // player can shoot again
                if (projectile instanceof ProjectileAlly) {
                    Cannon player = (Cannon)GameEngine.getGameObjectCollection().getGameObject(Cannon.class);
                    player.hit();
                }
            }
        }
        
        while (!corpses.empty()) {
            tmp = corpses.pop();
            list.remove(tmp);
            graphicalObjects.remove(tmp.getSprite().getImage());
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
     *  <tr>
     *      <td>1</td>
     *      <td>player lost all its lives</td>
     *      <td>end game</td>
     *  </tr>
     * </table>
     * 
     * @param gameObjectCollection instantiated GameObjects that need to be verified 
     * @return hazard codification
    */
    public int checkFatalHazards(GameObjectCollection gameObjectCollection) {
        if (swarmCourseComplete(gameObjectCollection.getAliens())) { return 1; }
        if (playerIsDead()) { return 1; }
        
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
        int y = GameEngine.settings().getResHeight() - GameObject.getGameObjectHeight() * 4;
        
        return swarm.getListOfAliens().getLast().getY() >= y;
    }
    
    /**
     * Checks if has already lost all its lives
     * 
     * <p>
     *  if it did, end game, continue otherwise
     * </p>
     * 
     * @return boolean specifying whether the player is dead
     */
    private boolean playerIsDead() {
        Cannon player = (Cannon)GameEngine.getGameObjectCollection().getGameObject(Cannon.class);
        return player.isDead();
    }
}