package view;

public class Logger {
    
    static String ANSI_RESET = "\u001B[0m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_BLUE = "\u001B[34m";

    public static void error(String message) {
        System.out.println(ANSI_RED);
        System.out.print("Sistema::");
        System.out.print(message);
        System.out.println(ANSI_RESET);
    }

    public static void success(String message) {
        System.out.println(ANSI_GREEN);
        System.out.print("Sistema::");
        System.out.print(message);
        System.out.println(ANSI_RESET);
    }

    public static void warning(String message) {
        System.out.println(ANSI_BLUE);
        System.out.print("Sistema::");
        System.out.print(message);
        System.out.println(ANSI_RESET);
    }

    public static void info(String message) {
        System.out.println(ANSI_YELLOW);
        System.out.print("--------------- " + message + " ---------------");
        System.out.println(ANSI_RESET);
    }

}
