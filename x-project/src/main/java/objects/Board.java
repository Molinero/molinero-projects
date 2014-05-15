package objects;
import javafx.scene.layout.VBox;

/**
 * Created by SMelnik on 5/15/2014.
 */
public class Board extends VBox {
    private double width = 200;
    private double height = 350;

    public Board(){
        setMinSize(getBoardWidth(), getBoardHeight());
        setMaxSize(getBoardWidth(), getBoardHeight());
        setStyle("-fx-background-color:blue;");
    }

    public double getBoardWidth() {
        return width;
    }

    public double getBoardHeight() {
        return height;
    }

}