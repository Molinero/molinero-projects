package objects;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

/**
 * Created by SMelnik on 5/19/2014.
 */
public class GameMapSegment implements GameObject  {
    private double segmentWidth = 100;
    private double segmentHeight = 100;
    private VBox segment;

    public VBox getSegment() {
        segment = new VBox();
        segment.setMaxSize(getSegmentWidth(), getSegmentHeight());
        segment.setMinSize(getSegmentWidth(), getSegmentHeight());
        segment.getStyleClass().add("game-map-segment");
        Tooltip tooltip = new Tooltip("Choose the place for building");
        return segment;
    }

    public double getSegmentWidth() {
        return segmentWidth;
    }

    public double getSegmentHeight() {
        return segmentHeight;
    }

    @Override
    public void setCoordinates(int x, int y) {

    }

    @Override
    public int getCoordinateX() {
        return 0;
    }

    @Override
    public int getCoordinateY() {
        return 0;
    }

    @Override
    public void setCoordinateX(int x) {

    }

    @Override
    public void setCoordinateY(int y) {

    }
}
