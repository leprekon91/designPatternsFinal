package main.database;

import main.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class answers for correct communication with the Database
 */
public class DBUtils {
    public static void EnsureDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(1);
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS purchases (name string,surname string,date string,remarks string)");
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

    public static void insertPurchase(String name, String surname, String date, String remarks) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into purchases values('" + name + "', '" + surname + "','" + date + "','" + remarks + "')");
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
}
