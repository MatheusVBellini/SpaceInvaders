package spaceinvaders.engine;

// internal imports
import java.io.IOException;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.game_objects.*;
import spaceinvaders.graphics.TitleScreen;

/**
 *  Game's centralized information class
 * 
 * <p> 
 *  Responsible for inner processes activation and 
 *  key information distribution across methods
 * </p>
 */
public class GameEngine {
    /**
     * Configuration class composed into the GameEngine
     */
    private static final Config config = new Config();
    
    /**
     * StateHandler class composed into the GameEngine
     */
    private static StateHandler stateHandler;
    
    /**
     * GameObjectCollection for creating and removing GameObjects from the game
     */
    private static GameObjectCollection gameObjectCollection;
    
    /**
     * Stage where every graphical object appears
     */
    private static Stage stage;
    
    /**
     * Title screen FXMLoader
     */
    private static FXMLLoader titleScreenLoader;
    
    /**
     * Main game screen FXMLLoader
     */
    private static FXMLLoader gameScreenLoader;
    
    /**
     * Game Over screen FXMLLoader
     */
    private static FXMLLoader gameOverScreenLoader;
    
    /**
     * Random stream to coordinate random events
     */
    private static final Random rand = new Random();
    
    /**
     * Get next random int
     * 
     * @param upperbound maximum value the random int can take
     * @return next int in the random stream 
     */
    public static int getNextRandInt(int upperbound) {
        return rand.nextInt(upperbound);
    }
    
    /**
     * Game score
     */
    private static int score = 0;

    /**
     * increase game score by x
     * @param x value which the score will be increased by
     */
    public static void increaseScore(int x) {
        score += x;
    }
    
    /**
     * Get score value
     * @return score value
     */
    public static int getScore() {
        return score;
    }
    
    /**
     * Saves titleScreenLoader for easy scene controller access
     * @param titleScreenLoader loader
     */
    public static void setTitleScreenLoader(FXMLLoader titleScreenLoader) {
        GameEngine.titleScreenLoader = titleScreenLoader;
    }
    
    /**
     * Saves gameScreenLoader for easy scene controller access
     * @param gameScreenLoader loader
     */
    public static void setGameScreenLoader(FXMLLoader gameScreenLoader) {
        GameEngine.gameScreenLoader = gameScreenLoader;
    }
    
    /**
     * Saves gameOverScreenLoader for easy scene controller access
     * @param gameOverScreenLoader loader
     */
    public static void setGameOverScreenLoader(FXMLLoader gameOverScreenLoader) {
        GameEngine.gameOverScreenLoader = gameOverScreenLoader;
    }
    
    /**
     * Saves stage for fast switch scene usage
     * @param stage stage
     */
    public static void setStage(Stage stage) {
        GameEngine.stage = stage;
    }
    
    /**
     * Get StateHandler
     * @return stateHandler
     */
    public static StateHandler getStateHandler() {
        return stateHandler;
    }
    
    /**
     * Get GameObjectCollection
     * @return gameObjectCollection
     */
    public static GameObjectCollection getGameObjectCollection() {
        return gameObjectCollection;
    }
    
    /**
     * Gets the stage in use for fast switch scene usage
     * @return stage
     */
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Returns the config class attribute for settings reconfiguration 
     * with the dot (.) method access operator
     * 
     * @return Config class attribute
     */
    public static Config settings() {
        return config;
    }
    
    /**
     * Returns the FXMLLoader for the main game
     * 
     * @return main game FXMLoader
     */
    public static FXMLLoader getGameScreenLoader() {
        return gameScreenLoader;
    }
    
    /**
     * Returns the FXMLLoader for the game over
     * 
     * @return main game FXMLoader
     */
    public static FXMLLoader getGameOverScreenLoader() {
        return gameOverScreenLoader;
    }
    
    /**
     * Returns the FXMLLoader for the title screen
     * 
     * @return title screen FXMLoader
     */
    public static FXMLLoader getTitleScreenLoader() {
        return titleScreenLoader;
    }
    
    /**
     * Instantiates GameObjectCollection class and StateHandler class
     * 
     * <p>
     * Also fills GameObjectCollection with a Cannon and Barricades
     * </p>
     */
    public static void loadGame() {
        gameObjectCollection = new GameObjectCollection(config.getSwarmHeight(), config.getSwarmWidth());
        stateHandler = new StateHandler();
        
        Cannon player = new Cannon(config.getResWidth() / 2 , config.getResHeight() - GameObject.getGameObjectHeight() + 4);
        
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(player);
        
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 - 5 * GameObject.getGameObjectWidth(), 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 - 6 * GameObject.getGameObjectWidth() - 2, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 - 7 * GameObject.getGameObjectWidth() - 4, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 + 5 * GameObject.getGameObjectWidth(), 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 + 6 * GameObject.getGameObjectWidth() + 2, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 + 7 * GameObject.getGameObjectWidth() + 4, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 + GameObject.getGameObjectWidth() + 2, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
        gameObjectCollection.add(new Barricade(
                config.getResWidth() / 2 - GameObject.getGameObjectWidth() - 2, 
                config.getResHeight() - 3 * GameObject.getGameObjectHeight()
        ));
     
    }
    
    /**
     * Replenish swarm when going to next level
     */
    public static void replenishSwarm() {
        gameObjectCollection.setAliens(new Swarm(config.getSwarmHeight(), config.getSwarmWidth()));
    }
    
    /**
     * Main game loop
     * 
     * <p>
     *  Responsible for coordinating gameplay sequentiality:
     * </p>
     * 
     * <ul>
     *      <li>Verifying fatal hazards</li>
     *      <li>Generating random elements</li>
     *      <li>Updating the GameObjects</li>
     *      <li>Verifying non-fatal hazards</li>
     * </ul>
     * 
     * 
     * @param graphicalObjects list containing all screen elements
     * @return fatal error code
     */
    public static int gameLoop(ObservableList<Node> graphicalObjects) {
        
        int hazardReturn = stateHandler.checkFatalHazards(gameObjectCollection);
        if (hazardReturn != 0) {
            return hazardReturn;
        }
        
        // tries to generate a SpaceShip
        if (rand.nextInt(1000) == 100) {
            SpaceShip tmp = new SpaceShip(0, 4 * GameObject.getGameObjectHeight());
            tmp.getSprite().getImage().setTranslateX(tmp.getX());
            tmp.getSprite().getImage().setTranslateY(tmp.getY());
            
            gameObjectCollection.add(tmp);
            graphicalObjects.add(tmp.getSprite().getImage());
        }
        
        // update
        stateHandler.updateCollection(gameObjectCollection);
        
        // hazards check
        stateHandler.checkHazards(graphicalObjects, gameObjectCollection);

        return 0;            
        
    }
        
    /**
     * Used to initiate the game in the title screen
     * 
     * @throws IOException error initiating process
     */
    public static void startGUI() throws IOException {
        // initializing scene components
        TitleScreen scene = new TitleScreen(titleScreenLoader);
        
        // listens to keyboard commands
        scene.listenToKey();
        
        stage.setScene(scene);
        stage.show();
    }
}
