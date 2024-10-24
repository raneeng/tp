package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;
import seedu.duke.flashutils.utils.Ui;

import java.util.Date;

/**
 * Starts a FlashBang session, where questions for each flashcard are displayed
 * and users can choose to display answers.
 */
public class FlashbangCommand extends Command {
    private final FlashCardSet targetSet;
    private long timerThreshold;

    public FlashbangCommand(FlashCardSet targetSet) {
        this.targetSet = targetSet;
    }

    public FlashbangCommand(FlashCardSet targetSet,long timerThreshold) {
        this.targetSet = targetSet;
        this.timerThreshold = timerThreshold;
    }

    @Override
    public CommandResult execute(Storage storage) {
        Date start = new Date();
        Date recurring = new Date();
        int flashcardCounter = 0;
        for (Card card : targetSet) {
            Ui.printResponse("Flashcard no." + flashcardCounter + "\n\t" + card.getQuestion());
            Ui.printResponse("Reveal the answer? (y/n)");
            String ans = Ui.getRequest();
            if (ans.equals("y")) {
                Ui.printResponse("Answer:\n\t" + card.getAnswer());
            }
            flashcardCounter++;

            Date current = new Date();
            double timeSpentPerQuestion = Math.round((recurring.getTime()-current.getTime())/1000.00);
            Ui.printResponse("You spent "+timeSpentPerQuestion+"seconds reviewing this flashcard.");
            recurring = current;

            if(timerThreshold>0) {
                if (recurring.getTime() - start.getTime() > timerThreshold) {
                    Ui.printResponse("Oops You've run out of time! ");
                }
            }
        }

        return new CommandResult("Successful flashbang.");
    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }
}
