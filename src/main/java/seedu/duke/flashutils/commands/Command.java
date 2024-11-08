package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.utils.Storage;

/**
 * Represents an executable command.
 */
public abstract class Command {
    
    /**
     * Executes the command and returns the result.
     */
    public abstract CommandResult execute();
}
