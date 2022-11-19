package spaceinvaders.engine.controller;

import javafx.scene.input.KeyCode;

/**
 * Encodes a particular command set to be used varying with the game screen
 */
public abstract class CommandSet {
    /**
     * Takes an input and processes it
     * 
     * @param key KeyCode of desired key
     */
    public abstract void processInput(KeyCode key);
}
