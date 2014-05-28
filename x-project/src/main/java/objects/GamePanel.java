package objects;

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * Created by SMelnik on 5/28/2014.
 */
public class GamePanel extends VBox {
    public GamePanel(){
        setMinWidth(200);
        getStyleClass().add("panel");
        getChildren().add(getListOfUnits());
    }

    private ListView<String> getListOfUnits(){
        ListView<String> boxListView = new ListView<String>();
        boxListView.getItems().addAll(
                Units.TOWER.toString(),
                Units.CASTLE.toString(),
                Units.HOUSE.toString()
        );
        return boxListView;
    }
}
