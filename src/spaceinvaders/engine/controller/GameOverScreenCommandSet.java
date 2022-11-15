package spaceinvaders.engine.controller;

import static java.lang.System.exit;
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
                exit(0); 
                break;
        }
    }
    
  
}
