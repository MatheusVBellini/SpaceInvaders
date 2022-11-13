package spaceinvaders.engine.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.graphics.GameScreen;

/**
 *
 * @author matheusbellini
 */
public class TitleScreenController implements Initializable {
    /**
     * Determines which button of the UI is selected
     * 
     * <p>
     *  -1 - none
     *  <p>
     *  0 - Start Game 
     *  <p>
     *  1 - Quit
     */
    private int selectedButton = -1;
    
    /**
     * Screen itself
     */
    @FXML
    private AnchorPane titleScreen;
    
    /**
     * Text under start game button
     */
    @FXML
    private Label startGameText;
    
    /**
     * Text under quit game button
     */
    @FXML
    private Label quitText;
    
    /**
     * Player latest hi-score
     */
    @FXML
    private Label scoreText;
    
    /**
     * Start Game button, when clicked that game is started
     */
    @FXML
    private Button startGameBtn;
    
    /**
     * Quit Game button, when clicked game closes
     */
    @FXML
    private Button quitBtn;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applySettings();
    }
    
    /**
     * Sets the values defined by the settings component of the game engine
     */
    public void applySettings() {
        titleScreen.setPrefHeight(GameEngine.settings().getResHeight());
        titleScreen.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    /**
     * Read and set player's latest hi-score
     * 
     */
    public void setScore() {
    }
    
    /**
     * Selects upper button
     */
    public void buttonUp() {
        
        if (selectedButton != 0) {
            selectedButton = 0;
            startGameText.setTextFill(Color.RED);
            quitText.setTextFill(Color.WHITE);
        }

    }
    
    /**
     * Selects lower button
     */
    public void buttonDown() {

        if (selectedButton != 1) {
            selectedButton = 1;
            quitText.setTextFill(Color.RED);
            startGameText.setTextFill(Color.WHITE);
        }

    }
    
    /**
     * Starts the game
     */
    public void startGame() throws IOException {
        if (selectedButton != 0) {
            return;
        }
        
        // create new main game scene
        GameScreen scene = new GameScreen(GameEngine.getGameScreenLoader());
        Stage stage = GameEngine.getStage();
        
        scene.listenToKey();
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    /**
     * Quits the game
     */
    public void quit() {
        if (selectedButton == 1) {
            System.exit(0);
        }
    }
}
