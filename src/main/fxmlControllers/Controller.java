package main.fxmlControllers;

import javafx.event.ActionEvent;
import main.SceneManager;

import java.io.IOException;

public class Controller {
    public void gotoscreentwo(ActionEvent actionEvent) {
        try {
            SceneManager.getInstance().switchTo("Screen2", "Second Screen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
