package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;

/**
 * Starts a FlashBang session, where questions for each flashcard are displayed
 * and users can choose to display answers.
 */
public class FlashbangCommand extends Command {
    private FlashCardSet targetSet;

    public FlashbangCommand(FlashCardSet targetSet) {
        this.targetSet = targetSet;
    }


    @Override
    public CommandResult execute(Storage storage) {
        return new CommandResult("Flashbang successfully executed");
    }
}
