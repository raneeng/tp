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
     * Displays all available commands for users
     */
    public static void displayCommands() {
        String availableCommands = "Available Commands: \n"
                                + " 1. Add a flashcard: \n"
                                + " \t add --m [Module Name] {--t [Topic] (optional)} --q [Question] --a [Answer] \n"
                                + " 2. View all flashcards of a module: \n"
                                + " \t view --m [Module Name] \n"
                                + " 3. View all flashcards: \n"
                                + " \t view --all\n"
                                + " 4. Delete a flashcard: \n"
                                + " \t delete --m [Module Name] --i [Index] \n"
                                + " 5. Edit a flashcard: \n"
                                + " \t edit --m [Module Name] --i [Index] —-q [New Question] —-a [New Answer] \n"
                                + " 6. Flashbang - view all the flashcards of a module without seeing the answers: \n"
                                + " \t flashbang --m [Module Name] --t [Time in ms]\n"
                                + " 7. Search for flashcards: \n"
                                + " \t search --m [Module Name] {/t (optional)} --s [Search Term] \n"
                                + " 8. Quit the app: \n"
                                + " \t quit \n";
        System.out.println(availableCommands);
    }

    /**
     * Prints welcome message when users enter the app 
     * The welcome message includes the app's logo and introduction
     */
    public static void welcomeMessage() {
        String logo = "FlashBang"; 
        String intro = "Welcome to the FlashBang app - learning your modules through engaging flashcards \n"; 
        System.out.println(logo + "\n" + intro); 
    }

    /**
     * Prints a formatted response to the console with line separators.
     *
     * @param text The message to be printed.
     */
    public static void printResponse(String text) {
        String lineSeparator = "_".repeat(50);
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

    /**
     * Prints the announcement to get the prompt from user
     * @param prompt
     */
    public static void displayGetNewPromptFromUser(String prompt) {
        System.out.println("Enter new "+prompt+" :");
    }

    /**
     * Prints the confirmation question
     * @param prompt
     */
    public static void displayConfirmationQuestion(String prompt) {
        System.out.println("Do you want to change "+prompt+" (y/n):");
    }

    /**
     * Prints the old value
     * @param prompt
     * @param value
     */
    public static void displayOldStoredValue(String prompt, String value) {
        System.out.println("Old "+prompt+" : "+value);
    }

}
