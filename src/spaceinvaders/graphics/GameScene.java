package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import spaceinvaders.engine.controller.CommandSet;

/**
 * Game scene to be displayed while the application is running
 */
public abstract class GameScene extends Scene {
    private CommandSet commandSet;
    
    protected GameScene(FXMLLoader loader) throws IOException {
        super(loader.load());
    }
    
    protected void setCommandSet(CommandSet commandSet) {
        this.commandSet = commandSet;
    }
    
    protected void listenToKey(KeyCode key) {
        commandSet.processInput(key);
    }
    
    public abstract void listenToKey();
}
