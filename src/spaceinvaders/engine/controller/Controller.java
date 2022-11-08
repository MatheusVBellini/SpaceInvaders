package spaceinvaders.engine.controller;

import java.util.Scanner;

/**
 * Responsible for implementing input sensitive commands
 * 
 * @author matheusbellini
 */
public class Controller {
    /**
     * Attribute responsible for acquiring the input
     */
    Scanner input;
    
    /**
     * Command set being used
     */
    CommandSet commandSet;
    
    /**
     * Initializes the input gatherer
     */
    public Controller() {
        input = new Scanner(System.in);
        setCommandSet(new MenuCommandSet());
    }
    
    /**
     * Sets the command set being used
     * 
     * @param commandSet
     */
    public void setCommandSet(CommandSet commandSet) {
        this.commandSet = commandSet;
    }
    
    /**
     * Listens and executes the input
     */
    public void listen() {
        char key = input.next().charAt(0);
        commandSet.processInput(key);
    }
}
