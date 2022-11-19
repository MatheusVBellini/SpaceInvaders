package spaceinvaders.engine.controller;

import static java.lang.System.exit;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;

/**
 * Commands set to be used during the game over screen
 */
public class GameOverScreenCommandSet extends CommandSet {
    /**
     * Screen controller for applying commands to the scene
     */
    GameOverScreenController controller;
    
    /**
     * Gets the scene controller through its loader
     * 
     * @param loader
     */
    public GameOverScreenCommandSet(FXMLLoader loader) {
        controller = loader.getController();
    }
    
    /**
     * @param key
     * 
     * Commands accepted:
     * 
     * <ul>
     *      <li><strong>ENTER</strong> -> exits the game</li>
     * </ul>
     */
    @Override
    public void processInput(KeyCode key) {
        switch (key) {
            case ENTER: 
                exit(0); 
                break;
        }
    }
    
  
}
