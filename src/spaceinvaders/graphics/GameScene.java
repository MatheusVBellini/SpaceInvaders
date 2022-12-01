package spaceinvaders.graphics;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import spaceinvaders.engine.controller.CommandSet;

/**
 * Game scene to be displayed while the application is running
 */
public abstract class GameScene extends Scene {
    /**
     * scene's commandSet
     */
    private CommandSet commandSet;
    
    /**
     * Instantiates scene
     * 
     * @param loader loader
     * @throws IOException error initializing process
     */
    protected GameScene(FXMLLoader loader) throws IOException {
        super(loader.load());
    }
    
    /**
     * setter for the scene's commandSet
     * @param commandSet set of commands
     */
    protected void setCommandSet(CommandSet commandSet) {
        this.commandSet = commandSet;
    }
    
    /**
     * Pipelines the KeyCode obtained from the KeyEventHandler to the commandSet
     * 
     * @param key key code
     */
    protected void listenToKey(KeyCode key) {
        commandSet.processInput(key);
    }
    
    /**
     * Instantiates a new EventHandler in the scene 
     * for monitoring keyboard input
     */
    public void listenToKey() {
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                listenToKey(event.getCode());
            }
        });
    }
}
