package objects;

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * Created by SMelnik on 5/28/2014.
 */
public class XPanel extends VBox {
    public XPanel(){
        setMinWidth(200);
        getStyleClass().add("panel");
        getChildren().add(getListOfUnits());
    }

    private ListView<String> getListOfUnits(){
        ListView<String> boxListView = new ListView<String>();
        boxListView.getItems().addAll(
                XUnits.TOWER.toString(),
                XUnits.CASTLE.toString(),
                XUnits.HOUSE.toString()
        );
        return boxListView;
    }
}
