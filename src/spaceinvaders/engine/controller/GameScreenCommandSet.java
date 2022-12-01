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
    
    /**
     * screen controller for applying commands to the scene
     */
    private GameScreenController controller;
    
    /**
     * Specifies what ESCAPE key activates
     * 
     * <p>0 - pause</p>
     * <p>1 - continue game</p>
     */
    private int escFunc;
    
    
    /**
     * Gets the scene controller through its loader
     * 
     * @param loader loader
     * @param player player object
     */
    public GameScreenCommandSet(FXMLLoader loader, Cannon player) {
        controller = loader.getController();
        this.player = player;
        
        escFunc = 0;
        controller.startGameLoop();
    }
    
    /**
     * @param key
     * 
     * Commands accepted:
     * 
     * <ul>
     *      <li><strong>z</strong> - shoot with player's Cannon</li>
     *      <li><strong>right arrow key</strong> - move Cannon right</li>
     *      <li><strong>left arrow key</strong> - move Cannon left</li>
     *      <li><strong>ESCAPE</strong> - pause game</li>
     * </ul>
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
