package spaceinvaders.engine.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import spaceinvaders.engine.GameEngine;

/**
 * FXML Controller class for the game over screen
 */
public class GameOverScreenController implements Initializable {

    /**
     * Top-level parent node of the scene
     */
    @FXML
    private AnchorPane gameOverScreen;
    
    /**
     * Label specifying player's score
     */
    @FXML
    private Label scoreLabel;
    
    /**
     * Sets the correct score on the screen and apply window settings
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int score = GameEngine.getScore();
        if (score < 10) {
            scoreLabel.setText("000" + score);
        } else if (score < 100) {
            scoreLabel.setText("00" + score);
        } else if (score < 1000) {
            scoreLabel.setText("0" + score);
        } else {
            scoreLabel.setText("" + score);
        }
        
        applySettings();
    }   
    
    /**
     * Sets the values defined by the settings component of the game engine
     */
    public void applySettings() {
        gameOverScreen.setPrefHeight(GameEngine.settings().getResHeight());
        gameOverScreen.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    
}
