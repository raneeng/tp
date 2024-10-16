package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.utils.Storage;

/**
 * Terminates the program.
 */
public class QuitCommand extends Command {
    @Override
    public CommandResult execute(Storage storage) {
        storage.writeFlashBookToFile(FlashBook.getInstance());
        return new CommandResult("Quit Flash Session");
    }
}
