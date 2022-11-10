package spaceinvaders.graphics.sprite;

import javafx.scene.shape.Rectangle;
import spaceinvaders.game_objects.*;

/**
 * Graphical information game objects
 */
public abstract class Sprite extends Rectangle {
    public Sprite(int x, int y) {
        super();
        setX(x);
        setY(y);
        setHeight(10);
        setWidth(10);
    }
}
