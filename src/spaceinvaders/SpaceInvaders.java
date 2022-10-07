package spaceinvaders;

// intern imports
import spaceinvaders.engine.graphics.Scene;
import spaceinvaders.engine.graphics.tui.*;
import spaceinvaders.engine.graphics.gui.*;
import spaceinvaders.game_objects.*;
import spaceinvaders.docs.*;

// extern imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
    // software usage documentation
    private static Doc documentation;

    // game options
    private static ArrayList<String> args = new ArrayList<>();

    private static enum gameGraphicOptions {GUI, TUI};
    private static gameGraphicOptions gameGraphicOption = gameGraphicOptions.GUI;

    // setters
    private static void setGameOptions() {
        Iterator<String> it = args.iterator();
        while (it.hasNext()) {
            if (it.next().equals("-t") || it.next().equals("--tui")) {
                gameGraphicOption = gameGraphicOptions.TUI;
            }
        }
    }

    public static void setArgs(ArrayList<String> args) {
        SpaceInvaders.args = args;
        setGameOptions();
    }

    // getters
    public static boolean getGameGraphicOption() {
        return (SpaceInvaders.gameGraphicOption == gameGraphicOptions.TUI) ? true : false; // true == TUI | false == GUI
    }

    // frame rate
    private static long frameRate = 60;
    private static long frameTime = 1000 / frameRate;

    // object collection
    private static ArrayList<GameObject> gameObjectCollection = new ArrayList<>();

    // scene collection
    private static Scene[] sceneCollection = new Scene[3];

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

        // debugging and testing
        if (SpaceInvaders.gameGraphicOption == gameGraphicOptions.TUI) {
            Scene test = new SceneTUI();
            test.build();
        }
    }
    
}
