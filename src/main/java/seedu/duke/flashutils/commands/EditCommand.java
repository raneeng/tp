package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Updates information in an existing flashcard.
 */
public class EditCommand extends Command {
    private Card cardToEdit;
    private Card newCard;
    private FlashCardSet targetSet;

    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully edited flashcard: %1$s";

    public EditCommand(FlashCardSet module, int cardIndex, String newQuestion, String newAnswer) {
        this.targetSet = module;
        this.cardToEdit = targetSet.getCard(cardIndex);
        this.newCard = new Card(newQuestion, newAnswer);
    }

    @Override
    public CommandResult execute() {
        cardToEdit.setQuestion(newCard.getQuestion());
        cardToEdit.setAnswer(newCard.getAnswer());
        return new CommandResult(String.format(SUCCESS_MESSAGE, cardToEdit));
    }
}
