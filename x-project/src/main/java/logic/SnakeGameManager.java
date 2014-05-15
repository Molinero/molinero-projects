package logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import objects.Board;

/**
 * Created by SMelnik on 5/15/2014.
 */
public class SnakeGameManager extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SnakeGame");
        StackPane root = new StackPane();
        root.getChildren().add(new Board());
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
}