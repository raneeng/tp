package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.utils.Storage;

public class InvalidCommand extends Command {
    @Override
    public CommandResult execute() {
        throw new IllegalArgumentException("uh oh bad command");
    }
}
