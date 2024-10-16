package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;
import seedu.duke.flashutils.utils.Ui;

/**
 * Starts a FlashBang session, where questions for each flashcard are displayed
 * and users can choose to display answers.
 */
public class FlashbangCommand extends Command {
    private FlashCardSet targetSet;

    public FlashbangCommand(FlashCardSet targetSet) {
        this.targetSet = targetSet;
    }

    @Override
    public CommandResult execute(Storage storage) {
        int no = 0;
        for (Card card : targetSet) {
            Ui.printResponse("Flashcard no." + no + "\n\t" + card.getQuestion());
            Ui.printResponse("Reveal the answer? (y/n)");
            String ans = Ui.getRequest();
            if (ans.equals("y")) {
                Ui.printResponse("Answer:\n\t" + card.getAnswer());
            }
            no++;
        }
        return new CommandResult("Successful flashbang.");
    }
}
