package main.fxmlControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import main.Logger;
import main.SceneManager;
import main.json.Configuration;

import java.io.IOException;

public class HomeController {

    public Label configLbl;

    public void initialize() {
        configLbl.setText("Version: " + Configuration.getInstance().getVersion() + ", Developer(s): " + Configuration.getInstance().getName1() + ", " + Configuration.getInstance().getName2());
    }

    public void goToCars(ActionEvent actionEvent) {
        goToAddPurchaseScreen("cars");
    }

    public void goToLife(ActionEvent actionEvent) {
        goToAddPurchaseScreen("life");
    }

    public void goToApartments(ActionEvent actionEvent) {
        goToAddPurchaseScreen("apartments");
    }

    public void goToHealth(ActionEvent actionEvent) {
        goToAddPurchaseScreen("health");
    }

    public void goToAddPurchaseScreen(String type) {
        try {
            SceneManager.getInstance().setCurrentType(type);
            SceneManager.getInstance().switchTo("AddPurchase", "Add " + type + " Insurance Purchase");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.Log("error", "HomeController", "Error switching to " + type + " screen.");
        }

    }

    public void goToList(ActionEvent actionEvent) {
        try {
            SceneManager.getInstance().switchTo("ListPurchases", "List of all purchases");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.Log("error", "HomeController", "Error switching to purchases list screen.");
        }
    }
}
