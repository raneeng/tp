package seedu.duke.flashutils.commands;

import seedu.duke.Flashbang;
import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Adds a flashcard to flashcard set.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully added flashcard: %1$s";

    private Card toAdd;

    // Constructors
    public AddCommand(String Question, String Answer) {
        this.toAdd = new Card(Question, Answer);
    }

    public AddCommand(Card toAdd) {
        this.toAdd = toAdd;
    }

    @Override
    public CommandResult execute() {
        targetSet.addCard(toAdd);
        return new CommandResult(String.format(SUCCESS_MESSAGE, toAdd));
    }

}
