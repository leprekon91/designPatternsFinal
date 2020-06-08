package main.fxmlControllers;

import javafx.event.ActionEvent;
import main.SceneManager;

import java.io.IOException;

public class Screen2 {
    public void goBack(ActionEvent actionEvent) {
        try {
            SceneManager.getInstance().switchTo("Home", "Home Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
