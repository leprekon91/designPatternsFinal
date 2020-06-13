package main;
/*

 * @startuml

 * car --|> wheel

 * @enduml

 */

import javafx.application.Application;
import javafx.stage.Stage;
import main.database.DBUtils;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Logger.Log("info", "Main", "Start up.");
        // Init Database
        DBUtils.EnsureDatabase();
        // Init JavaFX Main Scene
        SceneManager.getInstance().start(primaryStage);
    }
}
