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
    // Game variables
    private static GameEngine gameEngine = new GameEngine();

    /*
     * 
     * Main 
     * 
     */
    public static void main(String[] args) {
        // configuring game
        gameEngine.settings()
                .setFrameRate(30)
                .setSwarmSize(4,5)
                .setResolution(26, 30);
        
        
        gameEngine.loadGame();
        gameEngine.gameLoop();
    }
    
}
