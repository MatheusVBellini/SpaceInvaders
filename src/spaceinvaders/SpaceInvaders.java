package spaceinvaders;

// internal imports
import spaceinvaders.engine.GameEngine;

/*
 *
 * Matheus Violaro Bellini
 * Número USP: 12547600
 * 
 * Engenharia de Computação
 * Escola de Engenharia de São Carlos (EESC-USP)
 * Instituto de Ciências Matemáticas e de Computação (ICMC-USP)
 * 
 */
public class SpaceInvaders {
    /*
     * 
     * Main 
     * 
     */
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();

        gameEngine.bootGame(args);
        gameEngine.game_loop();
    }
    
}
