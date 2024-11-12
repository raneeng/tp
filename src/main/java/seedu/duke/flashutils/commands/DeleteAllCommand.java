package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;

public class DeleteAllCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashcard set details
    public static final String SUCCESS_MESSAGE = "Successfully deleted flashcard set: %1$s";

    private FlashCardSet targetSet;

    /**
     * Constructs a Delete Command with specified module and card index
     *
     * @param module FlashCardSet to perform DeleteCommand on
     */
    public DeleteAllCommand(FlashCardSet module) {
        targetSet = module;
    }

    /**
     * Gets the target module that has flashcard to be deleted
     *
     * @return The FlashCardSet to be deleted
     */
    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    /**
     * Prints result of the command,
     * which includes the success message and the Card to be deleted
     *
     * @return CommandResult containing String that contains success message
     */
    @Override
    public CommandResult execute() {
        targetSet.removeALlCards();
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet.getModuleName()));
    }
}
