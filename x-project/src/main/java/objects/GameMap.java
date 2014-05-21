package objects;
import com.google.gson.Gson;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.BufferedReader;
import java.io.FileReader;
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
        for(int i = 0; i < gameMapSize; i++){
            ColumnConstraints column = new ColumnConstraints();
            RowConstraints row = new RowConstraints();
            getRowConstraints().add(row);
            getColumnConstraints().add(column);
        }
    }

    public void fillTheGameMap(){
        GameMapStructure gameMapStructure = new GameMapStructure();

        try {
            String mapUrl = getMapConfigurationFile();
            if(mapUrl != null){
                BufferedReader br = new BufferedReader(new FileReader(mapUrl));
                gameMapStructure = new Gson().fromJson(br, GameMapStructure.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int[][] n = gameMapStructure.getMapStructure();

        for(int i = 0; i < gameMapSize; i ++){
            for(int j = 0; j < gameMapSize; j ++){
                if(n[j][i] == 1) {
                    add(new GameMapSegment().getSegment(), i, j);
                }
            }
        }
    }

    private String getMapConfigurationFile(){
        int[] mapIds = {0, 1, 2};
        String configUrl = null;
        if(new Random().nextInt(mapIds.length) == 0) {
            configUrl = "jsons/map1.json";
        } else if(new Random().nextInt(mapIds.length) == 1) {
            configUrl = "jsons/map2.json";
        }
        return configUrl;
    }
}