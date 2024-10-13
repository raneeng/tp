package seedu.duke.flashutils.commands;


/**
 * Displays flashcards for specified flashcard set.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    // Confirmation message to be displayed to user, with placeholder for flashCardSet details
    public static final String SUCCESS_MESSAGE = "All flashcards have been displayed for set: %1$s";

    public ViewCommand() {
    }

    @Override
    public CommandResult execute() {
        targetSet.viewFlashCards();
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet));
    }
}
