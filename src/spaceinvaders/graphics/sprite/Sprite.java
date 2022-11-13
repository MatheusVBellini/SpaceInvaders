package spaceinvaders.graphics.sprite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import spaceinvaders.engine.GameEngine;


/**
 * Graphical information game objects
 */
public abstract class Sprite {
    ImageView imgView;
    
    protected Sprite(String spriteFilePath) {
        getClass();
        Image img = new Image(
                getClass().getResource(spriteFilePath).toExternalForm(),        // image source file
                GameEngine.settings().getResWidth()/20,                         // image width
                GameEngine.settings().getResHeight()/30,                        // image height
                true,                                                           // preserve ratio
                true                                                            // smooth
        );
        
        imgView = new ImageView(img);
    }
    
    public ImageView getImage() {
        return imgView;
    }
}
