package seedu.duke.flashutils.commands;

/**
 * Terminates the program.
 */
public class QuitCommand extends Command {
    @Override
    public CommandResult execute() {
        return new CommandResult("Quit Flash Session");
    }
}
