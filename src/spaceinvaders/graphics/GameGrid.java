package spaceinvaders.graphics;

import java.util.Stack;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import spaceinvaders.engine.GameEngine;
import spaceinvaders.game_objects.GameObjectCollection;

/**
 *
 * @author matheusbellini
 */
public class GameGrid extends GridPane {
    public GameGrid() {
        super();
        
        int colNum = GameEngine.settings().getGameGridWidth();
        int rowNum = GameEngine.settings().getGameGridHeight();
        
        // set specific number of columns and rows
        for (int i = 0; i < colNum; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100 / colNum);
            this.getColumnConstraints().add(col);
        } for (int i = 0; i < rowNum; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / rowNum);
            this.getRowConstraints().add(row);   
        }
       
    }
    
    /**
     * Update GameObjectCollection state in the grid
     */
    public void render(GameObjectCollection gameObjectCollection) {
        undraw();
        draw(gameObjectCollection);
    }
    
    /**
     * Remove old states of GameObjects from the grid
     */
    private void undraw() {
        Stack<ImageView> stack = new Stack<>();
        
        for(Node node : this.getChildren()) {
            if (node instanceof ImageView) {
                stack.push((ImageView)node);
            }
        }
        
        while (!stack.isEmpty()) {
            this.getChildren().remove(stack.pop());
        }
    }
    
    /**
     * Draw GameObjectCollection
     */
    private void draw(GameObjectCollection gameObjectCollection) {
        // draw allies
        gameObjectCollection.getAllies().forEach(
               ally -> 
               this.add(
                       ally.getSprite().getImage(),
                       ally.getX(),
                       ally.getY()
               )
       );
        
       // draw projectiles
       gameObjectCollection.getProjectiles().forEach(
               projectile -> 
               this.add(
                       projectile.getSprite().getImage(),
                       projectile.getX(),
                       projectile.getY()
               )
       );
       
       // draw aliens
       gameObjectCollection.getAliens().getListOfAliens().forEach(
               alien -> 
               this.add(
                       alien.getSprite().getImage(),
                       alien.getX(),
                       alien.getY()
               )
       );
    }
}
