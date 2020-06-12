package main;
/*

 * @startuml

 * car --|> wheel

 * @enduml

 */
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Logger.Log("info", "Main", "Start up.");
        SceneManager.getInstance().start(primaryStage);
        // Init Database

//        SampleJDBC.go();

    }
}
