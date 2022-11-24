package spaceinvaders.engine.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Controller for the title game screen
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
   
    /**
     * Applies window settings and sets player's hi-score
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applySettings();
        setScore();
    }
    
    /**
     * Sets the values defined by the settings component of the game engine
     */
    private void applySettings() {
        titleScreen.setPrefHeight(GameEngine.settings().getResHeight());
        titleScreen.setPrefWidth(GameEngine.settings().getResWidth());
    }
    
    /**
     * Read and set player's latest hi-score
     * 
     */
    private void setScore() {
        FileInputStream reader = null;
        
        try {
            
            byte[] buffer = new byte[4];
            
            // read previous saved score
            File hiScore = new File("./src/spaceinvaders/engine/controller/hiScore.txt");   
            reader = new FileInputStream(hiScore);
            reader.read(buffer);
            scoreText.setText(new String(buffer, StandardCharsets.UTF_8));

            reader.close();
            
        } catch (Exception ex) {
            
            // default value
            scoreText.setText("0000");
            
        }
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
     * Starts the game (contains the main game loop)
     * @throws java.io.IOException
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
