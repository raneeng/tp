package seedu.duke.flashutils.types;

import java.util.ArrayList;

public class FlashCardSet {

    private final ArrayList<Card> flashCardSet;
    private final String module;

    public FlashCardSet(String module) {
        this.module = module;
        this.flashCardSet = new ArrayList<>();
    }

    public FlashCardSet(String module, ArrayList<Card> flashCardSet) {
        this.module = module;
        this.flashCardSet = flashCardSet;
    }

    public String getModule() {
        return this.module;
    }

    public ArrayList<Card> getFlashCardSet() {
        return this.flashCardSet;
    }

    public void addCard(Card toAdd) {
        // TODO
    }
}
