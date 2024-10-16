package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Adds a flashcard to flashcard set.
 */
public class AddCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully added flashcard: \n%1$s";

    private Card cardToAdd;
    private FlashCardSet targetSet;

    public AddCommand(FlashCardSet module, String question, String answer) {
        cardToAdd = new Card(question, answer);
        this.targetSet = module;
    }

    public AddCommand(Card toAdd) {
        this.cardToAdd = toAdd;
    }

    public Card getCardToAdd() {
        return cardToAdd;
    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    @Override
    public CommandResult execute() {
        targetSet.addCard(cardToAdd);
        return new CommandResult(String.format(SUCCESS_MESSAGE, cardToAdd));
    }
}
