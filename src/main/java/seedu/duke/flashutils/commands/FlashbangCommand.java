package seedu.duke.flashutils.commands;

/**
 * Starts a FlashBang session, where questions for each flashcard are displayed
 * and users can choose to display answers.
 */
public class FlashbangCommand extends Command {

    public static final String COMMAND_WORD = "flashbang";

    // Confirmation message to be displayed to user, with placeholder for flashCardSet details
    public static final String SUCCESS_MESSAGE = "Congrats! You have completed FLASHBANG for set: %1$s";

    @Override
    public CommandResult execute() {
        targetSet.flashBang();
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet));
    }

}
