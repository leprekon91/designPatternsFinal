package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static SceneManager INSTANCE = new SceneManager();
    private Stage primaryStage = null;
    private String currentType;
    private SceneManager() {
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

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/Home.fxml"));
            primaryStage.setTitle("Insurance Inc. - Home");
            primaryStage.setScene(new Scene(root, 1024, 768));
            primaryStage.show();
            Logger.Log("success", "SceneManager", "JavaFX initialized. Showing Home screen.");
        } catch (IOException e) {
            Logger.Log("error", "SceneManager", "Error loading FXML File");
            e.printStackTrace();
        }

    }

    public String getCurrentType() {
        return currentType;
    }

    public void setCurrentType(String currentType) {
        this.currentType = currentType;
    }

    public void switchTo(String fxmlName, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/" + fxmlName + ".fxml"));
        primaryStage.setTitle("Insurance Inc. - " + title);
        primaryStage.show();
        primaryStage.setScene(new Scene(root));
        Logger.Log("success", "SceneManager", "Switching to screen: \"" + title + '"');
    }
}
