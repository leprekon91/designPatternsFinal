package main.fxmlControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import main.Logger;
import main.SceneManager;
import main.json.Configuration;

import java.io.IOException;

/**
 * Main screen home page controller
 */
public class Home {

    public Label configLbl;

    /**
     * Initialize the config Label from the configuration data
     */
    public void initialize() {
        configLbl.setText("Version: " + Configuration.getInstance().getVersion() + ", Developer(s): " + Configuration.getInstance().getName1() + ", " + Configuration.getInstance().getName2());
    }

    /**
     * Navigate to Cars purchase screen
     *
     * @param actionEvent Click event Cars button
     */
    public void goToCars(ActionEvent actionEvent) {
        goToAddPurchaseScreen("cars");
    }

    /**
     * Navigate to life purchase screen
     *
     * @param actionEvent Click event Life button
     */
    public void goToLife(ActionEvent actionEvent) {
        goToAddPurchaseScreen("life");
    }

    /**
     * Navigate to Apartments purchase screen
     *
     * @param actionEvent Click event Apartments button
     */
    public void goToApartments(ActionEvent actionEvent) {
        goToAddPurchaseScreen("apartments");
    }

    /**
     * Navigate to Health purchase screen
     *
     * @param actionEvent Click event Health button
     */
    public void goToHealth(ActionEvent actionEvent) {
        goToAddPurchaseScreen("health");
    }

    /**
     * Go to specified screen
     *
     * @param type type of purchase
     */
    public void goToAddPurchaseScreen(String type) {
        try {
            SceneManager.getInstance().setCurrentType(type);
            SceneManager.getInstance().switchTo("AddPurchase", "Add " + type + " Insurance Purchase");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.Log("error", "Home", "Error switching to " + type + " screen.");
        }

    }

    /**
     * Navigate to the datatable screen
     *
     * @param actionEvent Click event List button
     */
    public void goToList(ActionEvent actionEvent) {
        try {
            SceneManager.getInstance().switchTo("ListPurchases", "List of all purchases");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.Log("error", "Home", "Error switching to purchases list screen.");
        }
    }
}
