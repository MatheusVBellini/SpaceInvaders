package spaceinvaders.graphics.sprite;

import javafx.scene.image.Image;
import spaceinvaders.engine.GameEngine;


/**
 * Graphical information game objects
 */
public abstract class Sprite {
    Image img;
    
    protected Sprite(String spriteFilePath) {
        getClass();
        img = new Image(
                getClass().getResource(spriteFilePath).toExternalForm(),        // image source file
                GameEngine.settings().getResWidth()/10,                         // image width
                GameEngine.settings().getResHeight()/20,                        // image height
                true,                                                           // preserve ratio
                true                                                            // smooth
        );
    }
    
    public Image getImage() {
        return img;
    }
}
