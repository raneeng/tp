package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;

/**
 * Displays flashcards for specified flashcard set.
 */
public class ViewCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashCardSet details
    public static final String SUCCESS_MESSAGE = "All flashcards have been displayed for set: %1$s";
    public String currentModule;

    private FlashCardSet targetSet;

    public ViewCommand(FlashCardSet module) {
        this.targetSet = module;
    }

    public void getModuleToView() {
        currentModule =  targetSet.getModuleName();
    }

    @Override
    public CommandResult execute(Storage storage) {
        getModuleToView(); 
        targetSet.viewFlashCards(currentModule);
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet));
    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }
}
