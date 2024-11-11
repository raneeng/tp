package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

import java.util.HashMap;
import java.util.Map;

public class ViewAllCommand extends Command {
    @Override
    public CommandResult execute() {
        HashMap<String, FlashCardSet> sets = FlashBook.getInstance().getAllFlashCardSets();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, FlashCardSet> entry : sets.entrySet()) {
            sb.append("MODULE NAME: ").append(entry.getKey()).append("\n");
            for (Card card : entry.getValue()) {
                sb.append(card.toString()).append("\n\n");
            }
        }

        return new CommandResult(sb.toString());
    }
}
