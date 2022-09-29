package spaceinvaders;

// imports
import spaceinvaders.engine.*;
import spaceinvaders.game_objects.*;
import java.util.LinkedList;

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
     * Game Specs
     *
     */
    // frame rate
    private static long frameRate = 60;
    private static long frameTime = 1000 / frameRate;

    // object collection
    private static LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    /*
     * 
     * Main 
     * 
     */
    public static void main(String[] args) {

        // game loop
        while (true) {
            // start time counting
            long start = System.currentTimeMillis();
            
            // processInput()
            // update()
            // render()
            
            // wait the correct amount of time for the cycle to end
            try {
                Thread.sleep(SpaceInvaders.frameTime + start - System.currentTimeMillis());
            } catch (IllegalArgumentException ex) {
                // do nothing -- framerate lower than expected
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
            }
        }
    }
    
}
