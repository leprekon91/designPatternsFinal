package main;

import main.database.DBUtils;
import main.json.JSONRead;

public class StartupFacade {
    public static void Startup() {
        Logger.Log("warning", "Startup", "Attempting read of config file...");
        JSONRead.readFile();
        Logger.Log("warning", "Startup", "Ensuring Database...");
        DBUtils.EnsureDatabase();
        Logger.Log("success", "Startup", "Database and config init have passed.");
    }
}
