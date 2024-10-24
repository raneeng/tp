package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.utils.Storage;

public class    InvalidCommand extends Command {

    @Override
    public CommandResult execute(Storage storage) {
        throw new IllegalArgumentException("uh oh bad command");
    }
}
