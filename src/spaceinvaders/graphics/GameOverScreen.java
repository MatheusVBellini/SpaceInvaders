package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.controller.GameOverScreenCommandSet;

/**
 *
 * @author matheusbellini
 */
public class GameOverScreen extends GameScene {
    public GameOverScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new GameOverScreenCommandSet(loader));
    }
}
