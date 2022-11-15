package spaceinvaders.graphics;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.engine.controller.GameScreenCommandSet;
import spaceinvaders.game_objects.Cannon;

/**
 *
 * @author matheusbellini
 */
public class GameScreen extends GameScene {
    
    public GameScreen(FXMLLoader loader) throws IOException {
        super(loader);
        
        setCommandSet(
                new GameScreenCommandSet(
                        loader, 
                        (Cannon)GameEngine.getGameObjectCollection().getGameObject(new Cannon(0,0).getClass())
                )
        );
    }

}
