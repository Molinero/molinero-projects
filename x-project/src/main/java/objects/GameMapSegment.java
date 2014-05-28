package objects;

import javafx.scene.layout.VBox;

public class GameMapSegment {
    private double segmentWidth = 70;
    private double segmentHeight = 70;
    private VBox segment;

    public VBox getSegment() {
        segment = new VBox();
        segment.setMaxSize(getSegmentWidth(), getSegmentHeight());
        segment.setMinSize(getSegmentWidth(), getSegmentHeight());
        segment.getStyleClass().add("game-map-segment");
        return segment;
    }

    public double getSegmentWidth() {
        return segmentWidth;
    }

    public double getSegmentHeight() {
        return segmentHeight;
    }
}