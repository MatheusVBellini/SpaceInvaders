package spaceinvaders.engine;

// internal imports
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.graphics.SceneTemp;
import spaceinvaders.game_objects.*;
import spaceinvaders.graphics.TitleScreen;

/**
 *  Class that contains all the event handling necessary for the game
 */
public class GameEngine {
    /**
     * Configuration class composed into the GameEngine
     */
    private final Config config;
    
    /**
     * StateHandler class composed into the GameEngine
     */
    private StateHandler stateHandler;
    
    /**
     * SceneTemp class for printing the game UI
     */
    private SceneTemp gameScene;
    
    /**
     * GameObjectCollection for creating and removing GameObjects from the game
     */
    private GameObjectCollection gameObjectCollection;
    
    /**
     * Title screen FXMLoader
     */
    FXMLLoader titleScreenLoader;
    
    /**
     * Main game screen FXMLLoader
     */
    FXMLLoader gameScreenLoader;

    /**
     * Constructor that instantiates Config class attribute
     */
    public GameEngine() {
        config = new Config();
        titleScreenLoader = new FXMLLoader(getClass().getResource("../graphics/TitleScreen.fxml"));
        gameScreenLoader = new FXMLLoader(getClass().getResource("../graphics/TitleScreen.fxml"));
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
        gameScene = new SceneTemp();
        gameObjectCollection = new GameObjectCollection(config.getSwarmHeight(), config.getSwarmWidth());
        stateHandler = new StateHandler(config.getFrameRate(), gameObjectCollection);
        
        Cannon player = new Cannon(SceneTemp.getCenterX() , SceneTemp.getHeight() - 1);
        
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(player);
        
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() - 1, SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX(), SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() + 1, SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() - 9 * GameObject.getHitboxWidth() - 1, SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() - 9 * GameObject.getHitboxWidth(), SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() - 9 * GameObject.getHitboxWidth() + 1, SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() + 9 * GameObject.getHitboxWidth() - 1, SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() + 9 * GameObject.getHitboxWidth(), SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTemp.getCenterX() + 9 * GameObject.getHitboxWidth() + 1, SceneTemp.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new SpaceShip(0, 1));
    }
    
    /**
     * Main game loop
     * 
     * <p>
     *  Responsible for coordinating gameplay sequentiality, such as 
     *  calling the graphical renderer and calling the stateHandler to update and verify runtime hazards
     * </p>
     * 
     * @throws InterruptedException thread was interrupted
     */
    private void gameLoop() {
        boolean breakLoop = false;
        int dt = 0;
        while (!breakLoop) {
            // start time counting
            long start = System.currentTimeMillis();

            // process input
            
            
            // render
            gameScene.render(gameObjectCollection);
            
            // update
            stateHandler.updateCollection(gameObjectCollection, dt);
            
            // hazards check
            stateHandler.checkHazards(gameObjectCollection);
            
            // fatal hazards check
            switch (stateHandler.checkFatalHazards(gameObjectCollection)) {
                case 1:
                    breakLoop = true;
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
     * Used to initiate the main game
     * 
     * <p>
     *  Guarantees that the loadGame method is called before the gameLoop method
     * </p>
     * 
     * @deprecated 
     */
    public void initGame() {
        loadGame();
        gameLoop();
    }
    
    /**
     * Used to initiate the game in the title screen
     * 
     * @throws IOException
     * @return title screen scene to be staged
     */
    public TitleScreen startGUI() throws IOException {
        // initializing scene components
        TitleScreen scene = new TitleScreen(titleScreenLoader);

        // listens to keyboard commands
        scene.listenToKey();
        
        return scene;
    }
}
