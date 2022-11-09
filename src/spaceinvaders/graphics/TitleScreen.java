package spaceinvaders.graphics;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import spaceinvaders.engine.controller.TitleScreenCommandSet;
import spaceinvaders.engine.controller.TitleScreenController;

/**
 * Title Screen where the game opens
 */
public class TitleScreen extends GameScene {
    
    public TitleScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new TitleScreenCommandSet(loader));
        
        // set hi-score on the screen
        TitleScreenController controller = loader.getController();
        controller.setScore();
        
    }
    
    @Override
    public void listenToKey() {
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                listenToKey(event.getCode());
            }
        });
    }
}
