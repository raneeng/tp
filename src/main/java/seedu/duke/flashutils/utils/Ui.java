package seedu.duke.flashutils.utils;

import java.util.Scanner;

/**
 * A class responsible for handling user interaction and displaying information to the console.
 * It provides methods to display responses, get user input, and format the output.
 */
public class Ui {
    private static Scanner scanner;

    /**
     * Initializes the scanner object for reading user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prints a formatted response to the console with line separators.
     *
     * @param text The message to be printed.
     */
    public static void printResponse(String text) {
        String lineSeparator = "____________________________________________________________";
        text = lineSeparator +  "\n" + text + "\n" + lineSeparator + "\n";
        String formattedText = text.replaceAll("(?m)^", "\t");
        System.out.print(formattedText);
    }

    /**
     * Retrieves a user's input from the console.
     *
     * @return The raw string input from the user.
     */
    public static String getRequest() {
        return scanner.nextLine();
    }
}
