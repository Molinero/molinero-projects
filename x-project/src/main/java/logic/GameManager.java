package logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import objects.GameMap;
import java.io.File;

/**
 * Created by SMelnik on 5/15/2014.
 */
public class GameManager extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("X-Game");
        ScrollPane scrollPane = new ScrollPane();
        GameMap gameMap = new GameMap();
        scrollPane.setContent(gameMap);
        Scene scene = new Scene(scrollPane, 800, 800);
        File css = new File("src/main/resources/css/x-project.css");
        String cssUrl = css.toURI().toString();
        try {
            scene.getStylesheets().add(cssUrl);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        gameMap.fillTheGameMap();
        stage.setScene(scene);
        stage.show();
    }
}