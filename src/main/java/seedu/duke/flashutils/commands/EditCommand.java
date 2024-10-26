package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;

import static seedu.duke.flashutils.utils.Ui.*;

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

    public EditCommand(FlashCardSet module, int cardIndex) {
        this.targetSet = module;
        this.cardToEdit = targetSet.getCard(cardIndex);
        this.newCard = getUpdatedQuestionAnswerFromUser(cardToEdit);
    }

    protected Card getUpdatedQuestionAnswerFromUser(Card cardToEdit) {
        this.newCard = new Card(cardToEdit.getQuestion(), cardToEdit.getAnswer());

        // Update question
        String updatedQuestion = updateField(cardToEdit.getQuestion(), "Question");
        newCard.setQuestion(updatedQuestion);

        // Update answer
        String updatedAnswer = updateField(cardToEdit.getAnswer(), "Answer");
        newCard.setAnswer(updatedAnswer);

        return newCard;
    }

    /**
     * Prompts the user to confirm if they want to update the specified field.
     * If the user confirms, it will prompt for new input until valid data is entered.
     *
     * @param oldFieldValue the current value of the field
     * @param fieldName the name of the field (e.g., "Question" or "Answer")
     * @return the updated value entered by the user
     */
    private String updateField(String oldFieldValue, String fieldName) {
        displayOldStoredValue(fieldName, oldFieldValue);
        displayConfirmationQuestion(fieldName);

        String confirmation = getRequest();

        if (confirmation.equalsIgnoreCase("y")) {
            String newFieldValue;
            do {
                displayGetNewPromptFromUser(fieldName);
                newFieldValue = getRequest();

                // Check if the new value is empty
                if (newFieldValue == null || newFieldValue.trim().isEmpty()) {
                    System.out.println(fieldName + " cannot be empty. Please try again.");
                }
            } while (newFieldValue == null || newFieldValue.trim().isEmpty());

            return newFieldValue;
        } else if (confirmation.equalsIgnoreCase("n")) {
            System.out.println("Alright, Noted! Using Old " + fieldName);
            return oldFieldValue; // Return the old value if the user opts not to change it
        } else {
            System.out.println("Sorry! Unknown option entered. Using Old " + fieldName);
            return oldFieldValue; // Return the old value in case of an unknown option
        }
    }


    @Override
    public CommandResult execute(Storage storage) {
        cardToEdit.setQuestion(newCard.getQuestion());
        cardToEdit.setAnswer(newCard.getAnswer());
        return new CommandResult(String.format(SUCCESS_MESSAGE, cardToEdit));
    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    public Card getCardToAdd() {
        return cardToEdit;
    }
}
