/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package spaceinvaders.engine.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import spaceinvaders.engine.GameEngine;

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
