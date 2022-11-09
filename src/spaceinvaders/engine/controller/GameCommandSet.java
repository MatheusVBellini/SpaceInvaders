package spaceinvaders.engine.controller;

import javafx.scene.input.KeyCode;
import spaceinvaders.game_objects.Cannon;

/**
 *  Command set used during the main game
 */
public class GameCommandSet extends CommandSet {
    /**
     * Player to be controlled
     */
    Cannon player;
    
    /**
     * Must receive the player to control
     * 
     * @param player
     */
    public GameCommandSet(Cannon player) {
        this.player = player;
    }
    
    /**
     * Gets the player input to command the cannon
     */
    @Override
    public void processInput(KeyCode key) {
//        switch (key) {
//            case 'z':
//            case 'Z':
//                player.shoot(); // shoot
//                break;
//            case 'm':
//            case 'M':
//                player.move(1); // move right
//                break;
//            case 'n':
//            case 'N':
//                player.move(-1); // move left
//                break;
//        }
    }
}
