package spaceinvaders;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import spaceinvaders.engine.GameEngine;

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
     * GUI default initializer
     * 
     * @param stage
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {
        // configuring game
        GameEngine.settings()
                .setFrameRate(60)
                .setSwarmSize(5,11)
                .setResolution(600,600);
        
        // JavaFX information
        GameEngine.setStage(stage);
        GameEngine.setTitleScreenLoader(new FXMLLoader(getClass().getResource("./graphics/TitleScreen.fxml")));
        GameEngine.setGameScreenLoader(new FXMLLoader(getClass().getResource("./graphics/GameScreen.fxml")));
        GameEngine.startGUI();
    }

    /**
     * Main
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
