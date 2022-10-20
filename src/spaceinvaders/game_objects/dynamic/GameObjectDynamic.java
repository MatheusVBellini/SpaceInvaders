package spaceinvaders.game_objects.dynamic;

import spaceinvaders.game_objects.GameObject;

public abstract class GameObjectDynamic extends GameObject{
    GameObjectDynamic(int x, int y) {
        super(x,y);
    }
    
    abstract void move();
}
