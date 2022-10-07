package spaceinvaders.game_objects;

import spaceinvaders.game_objects.GameObject.objectType;

public class SpriteTUI extends Sprite {
    /*
     * 
     * Attributes
     * 
     */
    char pixels[][];

    /*
     * 
     * Methods
     * 
     */
    SpriteTUI(objectType type) {
        if (type == objectType.Cannon) {

        } else if (type == objectType.Alien) {

        } else if (type == objectType.Barricade) {

        } else if (type == objectType.Projectile) {

        }
    }

    // draw the sprite
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
