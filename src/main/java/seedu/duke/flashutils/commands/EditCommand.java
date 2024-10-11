package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;

/**
 * Updates information in an existing flashcard.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    // Confirmation message to be displayed to user, with placeholder for Card details
    public static final String SUCCESS_MESSAGE = "Successfully edited flashcard. Updated flashcard: %1$s";

    public Card toEdit = getTargetCard();
    public String newQuestion = toEdit.getQuestion();
    public String newAnswer = toEdit.getAnswer();

    @Override
    public CommandResult execute() {
        toEdit.setQuestion(newQuestion);
        toEdit.setAnswer(newAnswer);
        return new CommandResult(String.format(SUCCESS_MESSAGE, toEdit));
    }
}
