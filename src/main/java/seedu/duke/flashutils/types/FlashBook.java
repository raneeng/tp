package seedu.duke.flashutils.types;

import java.util.HashMap;

public class FlashBook {

    private final HashMap<String, FlashCardSet> allFlashCardSets;

    FlashBook(){
        this.allFlashCardSets = new HashMap<>();
    }

    FlashBook(HashMap<String, FlashCardSet> flashCards){
        this.allFlashCardSets = flashCards;
    }

}
