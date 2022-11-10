package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.controller.TitleScreenCommandSet;
import spaceinvaders.engine.controller.TitleScreenController;

/**
 * Title Screen where the game opens
 */
public class TitleScreen extends GameScene {
    
    public TitleScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new TitleScreenCommandSet(loader));
        
        TitleScreenController controller = loader.getController();
        controller.applySettings();
    }
    
}
