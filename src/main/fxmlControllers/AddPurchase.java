package main.fxmlControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.Logger;
import main.SceneManager;
import main.database.DBUtils;
import main.database.Purchase;

import java.io.IOException;
import java.time.LocalDate;

public class AddPurchase {

    public Label titleLbl;
    public TextField nameFld;
    public TextField surnameFld;
    public TextArea remarksFld;
    public DatePicker dateFld;
    public Label statusLbl;

    public void initialize() {
        String type = SceneManager.getInstance().getCurrentType();
        titleLbl.setText("Add " + type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase() + " Insurance");
        dateFld.setValue(LocalDate.now());
    }

    public boolean validate() {
        if (nameFld.getText().trim() == "" || surnameFld.getText().trim() == "" || remarksFld.getText().trim() == "" || dateFld.getValue() == null) {
            statusLbl.setText("All fields are required!");
            return false;
        }
        statusLbl.setText("");
        return true;
    }

    public void backHome(ActionEvent actionEvent) {
        try {
            SceneManager.getInstance().switchTo("Home", "Insurance Inc. - Home");
        } catch (IOException e) {
            Logger.Log("error", "SceneManager", "Error loading Home Screen");
            e.printStackTrace();
        }
    }

    public void submitPurchase(ActionEvent actionEvent) {
        if (validate()) {

            Purchase purchase = new Purchase(nameFld.getText()
                    , surnameFld.getText()
                    , dateFld.getValue().toString()
                    , remarksFld.getText()
                    , SceneManager.getInstance().getCurrentType());

            DBUtils.insertPurchase(nameFld.getText()
                    , surnameFld.getText()
                    , dateFld.getValue().toString()
                    , remarksFld.getText()
                    , SceneManager.getInstance().getCurrentType());

            Logger.Log("info", "AddPurchase", "Added purchase to database: " + purchase);

            statusLbl.setText("Added new purchase;");
        }
    }
}
