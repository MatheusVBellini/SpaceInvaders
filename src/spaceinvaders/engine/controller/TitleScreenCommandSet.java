package spaceinvaders.engine.controller;

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
            case ENTER: controller.quit(); break;
        }
    }
}
