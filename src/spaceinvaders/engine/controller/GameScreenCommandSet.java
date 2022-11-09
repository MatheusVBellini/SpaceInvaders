package spaceinvaders.engine.controller;

import javafx.scene.input.KeyCode;
import spaceinvaders.game_objects.Cannon;

/**
 *  Command set used during the main game
 */
public class GameScreenCommandSet extends CommandSet {
    /**
     * Player to be controlled
     */
    Cannon player;
    
    /**
     * 
     */
    public GameScreenCommandSet() {
        
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
