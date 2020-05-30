package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstance().start(primaryStage);
        SampleJDBC.go();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
