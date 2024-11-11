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
        int counter = 0;
        for (Card card : targetSet) {
            if ((byTopic && card.getTopic().contains(searchTerm))
                    || (card.getAnswer().toLowerCase().contains(searchTerm)
                    || card.getQuestion().toLowerCase().contains(searchTerm))) {
                matchingCards.append(++counter).append(". ").append(card).append("\n");
            }
        }
        if (matchingCards.isEmpty()) {
            return new CommandResult("No Cards found :(");
        } else {
            return new CommandResult(matchingCards.toString());
        }
    }
}
