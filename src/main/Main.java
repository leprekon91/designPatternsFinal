package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.database.DBUtils;
import main.json.JSONRead;

public class Main extends Application {

    /**
     * Start of the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Logger.Log("info", "Main", "Start up.");
        // get json
        JSONRead.readFile();
        // Init Database
        DBUtils.EnsureDatabase();
        // Init JavaFX Main Scene
        SceneManager.getInstance().start(primaryStage);
    }
}
