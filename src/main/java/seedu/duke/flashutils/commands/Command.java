package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Represents an executable command.
 */
public class Command {
    protected FlashCardSet targetSet;
    protected int targetIndex;

    protected Command() {
    }

    /**
     * Executes the command and returns the result.
     */
    public CommandResult execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    public int getTargetIndex() {
        return targetIndex;
    }

    public void setTargetSet(FlashCardSet targetSet) {
        this.targetSet = targetSet;
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }

}
