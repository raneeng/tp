package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

public class SearchCommand extends Command {
    private final String searchTerm;
    private final boolean byTopic;
    private final FlashCardSet targetSet;

    public SearchCommand(String searchTerm, boolean byTopic, FlashCardSet targetSet) {
        this.searchTerm = searchTerm;
        this.byTopic = byTopic;
        this.targetSet = targetSet;
    }

    @Override
    public CommandResult execute() {
        StringBuilder matchingCards = new StringBuilder();
        for (Card card : targetSet) {
            if (byTopic && card.getTopic().contains(searchTerm)) {
                matchingCards.append(card).append("\n");
            } else if (card.getAnswer().contains(searchTerm) || card.getQuestion().contains(searchTerm)) {
                matchingCards.append(card);
            }
        }
        if (matchingCards.isEmpty()) {
            return new CommandResult("No Cards found :(");
        } else {
            return new CommandResult(matchingCards.toString());
        }
    }
}
