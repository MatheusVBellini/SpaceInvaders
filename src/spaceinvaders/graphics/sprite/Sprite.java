package spaceinvaders.graphics.sprite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import spaceinvaders.game_objects.GameObject;


/**
 * Graphical information game objects
 */
public abstract class Sprite {
    ImageView imgView;
    
    protected Sprite(String spriteFilePath) {
        Image img = new Image(
                getClass().getResource(spriteFilePath).toExternalForm(),        // image source file
                GameObject.getGameObjectWidth(),                                // image width
                GameObject.getGameObjectHeight(),                               // image height
                true,                                                           // preserve ratio
                true                                                            // smooth
        );
        
        imgView = new ImageView(img);
    }
    
    public ImageView getImage() {
        return imgView;
    }
}
