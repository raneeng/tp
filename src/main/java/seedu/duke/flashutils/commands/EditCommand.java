package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;

/**
 * Updates information in an existing flashcard.
 */
public class EditCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully edited flashcard: \n%1$s";

    private Card cardToEdit;
    private Card newCard;
    private FlashCardSet targetSet;

    public EditCommand(FlashCardSet module, int cardIndex, String newQuestion, String newAnswer) {
        this.targetSet = module;
        this.cardToEdit = targetSet.getCard(cardIndex);
        this.newCard = new Card(newQuestion, newAnswer);
    }

    @Override
    public CommandResult execute(Storage storage) {
        cardToEdit.setQuestion(newCard.getQuestion());
        cardToEdit.setAnswer(newCard.getAnswer());
        return new CommandResult(String.format(SUCCESS_MESSAGE, cardToEdit));
    }
}
