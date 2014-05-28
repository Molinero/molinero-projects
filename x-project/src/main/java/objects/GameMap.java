package objects;
import com.google.gson.Gson;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class GameMap extends GridPane {
    public GameMap(){
        getStyleClass().add("game-map");
        setGamMapStructure();
        setMinSize(800, 600);
        setScaleShape(true);
    }

    public void setGamMapStructure(){
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

        List<int[]> map = gameMapStructure.getMapStructure();

        for(int i = 0; i < map.size(); i++){
            ColumnConstraints column = new ColumnConstraints();
            RowConstraints row = new RowConstraints();
            for(int j = 0; j < map.get(i).length; j++){
                getRowConstraints().add(row);
                getColumnConstraints().add(column);
            }
        }

        for(int i = 0; i < map.size(); i ++){
            for(int j = 0; j < map.get(i).length; j ++){
                if(map.get(i)[j] == 1) {
                    add(new GameMapSegment().getSegment(), j, i);
                }
            }
        }
    }

    private String getMapConfigurationFile(){
        return "jsons/map2.json";
    }
}