package spaceinvaders.engine;

// internal imports
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.graphics.Scene;
import spaceinvaders.game_objects.*;

/**
 *  Class that contains all the event handling necessary for the game
 */
public class GameEngine {
    /**
     * Configuration class composed into the GameEngine
     */
    private Config config;
    
    /**
     * StateHandler class composed into the GameEngine
     */
    private StateHandler stateHandler;
    
    /**
     * Scene class for printing the game UI
     */
    private Scene gameScene;
    
    /**
     * GameObjectCollection for creating and removing GameObjects from the game
     */
    private GameObjectCollection gameObjectCollection;

    /**
     * Constructor that instantiates Config class attribute
     */
    public GameEngine() {
        config = new Config();
    }
    
    /**
     * Returns the config class attribute for settings reconfiguration 
     * with the dot (.) method access operator
     * 
     * @return Config class attribute
     */
    public Config settings() {
        return config;
    }
    
    /**
     * Instantiates Scene class, GameobjectCollection class and StateHandler class
     * 
     * <p>
     * Also fills GameObjectCollection with a Cannon and Barricades
     * </p>
     */
    private void loadGame() {
        gameScene = new Scene();
        gameObjectCollection = new GameObjectCollection(config.getSwarmHeight(), config.getSwarmWidth());
        stateHandler = new StateHandler(config.getFrameRate(), gameObjectCollection);
        
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(new Cannon(Scene.getCenterX() , Scene.getHeight() - 1));
        
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 6 * GameObject.getHitboxWidth() - 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 6 * GameObject.getHitboxWidth(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 6 * GameObject.getHitboxWidth() + 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 6 * GameObject.getHitboxWidth() - 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 6 * GameObject.getHitboxWidth(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 6 * GameObject.getHitboxWidth() + 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
    }
    
    /**
     * Main game loop
     * 
     * <p>
     *  Responsible for coordinating gameplay's sequentiality, such as 
     *  calling the graphical renderer and calling the stateHandler to update and verify runtime hazards
     * </p>
     */
    private void gameLoop() {
        boolean breakLoop = false;
        int dt = 0;
        while (!breakLoop) {
            // start time counting
            long start = System.currentTimeMillis();

            // processInput()
            // render
            gameScene.render(gameObjectCollection);
            // update
            stateHandler.updateCollection(gameObjectCollection, dt);
            // collision check
            switch (stateHandler.checkHazards(gameObjectCollection)) {
                case 1 -> breakLoop = true;
            }
            
            // reset dt after 1 second
            dt++;
            dt = dt % config.getFrameRate();

            // wait the correct amount of time for the cycle to end
            try {
                Thread.sleep(config.getFrameTime() + start - System.currentTimeMillis());
            } catch (IllegalArgumentException ex) {
                // do nothing -- framerate lower than expected
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
            }
        }
    }
    
    /**
     * Used to initate the main game
     * 
     * <p>
     *  Guarantees that the loadGame method is called before the gameLoop method
     * </p>
     */
    public void initGame() {
        loadGame();
        gameLoop();
    }
}
