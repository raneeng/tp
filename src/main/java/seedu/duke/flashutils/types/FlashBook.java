package seedu.duke.flashutils.types;

import java.util.HashMap;

/**
 * Represents the complete list of flashcards
 */
public class FlashBook {

    private final HashMap<String, FlashCardSet> allFlashCardSets;

    public FlashBook(){
        this.allFlashCardSets = new HashMap<>();
    }

    public FlashBook(HashMap<String, FlashCardSet> flashCards){
        this.allFlashCardSets = flashCards;
    }

    public void addFlashCardSet(String module) {
        allFlashCardSets.put(module, new FlashCardSet(module));
    }

    public FlashCardSet getFlashCardSet(String module) {
        return allFlashCardSets.get(module);
    }

}
