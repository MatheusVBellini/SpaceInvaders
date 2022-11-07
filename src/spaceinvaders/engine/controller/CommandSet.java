package spaceinvaders.engine.controller;

/**
 * Encodes a particular command set to be used varying with the game screen
 */
public abstract class CommandSet {
    /**
     * Takes an input and processes it
     * 
     * @param input 
     */
    public abstract void processInput(char input);
}
