package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.engine.controller.GameScreenCommandSet;
import spaceinvaders.game_objects.Cannon;

/**
 * game's main screen
 */
public class GameScreen extends GameScene {
    
    /**
     * Instantiates scene and set its command set
     * 
     * @param loader loader
     * @throws IOException  error initializing process
     */
    public GameScreen(FXMLLoader loader) throws IOException {
        super(loader);
        
        setCommandSet(
                new GameScreenCommandSet(
                        loader, 
                        (Cannon)GameEngine.getGameObjectCollection().getGameObject(Cannon.class)
                )
        );
    }

}
