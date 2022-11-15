package spaceinvaders.engine;

// internal imports
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.game_objects.*;
import spaceinvaders.graphics.GameGrid;
import spaceinvaders.graphics.TitleScreen;

/**
 *  Class that contains all the event handling necessary for the game
 */
public class GameEngine {
    /**
     * Configuration class composed into the GameEngine
     */
    private static Config config = new Config();
    
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
     * Instantiates titleScreenLoader
     * @param titleScreenLoader
     */
    public static void setTitleScreenLoader(FXMLLoader titleScreenLoader) {
        GameEngine.titleScreenLoader = titleScreenLoader;
    }
    
    /**
     * Instantiates gameScreenLoader
     * @param gameScreenLoader
     */
    public static void setGameScreenLoader(FXMLLoader gameScreenLoader) {
        GameEngine.gameScreenLoader = gameScreenLoader;
    }
    
    /**
     * Saves stage for fast switch scene usage
     * @param stage
     */
    public static void setStage(Stage stage) {
        GameEngine.stage = stage;
    }
    
    /**
     * Get StateHandler
     */
    public static StateHandler getStateHandler() {
        return stateHandler;
    }
    
    /**
     * Get GameObjectCollection
     */
    public static GameObjectCollection getGameObjectCollection() {
        return gameObjectCollection;
    }
    
    /**
     * Gets the stage in use for fast switch scene usage
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
     * Returns the FXMLLoader for the title screen
     * 
     * @return title screen FXMLoader
     */
    public static FXMLLoader getTitleScreenLoader() {
        return titleScreenLoader;
    }
    
    /**
     * Instantiates Scene class, GameobjectCollection class and StateHandler class
     * 
     * <p>
     * Also fills GameObjectCollection with a Cannon and Barricades
     * </p>
     */
    public static void loadGame() {
        gameObjectCollection = new GameObjectCollection(config.getSwarmHeight(), config.getSwarmWidth());
        stateHandler = new StateHandler(config.getFrameRate(), gameObjectCollection);
        
        Cannon player = new Cannon(config.getGameGridWidth() / 2 , config.getGameGridHeight() - 1);
        
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(player);
        
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 - 1, config.getGameGridHeight() - 4));
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2, config.getGameGridHeight() - 4));
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 + 1, config.getGameGridHeight() - 4));
        
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 - 8, config.getGameGridHeight() - 4));
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 - 7, config.getGameGridHeight() - 4));
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 - 6, config.getGameGridHeight() - 4));
        
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 + 5, config.getGameGridHeight() - 4));
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 + 6, config.getGameGridHeight() - 4));
        gameObjectCollection.add(new Barricade(config.getGameGridWidth() / 2 + 7, config.getGameGridHeight() - 4));
        
        gameObjectCollection.add(new SpaceShip(0, 4));
    }
    
    /**
     * Main game loop
     * 
     * <p>
     *  Responsible for coordinating gameplay sequentiality, such as 
     *  calling the graphical renderer and calling the stateHandler to update and verify runtime hazards
     * </p>
     * 
     * @param grid game main grid
     * @param dt action time counter
     * @return fatal error code
     */
    public static int gameLoop(GameGrid grid, long dt) {
  
        // update
        stateHandler.updateCollection(gameObjectCollection, dt);

        // hazards check
        stateHandler.checkHazards(gameObjectCollection);

        // fatal hazards check
        return stateHandler.checkFatalHazards(gameObjectCollection);            
        
    }
        
    /**
     * Used to initiate the game in the title screen
     * 
     * @throws IOException
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
