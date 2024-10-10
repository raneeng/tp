package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;

/**
 * Removes flashcard from flashcard set.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully deleted flashcard: %1$s";

    // Constructor
    public DeleteCommand(int targetIndex) {
        super(targetIndex);
    }

    @Override
    public CommandResult execute() {
        final Card targetCard = getTargetCard();
        targetSet.removeCard(targetCard);
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetCard));
    }

}
