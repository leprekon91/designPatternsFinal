package main.fxmlControllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Logger;
import main.SceneManager;
import main.database.DBUtils;
import main.database.Purchase;

import java.io.IOException;
import java.util.ArrayList;

public class ListPurchases {
    public TableView tableView;
    public TableColumn remarksCol;
    public TableColumn surnameCol;
    public TableColumn nameCol;
    public TableColumn dateCol;
    public TableColumn typeCol;

    private ObservableList<Purchase> purchases = DBUtils.getAllPurchases();

    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
        remarksCol.setCellValueFactory(new PropertyValueFactory<>("Remarks"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.setItems(purchases);
    }

    public void populateTable(ArrayList<Purchase> list) {

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
