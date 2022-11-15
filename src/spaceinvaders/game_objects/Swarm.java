package spaceinvaders.game_objects;

import java.util.LinkedList;
import spaceinvaders.engine.GameEngine;

/**
 * Collection of aliens that move together
 */
public class Swarm {
    /**
     * Number of aliens in the swarm
     */
    private int numOfAliens;
    
    /**
     * Speed of the swarm movement in pixels per second
     */
    private int speed;
    
    /**
     * List of aliens that compose the swarm
     */
    private LinkedList<GameObject> swarm;
    
    /**
     * Instantiates the swarm with a specified height and 
     * width and with default initial speed of 1
     * 
     * @param rAliens number of alien rows
     * @param cAliens number of alien columns
     */
    public Swarm(int rAliens, int cAliens) {
        speed = 1;
        numOfAliens = rAliens * cAliens;
        swarm = new LinkedList<>();
        
        int initX = GameEngine.settings().getResWidth() / 4; //- cAliens;
        int initY = 6 * GameObject.getGameObjectHeight();
        
        int incX = 0;
        int incY = 0;
        int sel = 3;
        for (int i = 0; i < rAliens; i++) {
            for (int j = 0; j < cAliens; j++) {
                swarm.add(new Alien(
                        initX + incX, 
                        initY + incY,
                        sel
                ));
                
                incX += GameObject.getGameObjectWidth() + 4;
            }
            
            incX = 0;
            incY += GameObject.getGameObjectHeight() + 3;
            if (i == 0) { sel--; }
            if (i == 2) { sel--; }
        }
    }
    
    /**
     * Move aliens in the swarm, if one of them hits a wall, the 
     * movement is inverted and all the aliens go downwards by 1 pixel
     */
    public void update() {
        boolean switch_warning = false;
        for (GameObject alien : swarm) {
            for (int i = 0; i < speed; i++) {
                alien.update();
            }
            
            if (alien.getX() < 0 || alien.getX() > GameEngine.settings().getResWidth() - GameObject.getGameObjectWidth()) {
                switch_warning = true;
            }
            
        }
        
        if (switch_warning) {
            for (GameObject alien : swarm) {
                ((Alien)alien).update(switch_warning);
            }
        }
        
        // checks if swarm needs a speed-up
        if (swarm.size() <= numOfAliens/2) {
            speed = 2;
        } if (swarm.size() <= numOfAliens/4) {
            speed = 3;
        }
    }
    
    /**
     * Get the list of aliens
     * 
     * @return  list of aliens
     */
    public LinkedList<GameObject> getListOfAliens() {
        return swarm;
    }
    
    /**
     * Get the current speed of the swarm
     * 
     * @return current speed of the swarm
     */
    public int getSpeed() {
        return speed;
    }

}
