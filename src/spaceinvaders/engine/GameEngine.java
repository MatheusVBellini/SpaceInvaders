package spaceinvaders.engine;

// internal imports
import spaceinvaders.game_objects.Cannon;
import spaceinvaders.graphics.Scene;
import spaceinvaders.game_objects.*;

public class GameEngine {
    private Config config;
    private StateHandler stateHandler;
    private Scene gameScene;
    private GameObjectCollection gameObjectCollection;

    public GameEngine() {
        config = new Config();
    }
    
    public Config settings() {
        return config;
    }

    // loads main game
    public void loadGame() {
        stateHandler = new StateHandler();
        gameScene = new Scene();
        gameObjectCollection = new GameObjectCollection(config.getSwarmHeight(), config.getSwarmWidth());
        
        // fill gameObjectColletion with inital state
        gameObjectCollection.add(new Cannon(Scene.getCenterX() , Scene.getHeight() - 1));
        
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 6 * GameObject.getHitboxWidth() - 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 6 * GameObject.getHitboxWidth(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() - 6 * GameObject.getHitboxWidth() + 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 6 * GameObject.getHitboxWidth() - 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 6 * GameObject.getHitboxWidth(), Scene.getHeight() - GameObject.getHitboxHeight() - 3));
        gameObjectCollection.add(new Barricade(Scene.getCenterX() + 6 * GameObject.getHitboxWidth() + 1, Scene.getHeight() - GameObject.getHitboxHeight() - 3));
    }

    // game loop
    public void gameLoop() {
        boolean breakLoop = false;
        while (!breakLoop) {
            // start time counting
            long start = System.currentTimeMillis();

            // processInput()
            // render
            gameScene.render(gameObjectCollection);
            // update
            stateHandler.updateCollection(gameObjectCollection);
            // collision check
            switch (stateHandler.checkHazards(gameObjectCollection)) {
                case 1 -> breakLoop = true;
            }

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
