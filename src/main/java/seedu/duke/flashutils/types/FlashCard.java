package seedu.duke.flashutils.types;

import java.util.ArrayList;
import java.util.HashMap;

public class FlashCard {

    private final HashMap<String, ArrayList<Card>> flashCards;

    FlashCard(){
        this.flashCards = new HashMap<>();
    }

    FlashCard(HashMap<String, ArrayList<Card>> flashCards){
        this.flashCards = flashCards;
    }

}
