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
}
