package spaceinvaders.engine.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

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
        // TODO
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
     * Quits the game
     */
    public void quit() {
        if (selectedButton == 1) {
            System.exit(0);
        }
    }
}
