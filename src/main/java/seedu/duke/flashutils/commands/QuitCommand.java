package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.utils.Storage;

/**
 * Terminates the program.
 */
public class QuitCommand extends Command {
    
    /**
     * Prints result of the command, 
     * which includes the success message
     * 
     * @return The result of the command
     */
    @Override
    public CommandResult execute() {
        return new CommandResult("Quit Flash Session");
    }
}
