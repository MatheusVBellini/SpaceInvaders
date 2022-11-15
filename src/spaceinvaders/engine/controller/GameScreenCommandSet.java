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
    
    private int escFunc;
    
    public GameScreenCommandSet(FXMLLoader loader, Cannon player) {
        controller = loader.getController();
        this.player = player;
        
        escFunc = 0;
        controller.startGameLoop();
    }
    
    /**
     * Gets the player input to command the cannon
     */
    @Override
    public void processInput(KeyCode key) {
        switch (key) {
            case Z:
                if (player.canShoot()) {
                    player.shoot(); // shoot
                }
                break;
            case RIGHT:
                player.move(1); // move right
                break;
            case LEFT:
                player.move(-1); // move left
                break;
            case ESCAPE:
                if (escFunc == 0) {
                    controller.pause();
                } else {
                    controller.startGameLoop();
                }
                escFunc = (escFunc + 1) % 2;
                break;
        }
    }
}
