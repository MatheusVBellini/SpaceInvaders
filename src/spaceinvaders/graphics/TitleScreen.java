package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.controller.TitleScreenCommandSet;

/**
 * title screen
 */
public class TitleScreen extends GameScene {
    
    /**
     * Instantiates scene and set its command set
     * 
     * @param loader loader
     * @throws IOException error initializing process
     */
    public TitleScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new TitleScreenCommandSet(loader));
    }
    
}
