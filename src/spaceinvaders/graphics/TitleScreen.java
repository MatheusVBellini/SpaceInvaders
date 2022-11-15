package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.controller.TitleScreenCommandSet;

/**
 * Title Screen where the game opens
 */
public class TitleScreen extends GameScene {
    
    public TitleScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new TitleScreenCommandSet(loader));
    }
    
}
