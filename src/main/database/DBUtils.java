package main.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class answers for correct communication with the Database
 */
public class DBUtils {
    /**
     * Ensures the database exists, if not creates a new main.db file
     */
    public static void EnsureDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(1);
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS purchases (name string,surname string,date string,remarks string,type String)");
            Logger.Log("success", "DBUtils", "Database init success");
        } catch (SQLException e) {
            Logger.Log("error", "DBUtils", "Database insurance failed.");
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                Logger.Log("error", "DBUtils", "Database connection close failed.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Gets a purchase object and inserts it into the database
     *
     * @param name    First Name of the costumer
     * @param surname Last Name of the costumer
     * @param date    Date of purchase
     * @param remarks Remarks on the purchase
     * @param type    Insurance type string
     */
    public static void insertPurchase(String name, String surname, String date, String remarks, String type) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into purchases values('" + name + "', '" + surname + "','" + date + "','" + remarks + "','" + type + "')");
            Logger.Log("info", "DBUtils", "insert purchase for " + name + " " + surname);
        } catch (SQLException e) {
            Logger.Log("error", "DBUtils", "Database insert failed.");
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                Logger.Log("error", "DBUtils", "Database connection close failed.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Read database for all purchases
     *
     * @return ObservableList of all purchases from the database
     */
    public static ObservableList getAllPurchases() {
        Connection connection = null;
        String sql = "SELECT * FROM purchases";
        ArrayList<Purchase> result = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String date = rs.getString("date");
                String remarks = rs.getString("remarks");
                String type = rs.getString("type");
                result.add(new Purchase(name, surname, date, remarks, type));
            }
            Logger.Log("info", "DBUtils", "Pulled " + result.size() + " records of purchases.");
        } catch (SQLException e) {
            Logger.Log("error", "DBUtils", "Database select all failed.");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                Logger.Log("error", "DBUtils", "Database connection close failed.");
                System.err.println(e.getMessage());
            }
        }
        ObservableList data = FXCollections.observableList(result);
        return data;
    }
}
