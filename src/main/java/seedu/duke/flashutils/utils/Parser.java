package seedu.duke.flashutils.utils;

import seedu.duke.flashutils.commands.AddCommand;
import seedu.duke.flashutils.commands.Command;
import seedu.duke.flashutils.commands.InvalidCommand;
import seedu.duke.flashutils.types.FlashBook;

public class Parser {
    public static Command parseUserInput(String input, FlashBook flashBook) {
        String[] splitInput = input.split(" ");
        switch (splitInput[0].toLowerCase()) {
        case "add":
            return prepareAdd(input, flashBook);
        default: return new InvalidCommand();
        }
    }
    private static Command prepareAdd(String input, FlashBook flashBook) {
            String module = input.substring(input.indexOf("--m") + 3, input.indexOf("--q") - 1);
            String question = input.substring(input.indexOf("--q") + 3, input.indexOf("--a") - 1);
            String answer = input.substring(input.indexOf("--a") + 3);
            if (flashBook.getFlashCardSet(module) == null) {
                flashBook.addFlashCardSet(module);
            }
            return new AddCommand(flashBook.getFlashCardSet(module), question, answer);
    }
}
