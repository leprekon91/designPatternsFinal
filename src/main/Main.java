package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Start of the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start of JavaFX and our logic initialization.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Logger.Log("info", "Main", "Start up.");
        StartupFacade.Startup();
        // Init JavaFX Main Scene
        SceneManager.getInstance().start(primaryStage);
    }
}
