package seedu.duke.flashutils.commands;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    // The feedback message displayed to user after command is executed
    public String feedbackToUser;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

}
