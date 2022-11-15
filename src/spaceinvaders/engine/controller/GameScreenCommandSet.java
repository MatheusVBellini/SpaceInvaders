package spaceinvaders.engine.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import spaceinvaders.game_objects.Cannon;

/**
 *  Command set used during the main game
 */
public class GameScreenCommandSet extends CommandSet {
    /**
     * Player to be controlled
     */
    private Cannon player;
    
    private GameScreenController controller;
    
    public GameScreenCommandSet(FXMLLoader loader, Cannon player) {
        controller = loader.getController();
        this.player = player;
        
        controller.startGameLoop();
    }
    
    /**
     * Gets the player input to command the cannon
     */
    @Override
    public void processInput(KeyCode key) {
        switch (key) {
            case Z:
                player.shoot(); // shoot
                break;
            case RIGHT:
                player.move(1); // move right
                break;
            case LEFT:
                player.move(-1); // move left
                break;
        }
    }
}
