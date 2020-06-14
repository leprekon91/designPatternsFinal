package main.json;

import main.Logger;
import org.json.simple.JSONObject;

public class Configuration {
    private static Configuration INSTANCE = null;

    private String version = null;
    private String name1 = null;
    private String name2 = null;

    private Configuration() {
        JSONObject file = JSONRead.readFile();
        Logger.Log("info", "Configuration", "Initializing Config");
        this.name1 = (String) file.get("student_name_1");
        this.name2 = (String) file.get("student_name_2");
        this.version = (String) file.get("version");
    }

    public static Configuration getInstance() {
        if (INSTANCE == null) {
            synchronized (Configuration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Configuration();
                }
            }
        }

        return INSTANCE;
    }

    public String getVersion() {
        return version;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }
}