package seedu.duke.flashutils.types;

import java.util.ArrayList;

public class FlashCardSet {

    private final ArrayList<Card> flashCardSet;
    private final String module;

    public final static String DIVIDER = "___________________________________________________";

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

    public void removeCard(Card toRemove) {
        // TODO
    }

    // Displays all flashcards (view command) in FLashCardSet
    public void viewFlashCards() {
        // TODO
        System.out.println(DIVIDER);

        for (Card card : flashCardSet) {
            System.out.println(card);
            System.out.println(DIVIDER);
        }
    }

    public void flashBang() {
        // TODO
    }

}
