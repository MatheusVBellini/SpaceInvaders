package spaceinvaders.graphics.sprite;

import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.image.Image;
import spaceinvaders.engine.GameEngine;


/**
 * Graphical information game objects
 */
public abstract class Sprite extends Image {
    protected Sprite(String spriteFilePath) {
        super(
                spriteFilePath,                                                 // path to file
                GameEngine.settings().getResWidth()/10,                         // image width
                GameEngine.settings().getResHeight()/20,                        // image height
                true,                                                           // preserve ratio
                true                                                            // smooth
        );
    }
}
