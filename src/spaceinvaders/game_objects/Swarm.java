package spaceinvaders.game_objects;

import java.util.ArrayList;

import spaceinvaders.graphics.Scene;

public class Swarm {
    private int numOfAliens;
    private int speed; // pixel / second
    private ArrayList<Alien> swarm;
    
    public Swarm(int rAliens, int cAliens) {
        speed = 1;
        numOfAliens = rAliens * cAliens;
        swarm = new ArrayList<>();
        
        int initX = (GameObject.getHitboxWidth() / 2) + (Scene.getWidth() / cAliens);
        int initY = GameObject.getHitboxHeight() + 1;
        
        for (int i = 0; i < rAliens; i++) {
            for (int j = 0; j < cAliens; j++) {
                swarm.add(new Alien(
                        initX + j * (GameObject.getHitboxWidth() + 2), 
                        initY + i * (GameObject.getHitboxHeight() + 1)
                ));
            }
        }
    }
    
    public void update() {
        boolean switch_warning = false;
        for (Alien alien : swarm) {
            alien.move();
            if (alien.getX() < 0 || alien.getX() > Scene.getWidth() - GameObject.getHitboxWidth()) {
                switch_warning = true;
            }
        }
        
        if (switch_warning) {
            for (Alien alien : swarm) {
                alien.update();
            }
        }
    }
    
    public ArrayList<GameObject> getArrayOfAliens() {
        return new ArrayList<>(swarm);
    }
    
    public int getSpeed() {
        return speed;
    }
}
