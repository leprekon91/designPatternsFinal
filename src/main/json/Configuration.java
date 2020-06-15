package main.json;

import main.Logger;
import org.json.simple.JSONObject;

/**
 * Configuration singleton for holding the config data
 */
public class Configuration {
    private static Configuration INSTANCE = null;

    private String version = null;
    private String name1 = null;
    private String name2 = null;

    /**
     * Read the JSON input.json file and construct the instance
     */
    private Configuration() {
        JSONObject file = JSONRead.readFile();
        Logger.Log("info", "Configuration", "Initializing Config");
        this.name1 = (String) file.get("student_name_1");
        this.name2 = (String) file.get("student_name_2");
        this.version = (String) file.get("version");
    }

    /**
     * Singleton implementation
     *
     * @return Instance of this Config object.
     */
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

    /**
     * Getter
     *
     * @return version of the app
     */
    public String getVersion() {
        return version;
    }

    /**
     * Getter
     *
     * @return Name of the first developer
     */
    public String getName1() {
        return name1;
    }

    /**
     * Getter
     *
     * @return Name of the second developer
     */
    public String getName2() {
        return name2;
    }
}