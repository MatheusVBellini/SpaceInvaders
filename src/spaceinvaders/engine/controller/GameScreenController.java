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
import spaceinvaders.game_objects.GameObjectCollection;
import spaceinvaders.graphics.GameGrid;
import spaceinvaders.graphics.sprite.CannonSprite;

/**
 * Controller for the main game screen
 */
public class GameScreenController implements Initializable {
    
    @FXML
    private AnchorPane gameScreen;
    
    private final GridPane gridPane = new GameGrid();
    
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // initializing variables
        applySettings();                                                        // initializes graphic variables
        GameEngine.loadGame();                                                  // initilizazes game variables
        gameScreen.getChildren().add(gridPane);                                 // add GridPane to screen
        GameObjectCollection objectCol = GameEngine.getGameObjectCollection();  // fetch GameObjectCollection
        
        // game loop
        
        
        // draw test
        draw(GameEngine.getGameObjectCollection());
    }
    
    /**
     * Sets the values defined by the settings component of the game engine
     */
    public void applySettings() {
        gameScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameScreen.setPrefWidth(GameEngine.settings().getResWidth());
        gridPane.setPrefHeight(GameEngine.settings().getResHeight());
        gridPane.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    /**
     * Draw GameObjectCollection
     */
    public void draw(GameObjectCollection gameObjectCollection) {
        // draw allies
        gameObjectCollection.getAllies().forEach(
               ally -> 
               gridPane.add(
                       ally.getSprite().getImage(),
                       ally.getX(),
                       ally.getY()
               )
       );
        
       // draw projectiles
       gameObjectCollection.getProjectiles().forEach(
               projectile -> 
               gridPane.add(
                       projectile.getSprite().getImage(),
                       projectile.getX(),
                       projectile.getY()
               )
       );
       
       // draw aliens
       gameObjectCollection.getAliens().getListOfAliens().forEach(
               alien -> 
               gridPane.add(
                       alien.getSprite().getImage(),
                       alien.getX(),
                       alien.getY()
               )
       );
    }
}
