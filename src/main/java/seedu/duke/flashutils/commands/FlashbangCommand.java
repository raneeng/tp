package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;

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
    public CommandResult execute() {
        return new CommandResult("Flashbang successfully executed");
    }
}
