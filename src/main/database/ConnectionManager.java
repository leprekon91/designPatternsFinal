package main.database;

public class ConnectionManager {
    private static ConnectionManager INSTANCE = null;

    public static ConnectionManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionManager();
                }
            }
        }
        return INSTANCE;
    }
}
