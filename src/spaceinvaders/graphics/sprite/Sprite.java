package spaceinvaders.graphics.sprite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import spaceinvaders.game_objects.GameObject;


/**
 * Graphical information game objects
 */
public abstract class Sprite {
    /**
     * Image container for displaying the 
     * sprite graphical information on the screen
     */
    ImageView imgView;
    
    /**
     * Initializes the Image object with sizes corresponding to that of the scene
     * and binds them to the ImageViewer
     * 
     * @param spriteFilePath 
     */
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
    
    /**
     * Gets image container of the class
     * 
     * @return image container 
     */
    public ImageView getImage() {
        return imgView;
    }
}
