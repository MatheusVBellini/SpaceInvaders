package spaceinvaders.engine.controller;

import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.game_objects.GameObject;
import spaceinvaders.game_objects.GameObjectCollection;
import spaceinvaders.graphics.sprite.CannonSprite;

/**
 * Controller for the main game screen
 */
public class GameScreenController implements Initializable {
    
    @FXML
    private AnchorPane gameScreen;
    
    @FXML
    private Label scoreLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // initializing variables
        applySettings();                                                        // initializes graphic variables
        GameEngine.loadGame();                                                  // initilizazes game variables                           
        
        // show objects on the screen
        draw(GameEngine.getGameObjectCollection());
    }
    
    /**
     * Sets the values defined by the settings component of the game engine
     */
    public void applySettings() {
        gameScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameScreen.setPrefWidth(GameEngine.settings().getResWidth());
        gameScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameScreen.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    /**
     * Draw GameObjectCollection
     * 
     */
    public void draw(GameObjectCollection gameObjectCollection) {
        ImageView tmp;

        // draw allies
        for (GameObject ally : gameObjectCollection.getAllies()) {
            tmp = ally.getSprite().getImage();
            tmp.setTranslateX(ally.getX());
            tmp.setTranslateY(ally.getY());
            gameScreen.getChildren().add(tmp);
        }
        
        // draw projectiles
        for (GameObject projectile : gameObjectCollection.getProjectiles()) {
            tmp = projectile.getSprite().getImage();
            tmp.setTranslateX(projectile.getX());
            tmp.setTranslateY(projectile.getY());
            gameScreen.getChildren().add(tmp);
        }
       
        // draw aliens
        for (GameObject alien : gameObjectCollection.getAliens().getListOfAliens()) {
            tmp = alien.getSprite().getImage();
            tmp.setTranslateX(alien.getX());
            tmp.setTranslateY(alien.getY());
            gameScreen.getChildren().add(tmp);
        }
    }
    
    // main game loop activator
    AnimationTimer timer = new AnimationTimer() {
        long dt = 0;
        int score = 0;
        
        @Override
        public void handle(long now) {
            // run game loop
            dt++;
            dt = dt % GameEngine.settings().getFrameRate();
            if (GameEngine.gameLoop(gameScreen.getChildren()) != 0) {
                stop();
            }
            
            // update score
            score = GameEngine.getScore();
            if (score < 10) {
                scoreLabel.setText("00" + score);
            } else if (score < 100) {
                scoreLabel.setText("0" + score);
            } else {
                scoreLabel.setText("" + score);
            }
            
            // update player life
            
        }
    };
    
    public void startGameLoop() {
        timer.start();
    }
}
