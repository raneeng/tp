package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;
import seedu.duke.flashutils.utils.Ui;

/**
 * Starts a FlashBang session, where questions for each flashcard are displayed
 * and users can choose to display answers.
 */
public class FlashbangCommand extends Command {
    private FlashCardSet targetSet;

    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successful FlashBang for flashcard set: \n%1$s";

    public FlashbangCommand(FlashCardSet targetSet) {
        this.targetSet = targetSet;
    }

    @Override
    public CommandResult execute(Storage storage) {
        targetSet.performFlashBang();
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet));

    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }
}
