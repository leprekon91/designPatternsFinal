package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Singleton class that manages the current stage and is called for switching between screens
 * Also, manages the current Insurance type when add purchase screen is loaded.
 */
public class SceneManager {
    private static SceneManager INSTANCE = new SceneManager();
    private Stage primaryStage = null;
    private String currentType;

    private SceneManager() {
    }

    /**
     * for Singleton Implementation
     *
     * @return Instance of the SceneManager
     */
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

    /**
     * Starts up the stage and main menu scene
     *
     * @param primaryStage Stage JFX object received from launch method
     */
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

    /**
     * Get current type of insurance, used to determine which insurance AddPurchase is processing
     *
     * @return currentType
     */
    public String getCurrentType() {
        return currentType;
    }

    /**
     * Set the current type of the insurance purchase
     *
     * @param currentType
     */
    public void setCurrentType(String currentType) {
        this.currentType = currentType;
    }

    /**
     * Switch to new screen
     *
     * @param fxmlName FXML file name (without extension suffix)
     * @param title    Title string to show in window title
     * @throws IOException throws File not found exception
     */
    public void switchTo(String fxmlName, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/" + fxmlName + ".fxml"));
        primaryStage.setTitle("Insurance Inc. - " + title);
        primaryStage.show();
        primaryStage.setScene(new Scene(root));
        Logger.Log("success", "SceneManager", "Switching to screen: \"" + title + '"');
    }
}
