package spaceinvaders.engine;

// internal imports
import spaceinvaders.graphics.Scene;
import spaceinvaders.graphics.tui.*;
import spaceinvaders.graphics.gui.*;
import spaceinvaders.game_objects.*;
import spaceinvaders.game_objects.dynamic_objects.*;
import spaceinvaders.game_objects.static_objects.*;

// external imports
import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {
    private Config config;
    private ArrayList<GameObject> gameObjectCollection;
    Scene game_scene;

    // NULL constructor
    public GameEngine() {}

    // 'boot' process -- goes directly to main game
    public void bootGame(String[] args) {
        // initialize configs
        config = new Config(10, new ArrayList<>(Arrays.asList(args)));

        // fetch infos on game's graphics
        if (config.getGameGraphicOption()) {
            game_scene = new SceneTUI();
        } else {
            game_scene = new SceneGUI();
        }

        // fill gameObjectColletion with inital state
        gameObjectCollection = new ArrayList<>();
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
    }

    // game loop
    public void game_loop() {
        while (true) {
            // start time counting
            long start = System.currentTimeMillis();

            // processInput()
            // render()
            game_scene.render(gameObjectCollection);
            // update()
            //gameObjectCollection.forEach(gameObject -> gameObject.update());

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
