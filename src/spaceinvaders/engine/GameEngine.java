package spaceinvaders.engine;

// internal imports
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.game_objects.Alien;
import spaceinvaders.graphics.Scene;
import spaceinvaders.graphics.tui.*;
import spaceinvaders.graphics.gui.*;
import spaceinvaders.game_objects.*;

// external imports
import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {
    private Config config;
    private StateHandler stateHandler;
    private ArrayList<GameObject> gameObjectCollection;
    Scene game_scene;

    // NULL constructor
    public GameEngine() {}

    // 'boot' process
    public void bootGame(String[] args) {
        // initialize configs
        config = new Config(1, new ArrayList<>(Arrays.asList(args)));
        stateHandler = new StateHandler();

        // fetch infos on game's graphics
        if (config.getGameGraphicOption()) {
            game_scene = new SceneTUI();
        } else {
            game_scene = new SceneGUI();
        }

        // initualizes array
        gameObjectCollection = new ArrayList<>();
    }

    // loads main game
    public void loadGame() {
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(new Cannon(SceneTUI.getCenterX() , SceneTUI.getHeight() - 1));
        for (int i = 1; i <= 3; i++) {
            gameObjectCollection.add(new Alien(SceneTUI.getCenterX(), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(SceneTUI.getCenterX() - 1 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(SceneTUI.getCenterX() - 2 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(SceneTUI.getCenterX() + 1 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(SceneTUI.getCenterX() + 2 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
        }
        gameObjectCollection.add(new Barricade(SceneTUI.getCenterX(), SceneTUI.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTUI.getCenterX() - 3 * GameObject.getHitboxWidth(), SceneTUI.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(SceneTUI.getCenterX() + 3 * GameObject.getHitboxWidth(), SceneTUI.getHeight() - GameObject.getHitboxHeight() - 3));
    }

    // game loop
    public void gameLoop() {
        while (true) {
            // start time counting
            long start = System.currentTimeMillis();

            // processInput()
            // render()
            game_scene.render(gameObjectCollection);
            // update()
            stateHandler.updateCollection(gameObjectCollection);

            // wait the correct amount of time for the cycle to end
            try {
                Thread.sleep(config.getFrameTime() + start - System.currentTimeMillis());
            } catch (IllegalArgumentException ex) {
                // do nothing -- framerate lower than expected
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
