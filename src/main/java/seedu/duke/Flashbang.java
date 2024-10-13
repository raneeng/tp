package seedu.duke;

import seedu.duke.flashutils.commands.Command;
import seedu.duke.flashutils.commands.CommandResult;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.utils.Parser;
import seedu.duke.flashutils.utils.Storage;

import java.io.IOException;
import java.util.Scanner;

public class Flashbang {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Storage storage = new Storage("./data");
        FlashBook flashBook = new FlashBook();
        try {
            flashBook = new FlashBook(storage.readFlashCardsFromFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String input = "";
        while (!input.equals("quit")) {
            input = scan.nextLine();
            Command command = Parser.parseUserInput(input, flashBook);
            CommandResult result = command.execute();
            System.out.println(result.feedbackToUser);
        }
    }
}
