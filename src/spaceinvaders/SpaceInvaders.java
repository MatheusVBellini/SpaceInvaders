package spaceinvaders;

import spaceinvaders.engine.GameEngine;

/**
 * <strong>Space Invaders Game</strong>
 * 
 * <p>
 *  This game was developed for the discipline SCC0604-Object-Oriented Programming
 *  of the University of São Paulo (ICMC-USP)
 * </p> 
 * 
 * <p>
 *  This code was projected and written by Matheus Violaro Bellini (nUSP: 12547600)
 *  of the Computer Engineering course (EESC/ICMC)
 * </p>
 * 
 * @author Matheus Violaro Bellini
 */
public class SpaceInvaders {
    /**
     * Static declaration of a GameEngine object responsible 
     * for commanding the game settings and succession of events
     */
    private static GameEngine gameEngine = new GameEngine();

    /**
     * Main
     * 
     * @param args
     */
    public static void main(String[] args) {
        // configuring game
        gameEngine.settings()
                .setFrameRate(60)
                .setSwarmSize(5,11)
                .setResolution(26, 35);
        
        
        gameEngine.initGame();
    }
    
}
