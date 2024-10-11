package seedu.duke.flashutils.commands;

/**
 * Terminates the program.
 */
public class QuitCommand extends Command {

    public static final String COMMAND_WORD = "quit";

    // Exit confirmation message
    public static final String SUCCESS_MESSAGE = "Goodbye, see you soon! :-)\n";

    public QuitCommand() {
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(SUCCESS_MESSAGE);
    }

    public static boolean isQuit(Command command) {
        return command instanceof QuitCommand; // instanceof returns false if it is null
    }
}
