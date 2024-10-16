package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Displays flashcards for specified flashcard set.
 */
public class ViewCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashCardSet details
    public static final String SUCCESS_MESSAGE = "All flashcards have been displayed for set: %1$s";

    private FlashCardSet targetSet;

    public ViewCommand(FlashCardSet module) {
        this.targetSet = module;
    }

    @Override
    public CommandResult execute() {
        targetSet.viewFlashCards();
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet.getModuleName()));
    }
}
