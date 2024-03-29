package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.controller.GameOverScreenCommandSet;

/**
 * Game over screen
 */
public class GameOverScreen extends GameScene {
    /**
     * Instantiates scene and set its command set
     * 
     * @param loader loader
     * @throws IOException error initializing process
     */
    public GameOverScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new GameOverScreenCommandSet(loader));
    }
}
