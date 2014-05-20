package objects;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sun.rmi.runtime.Log;

import java.io.*;
import java.util.List;
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
            FileReader fr = new FileReader(new File("jsons/map1.json"));
            BufferedReader br = new BufferedReader(fr);
            Gson gson = new Gson();
            gameMapStructure = gson.fromJson(br, GameMapStructure.class);
            System.out.println(gameMapStructure.getMapStructure().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<List> n = gameMapStructure.getMapStructure();

        for(int i = 0; i < gameMapSize; i ++){
            for(int j = 0; j < gameMapSize; j ++){
                if(Integer.parseInt(n.get(j).get(i).toString()) == 1) {
                    add(new GameMapSegment().getSegment(), i, j);
                }
            }
        }
    }
}