package main;

import java.time.LocalDateTime;

/**
 * MainController controls connections to database and Current values for the FXML
 * Also does the logging on screen console
 */
public class Logger {


    // Console Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void Log(String tag, String className, String msg) {
        String fgColor = ANSI_WHITE;

        switch (tag) {
            case "info":
                fgColor = ANSI_BLUE;
                break;
            case "warning":
                fgColor = ANSI_YELLOW;
                break;
            case "error":
                fgColor = ANSI_RED;
                break;
            case "success":
                fgColor = ANSI_GREEN;
                break;
            default:
                fgColor = ANSI_RESET;
                break;
        }
        System.out.println(fgColor + "[" + tag + "]: |" + LocalDateTime.now() + "| " + className + " ::> " + msg + "\n" + ANSI_RESET);
    }


}
