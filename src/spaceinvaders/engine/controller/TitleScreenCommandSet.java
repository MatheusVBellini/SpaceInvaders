package spaceinvaders.engine.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;

/**
 * Command set to be used in the menu
 */
public class TitleScreenCommandSet extends CommandSet {
    /**
     * screen controller for applying commands to the scene
     */
    private TitleScreenController controller;
    
    
    /**
     * Gets the scene controller through its loader
     * 
     * @param loader loader
     */
    public TitleScreenCommandSet(FXMLLoader loader) {
        controller = loader.getController();
    }
    
    /**
     * @param key
     * 
     * Commands accepted:
     * 
     * <ul>
     *      <li><strong>up arrow key</strong> - selects option above of current</li>
     *      <li><strong>down arrow key</strong> - selects option below current</li>
     *      <li><strong>ENTER</strong> - select option</li>
     * </ul>
     */
    @Override
    public void processInput(KeyCode key) {
        switch (key) {
            case UP: controller.buttonUp(); break;
            case DOWN: controller.buttonDown(); break;
            case ENTER: controller.quit(); {
                    try {
                        controller.startGame();
                    } catch (IOException ex) {
                        Logger.getLogger(TitleScreenCommandSet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } break;
        }
    }
}
