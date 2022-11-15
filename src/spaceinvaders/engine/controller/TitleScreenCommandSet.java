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
    private TitleScreenController controller;
    
    public TitleScreenCommandSet(FXMLLoader loader) {
        controller = loader.getController();
    }
    
    /**
     * Commands available in the menus
     */
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
