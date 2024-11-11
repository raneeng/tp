package seedu.duke.flashutils.commands;

public class InvalidCommand extends Command {
    @Override
    public CommandResult execute() {
        throw new IllegalArgumentException("uh oh bad command");
    }
}
