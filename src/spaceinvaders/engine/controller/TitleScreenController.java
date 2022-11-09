package spaceinvaders.engine.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author matheusbellini
 */
public class TitleScreenController implements Initializable {
    
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
    
}
