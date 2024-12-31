package order.utill;

import java.util.Scanner;

public class Console {

    private static Scanner scanner;

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }
}
