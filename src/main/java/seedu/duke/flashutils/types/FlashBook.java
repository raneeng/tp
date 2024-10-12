package seedu.duke.flashutils.types;

import java.util.HashMap;

/**
 * Represents the complete list of flashcards
 */
public class FlashBook {

    private final HashMap<String, FlashCardSet> allFlashCardSets;

    FlashBook(){
        this.allFlashCardSets = new HashMap<>();
    }

    FlashBook(HashMap<String, FlashCardSet> flashCards){
        this.allFlashCardSets = flashCards;
    }

    public FlashCardSet getFlashCardSet(String module) {
        return allFlashCardSets.get(module);
    }

}
