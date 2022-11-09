package spaceinvaders.graphics;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import spaceinvaders.engine.controller.TitleScreenCommandSet;

/**
 *
 * @author matheusbellini
 */
public class TitleScreen extends GameScene {
    public TitleScreen(FXMLLoader loader) throws IOException {
        super(loader);
        setCommandSet(new TitleScreenCommandSet(loader));
    }
    
    public void listenToKey() {
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                listenToKey(event.getCode());
            }
        });
    }
}
