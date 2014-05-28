package logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import objects.GameMap;
import objects.GamePanel;

import java.io.File;

public class GameManager extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("X-Game");

        ScrollPane scrollPane = new ScrollPane();
        SplitPane splitPane = new SplitPane();

        GamePanel panel = new GamePanel();
        GameMap gameMap = new GameMap();

        scrollPane.setContent(splitPane);
        splitPane.getItems().addAll(gameMap, panel);

        Scene scene = new Scene(scrollPane, 1024, 768);
        File css = new File("src/main/resources/css/x-project.css");
        String cssUrl = css.toURI().toString();
        try {
            scene.getStylesheets().add(cssUrl);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        stage.setScene(scene);
        stage.show();
    }
}