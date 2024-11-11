package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Removes flashcard from flashcard set.
 */
public class DeleteCommand extends Command {

    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully deleted flashcard: %1$s";

    public static final int INDEX_OFFSET = 1;

    private Card targetCard;
    private FlashCardSet targetSet;

    /**
     * Constructs a Delete Command with specified module and card index
     * 
     * @param module
     * @param cardIndex
     */
    public DeleteCommand(FlashCardSet module, int cardIndex) {
        targetSet = module;
        targetCard = targetSet.getCard(cardIndex - INDEX_OFFSET);
    }

    /**
     * Gets the target module that has flashcard to be deleted
     * 
     * @return The module having the flashcard to be deleted
     */
    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    /**
     * Gets the target card to be deleted 
     * @return The card to be deleted 
     */
    public Card getTargetCard() {
        return targetCard;
    }

    /**
     * Prints result of the command, 
     * which includes the success message and the Card to be deleted
     * 
     * @return The result of the command
     */
    @Override
    public CommandResult execute() {
        targetSet.removeCard(targetCard);
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetCard));
    }
}
