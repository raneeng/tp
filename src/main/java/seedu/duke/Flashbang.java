package seedu.duke;

import seedu.duke.flashutils.commands.Command;
import seedu.duke.flashutils.commands.CommandResult;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.utils.Parser;
import seedu.duke.flashutils.utils.Storage;
import seedu.duke.flashutils.utils.Ui;

import java.io.IOException;

public class Flashbang {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    private Ui ui;
    private Storage storage;
    private FlashBook flashBook;

    private Flashbang(String dataPath) {
        ui = new Ui();
        storage = new Storage(dataPath);
        try {
            FlashBook.setInstance(storage.readFlashCardsFromFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        flashBook = FlashBook.getInstance();
    }

    private void run() {
        String input = "";
        while (!input.equals("quit")) {
            try {
                input = Ui.getRequest();
                Command command = Parser.parseCommand(input);
                CommandResult result = command.execute(storage);
                Ui.printResponse(result.feedbackToUser);
            } catch (IllegalArgumentException e) {
                Ui.printResponse(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Flashbang("./data").run();

    }
}
