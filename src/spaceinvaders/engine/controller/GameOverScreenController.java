/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package spaceinvaders.engine.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.graphics.TitleScreen;

/**
 * FXML Controller class
 *
 * @author matheusbellini
 */
public class GameOverScreenController implements Initializable {

    @FXML
    private AnchorPane gameOverScreen;
    
    @FXML
    private Label scoreLabel;
    
    /**
     * Initializes the controller class.
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
