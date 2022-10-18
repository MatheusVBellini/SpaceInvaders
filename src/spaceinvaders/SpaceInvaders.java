package spaceinvaders;

// intern imports
import spaceinvaders.graphics.Scene;
import spaceinvaders.graphics.tui.*;
import spaceinvaders.graphics.gui.*;
import spaceinvaders.game_objects.*;
import spaceinvaders.game_objects.dynamic_objects.*;
import spaceinvaders.game_objects.static_objects.*;
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
    private static long frameRate = 1;
    private static long frameTime = 1000 / frameRate;

    // object collection
    private static ArrayList<GameObject> gameObjectCollection = new ArrayList<>();

    // game loop
    private static void game_loop(Scene scene) {
        while (true) {
            // start time counting
            long start = System.currentTimeMillis();
            
            // processInput()
            // render()
            scene.render(gameObjectCollection);
            // update()
            //gameObjectCollection.forEach(gameObject -> gameObject.update());

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

        // initializing game graphics
        Scene game_scene;
        if (SpaceInvaders.gameGraphicOption == gameGraphicOptions.TUI) {
            game_scene = new SceneTUI();
        } else {
            game_scene = new SceneGUI();
        }

        // feeding gameObjectCollection
        gameObjectCollection.add(new Cannon(game_scene.getCenterX() , game_scene.getHeight() - 1 ));
        for (int i = 1; i <= 3; i++) {
            gameObjectCollection.add(new Alien(game_scene.getCenterX(), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(game_scene.getCenterX() - 1 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(game_scene.getCenterX() - 2 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(game_scene.getCenterX() + 1 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(game_scene.getCenterX() + 2 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
        }
        gameObjectCollection.add(new Barricade(game_scene.getCenterX(), game_scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(game_scene.getCenterX() - 3 * GameObject.getHitboxWidth(), game_scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(game_scene.getCenterX() + 3 * GameObject.getHitboxWidth(), game_scene.getHeight() - GameObject.getHitboxHeight() - 3));

        game_loop(game_scene);
    }
    
}
