package spaceinvaders.engine.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.game_objects.GameObject;
import spaceinvaders.game_objects.GameObjectCollection;
import spaceinvaders.graphics.GameOverScreen;

/**
 * Controller for the main game screen
 */
public class GameScreenController implements Initializable {
    
    @FXML
    private AnchorPane gameScreen;
    
    @FXML
    private Label scoreLabel;
    
    @FXML
    private Label lifeLabel;
    
    @FXML
    private Label pauseLabel;
    
    @FXML
    private Label stageLabel;
    
    private int stageCounter;
    
    /**
     * Initializes the controller class.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // initializing variables
        applySettings();                                                        // initializes graphic variables
        GameEngine.loadGame();                                                  // initilizes game objects                           
        stageCounter = 0;
        
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
        int score = 0;
        int life = 3;
        
        @Override
        public void handle(long now) {
            // run game loop
            switch (GameEngine.gameLoop(gameScreen.getChildren())) {
                case 0: 
                    break;
                case 1: 
                    stop(); 
                    gameOver(); 
                    break;
                case 2: 
                    nextLevel(GameEngine.getGameObjectCollection());
                    break;
            }
            
            // update score
            score = GameEngine.getScore();
            if (score < 10) {
                scoreLabel.setText("000" + score);
            } else if (score < 100) {
                scoreLabel.setText("00" + score);
            } else if (score < 1000) {
                scoreLabel.setText("0" + score);
            } else {
                scoreLabel.setText("" + score);
            }
            
            // update player life
            life = ((Cannon)GameEngine.getGameObjectCollection().getGameObject(Cannon.class)).getHealth();
            switch (life) {
                case 3:
                    lifeLabel.setText("♡♡♡");
                    break;
                case 2:
                    lifeLabel.setText("♡♡");
                    break;
                case 1:
                    lifeLabel.setText("♡");
            }
        }
    };
    
    public void startGameLoop() {
        pauseLabel.setOpacity(0);
        timer.start();
    }
    
    public void pause() {
       gameScreen.getChildren().remove(pauseLabel);
       pauseLabel.setOpacity(1);
       gameScreen.getChildren().add(pauseLabel);
       timer.stop();
    }
    
    /**
     * Go to Game Over screen
     */
    public void gameOver() {
        try {
            GameOverScreen scene = new GameOverScreen(GameEngine.getGameOverScreenLoader());
            Stage stage = GameEngine.getStage();
            
            scene.listenToKey();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Go to next level
     */
    public void nextLevel(GameObjectCollection gameObjectCollection) {
        ImageView tmp;
        GameEngine.replenishSwarm();
        for (GameObject alien : gameObjectCollection.getAliens().getListOfAliens()) {
            tmp = alien.getSprite().getImage();
            tmp.setTranslateX(alien.getX());
            tmp.setTranslateY(alien.getY());
            gameScreen.getChildren().add(tmp);
        }
        
        stageCounter++;
        stageLabel.setText("Stage:<" + stageCounter + ">");
    }
}
