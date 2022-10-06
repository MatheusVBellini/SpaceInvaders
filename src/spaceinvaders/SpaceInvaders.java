package spaceinvaders;

// intern imports
import spaceinvaders.engine.graphics.Scene;
import spaceinvaders.engine.graphics.tui.*;
import spaceinvaders.engine.graphics.gui.*;
import spaceinvaders.game_objects.*;

// extern imports
import java.util.ArrayList;
import java.util.Arrays;

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
    // game option
    private static ArrayList<String> args = new ArrayList<>();
    private static boolean gameOption = isTUI(args.get(1));
    private static boolean isTUI(String arg) {
        if (arg.equals("-t") || arg.equals("--tui")) {
            return true;
        } else {
            return false;
        }
    }
    public static void setArgs(ArrayList<String> args) {
        SpaceInvaders.args = args;
    }
    public static boolean getGameOption() {
        return SpaceInvaders.gameOption;
    }
    
    // frame rate
    private static long frameRate = 60;
    private static long frameTime = 1000 / frameRate;

    // object collection
    private static ArrayList<GameObject> gameObjectCollection = new ArrayList<>();

    // scene collection
    private static ArrayList<Scene> sceneCollection= new ArrayList<>();

    // game loop
    private void game_loop() {
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

    /*
     * 
     * Main 
     * 
     */
    public static void main(String[] args) {
        // process command line args
        SpaceInvaders.setArgs(new ArrayList<>(Arrays.asList(args)));
        System.out.println(args);
    }
    
}
