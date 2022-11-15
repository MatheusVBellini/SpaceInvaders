package spaceinvaders.engine.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;

/**
 *
 * @author matheusbellini
 */
public class GameOverScreenCommandSet extends CommandSet {
    GameOverScreenController controller;
    
    public GameOverScreenCommandSet(FXMLLoader loader) {
        controller = loader.getController();
    }

    @Override
    public void processInput(KeyCode key) {
        switch (key) {
            case ENTER:
        }
    }
    
  
}
