package objects;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.Random;

/**
 * Created by SMelnik on 5/15/2014.
 */
public class GameMap extends GridPane {
    private int gameMapSize = 10;

    public GameMap(){
        getStyleClass().add("game-map");
        setGamMapStructure();
        setMinSize(800, 800);
    }

    private void setGamMapStructure(){
        for(int i = 0; i < getGameMapSize(); i++){
            ColumnConstraints column = new ColumnConstraints();
            RowConstraints row = new RowConstraints();
            getRowConstraints().add(row);
            getColumnConstraints().add(column);
        }
    }

    public void fillTheGameMap(){
        for(int i = 0; i < getGameMapSize(); i ++){
            for(int j = 0; j < getGameMapSize(); j ++){
                if(new Random().nextBoolean()) {
                    add(new GameMapSegment().getSegment(), i, j);
                }
            }
        }
    }

    public int getGameMapSize() {
        return gameMapSize;
    }
}