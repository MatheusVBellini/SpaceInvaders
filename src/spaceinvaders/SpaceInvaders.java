package spaceinvaders;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.engine.controller.TitleScreenController;
import spaceinvaders.graphics.GameScene;
import spaceinvaders.graphics.TitleScreen;

/**
 * <strong>Space Invaders Game</strong>
 * 
 * <p>
 *  This game was developed for the discipline SCC0604-Object-Oriented Programming
 *  of the University of São Paulo (ICMC-USP)
 * </p> 
 * 
 * <p>
 *  This code was projected and written by Matheus Violaro Bellini (nUSP: 12547600)
 *  of the Computer Engineering course (EESC/ICMC)
 * </p>
 * 
 * @author Matheus Violaro Bellini
 */
public class SpaceInvaders extends Application {
    /**
     * Static declaration of a GameEngine object responsible 
     * for commanding the game settings and succession of events
     */
    private static GameEngine gameEngine = new GameEngine();
    
    /**
     * GUI default initializer
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        // initializing scene components
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./graphics/TitleScreen.fxml"));
        GameScene scene = new TitleScreen(fxmlLoader);

        // show scene
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
        
        // configuring game
        gameEngine.settings()
                .setFrameRate(60)
                .setSwarmSize(5,11)
                .setResolution(26, 35);
        
        
        gameEngine.initGame();
    }
    
}
