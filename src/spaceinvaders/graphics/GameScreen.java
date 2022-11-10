package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.controller.GameScreenCommandSet;
import spaceinvaders.engine.controller.GameScreenController;

/**
 *
 * @author matheusbellini
 */
public class GameScreen extends GameScene {
    
    public GameScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new GameScreenCommandSet(loader));
        
        GameScreenController controller = loader.getController();
        controller.applySettings();
    }

}
