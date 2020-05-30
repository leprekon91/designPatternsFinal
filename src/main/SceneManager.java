package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private Stage primaryStage = null;
    private static SceneManager INSTANCE = new SceneManager();

    private SceneManager() {
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/Home.fxml"));
            primaryStage.setTitle("Insurance Inc.");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.setFullScreen(true);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error loading FXML File");
            e.printStackTrace();
        }

    }

    public void switchTo(String fxmlname) {

    }

    public static SceneManager getInstance() {
        if (INSTANCE == null) {
            synchronized (SceneManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SceneManager();
                }
            }
        }
        return INSTANCE;
    }
}
