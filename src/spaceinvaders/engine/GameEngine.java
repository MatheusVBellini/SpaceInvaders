package spaceinvaders.engine;

// internal imports
import spaceinvaders.graphics.Scene;
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.game_objects.Alien;
import spaceinvaders.graphics.Scene;
import spaceinvaders.game_objects.*;

// external imports
import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {
    private Config config;
    private StateHandler stateHandler;
    private ArrayList<GameObject> gameObjectCollection;
    private Scene game_scene;

    // NULL constructor
    public GameEngine() {}

    // 'boot' process
    public void bootGame(String[] args) {
        config = new Config(1, new ArrayList<>(Arrays.asList(args)));
        stateHandler = new StateHandler();
        game_scene = new Scene();
        gameObjectCollection = new ArrayList<>();
    }

    // loads main game
    public void loadGame() {
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(new Cannon(Scene.getCenterX() , Scene.getHeight() - 1));
        for (int i = 1; i <= 3; i++) {
            gameObjectCollection.add(new Alien(Scene.getCenterX(), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(Scene.getCenterX() - 1 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(Scene.getCenterX() - 2 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(Scene.getCenterX() + 1 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
            gameObjectCollection.add(new Alien(Scene.getCenterX() + 2 * (GameObject.getHitboxWidth() + 2), i * (GameObject.getHitboxHeight() + 1)));
        }
        gameObjectCollection.add(new Barricade(Scene.getCenterX(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 3 * GameObject.getHitboxWidth(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 3 * GameObject.getHitboxWidth(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
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
