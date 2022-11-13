package spaceinvaders.graphics.sprite;

import javafx.scene.image.Image;
import spaceinvaders.engine.GameEngine;


/**
 * Graphical information game objects
 */
public abstract class Sprite extends Image {
    protected Sprite(String spriteFilePath) {
        super(
                GameEngine.processFilePath(spriteFilePath),                                                 // path to file
                GameEngine.settings().getResWidth()/10,                         // image width
                GameEngine.settings().getResHeight()/20,                        // image height
                true,                                                           // preserve ratio
                true                                                            // smooth
        );
    }
}
