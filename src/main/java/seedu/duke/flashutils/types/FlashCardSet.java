package seedu.duke.flashutils.types;

import java.util.ArrayList;

public class FlashCardSet {

    private final ArrayList<Card> flashCardSet;
    private final String module;

    FlashCardSet(String module) {
        this.module = module;
        this.flashCardSet = new ArrayList<>();
    }

    public String getModule() {
        return this.module;
    }

    public ArrayList<Card> getFlashCardSet() {
        return this.flashCardSet;
    }
}
