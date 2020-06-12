package main.fxmlControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import main.Logger;
import main.SceneManager;

import java.io.IOException;

public class AddPurchase {

    public Label titleLbl;

    public void initialize() {
        String type = SceneManager.getInstance().getCurrentType();
        titleLbl.setText("Add " + type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + " Insurance");
    }

    public void backHome(ActionEvent actionEvent) {
        try {
            SceneManager.getInstance().switchTo("Home", "Insurance Inc. - Home");
        } catch (IOException e) {
            Logger.Log("error", "SceneManager", "Error loading Home Screen");
            e.printStackTrace();
        }
    }
}
