package spaceinvaders.engine.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    
    /**
     * top-level parent node
     */
    @FXML
    private AnchorPane gameScreen;
    
    /**
     * player's score indicator
     */
    @FXML
    private Label scoreLabel;
    
    /**
     * player's life indicator
     */
    @FXML
    private Label lifeLabel;
    
    /**
     * label shown when game is paused
     */
    @FXML
    private Label pauseLabel;

    /**
     * game stage indicator
     */
    @FXML
    private Label stageLabel;
    
    /**
     * counts which stage the game is in
     */
    private int stageCounter;
    
    /**
     * Initializes the controller class, sets stageCounter to 0, 
     * applies window settings, loads game assets and draw them on the screen
     * 
     * @param url default
     * @param rb default
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
    private void applySettings() {
        gameScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameScreen.setPrefWidth(GameEngine.settings().getResWidth());
        gameScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameScreen.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    /**
     * Draw GameObjectCollection
     * 
     * @param gameObjectCollection
     */
    private void draw(GameObjectCollection gameObjectCollection) {
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
    
    /**
     * Timer that coordinates main game loop, score change and life change
     */
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
                    writeScoreToFile(scoreLabel.getText());
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
    
    /**
     * Starts the main game loop
     */
    public void startGameLoop() {
        pauseLabel.setOpacity(0);
        timer.start();
    }
    
    /**
     * Pauses the game and show the pause label on the screen
     */
    public void pause() {
       gameScreen.getChildren().remove(pauseLabel);
       pauseLabel.setOpacity(1);
       gameScreen.getChildren().add(pauseLabel);
       timer.stop();
    }
    
    /**
     * Go to Game Over screen
     */
    private void gameOver() {
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
     * 
     * @param gameObjectCollection
     */
    private void nextLevel(GameObjectCollection gameObjectCollection) {
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
    
    /**
     * Write end-of-game score to hiScore.txt if higher than previous score 
     * 
     * @param score 
     */
    private void writeScoreToFile(String score) {
        // checks if current score is higher than previous
        int previous = 0;
        int current = Integer.parseInt(score);
        boolean isHigher = false;
        File hiScore = new File("./src/spaceinvaders/engine/controller/hiScore.txt");
        
        try {
            byte[] buffer = new byte[4];
            FileInputStream reader = new FileInputStream(hiScore);
            reader.read(buffer);
            
            previous = Integer.parseInt(new String(buffer, StandardCharsets.UTF_8));
            isHigher = (current > previous);
            
            reader.close();
        } catch (Exception ex) {
            isHigher = false;
        }

        // if is higher, write score to file
        if (isHigher) {
            try {
                String complement;
                
                if (current < 10) {
                    complement = "000";
                } else if (current < 100) {
                    complement = "00";
                } else if (current < 1000) {
                    complement = "0";
                } else {
                    complement = "";
                }
                
                PrintWriter writer = new PrintWriter(hiScore);
                writer.write(complement + Integer.toString(current));
                writer.close();
            } catch (Exception ex) {
                // could not write to file -- do nothing
            }
        }
    }
}
