package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Removes flashcard from flashcard set.
 */
public class DeleteCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully deleted flashcard: %1$s";
    private Card targetCard;
    private FlashCardSet targetSet;

    public DeleteCommand(FlashCardSet module, int cardIndex) {
        targetSet = module;
        targetCard = targetSet.getCard(cardIndex);
    }

    @Override
    public CommandResult execute() {
        targetSet.removeCard(targetCard);
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetCard));
    }

}
