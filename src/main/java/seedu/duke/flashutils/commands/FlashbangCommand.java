package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;


import java.util.Date;

/**
 * Starts a FlashBang session, where questions for each flashcard are displayed
 * and users can choose to display answers.
 */
public class FlashbangCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successful FlashBang for flashcard set: \n%1$s";
    private final FlashCardSet targetSet;
    private long timerThreshold;


    /**
     * Constructs the Flashbang Command with specified target set (module)
     * 
     * @param targetSet
     */
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

    /**
     * Prints result of the command, 
     * which includes the success message and the module to be displayed
     * 
     * @return The result of the command
     */
    @Override
    public CommandResult execute(Storage storage) {
        targetSet.performFlashBang();
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetSet));
    }
      
    public FlashCardSet getTargetSet() {
        return targetSet;
    }
}
