package spaceinvaders.engine.controller;

import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.graphics.sprite.CannonSprite;

/**
 * Controller for the main game screen
 */
public class GameScreenController implements Initializable {
    
    @FXML
    private AnchorPane gameScreen;
    
    @FXML
    private GridPane grid;
    
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // test
        Image cannon = new CannonSprite();
        if (cannon.isError()) {
            exit(2);
        }
        ImageView iv = new ImageView(cannon);
        grid.add(iv,1,1);
        
    }
    
    /**
     * Sets the values defined by the settings component of the game engine
     */
    public void applySettings() {
        gameScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameScreen.setPrefWidth(GameEngine.settings().getResWidth());
        grid.setPrefHeight(GameEngine.settings().getResHeight());
        grid.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    /**
     * Draws characters on screen
     */
    
    
}
