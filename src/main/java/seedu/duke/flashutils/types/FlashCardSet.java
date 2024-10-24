package seedu.duke.flashutils.types;

import seedu.duke.flashutils.utils.Ui;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the list of flashcards of the same module
 */
public class FlashCardSet implements Iterable<Card> {

    private final ArrayList<Card> flashCardSet;
    private final String moduleName;

    public FlashCardSet(String module) {
        this.moduleName = module;
        this.flashCardSet = new ArrayList<>();
    }

    public FlashCardSet(String module, ArrayList<Card> flashCardSet) {
        this.moduleName = module;
        this.flashCardSet = flashCardSet;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public ArrayList<Card> getFlashCardSet() {
        return this.flashCardSet;
    }

    public Card getCard(int cardIndex) {
        if (cardIndex >= this.flashCardSet.size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.flashCardSet.get(cardIndex);
    }

    public void addCard(Card toAdd) {
        // TODO
        flashCardSet.add(toAdd);
    }

    public void removeCard(Card toRemove) {
        // TODO
        flashCardSet.remove(toRemove);
    }

    // Displays all flashcards (view command) in FLashCardSet
    public void viewFlashCards(String moduleName) {
        String currentModuleName = getModuleName();
        if (currentModuleName.equals(moduleName)) {
            for (Card flashCard : flashCardSet) {
                System.out.println(flashCard); 
            }
        } else {
            System.out.println("No flashcards found for this module."); 
        }
    }

    public void performFlashBang() {
        int num = 0;
        int correctAnswers = 0;
        int wrongAnswers = 0;

        for (Card card : flashCardSet) {
            Ui.printResponse("Flashcard no." + num + "\n\t" + card.getQuestion());
            Ui.printResponse("Reveal the answer? (y/n)");
            String revealAnswer = Ui.getRequest();
            if (revealAnswer.equals("y")) {
                Ui.printResponse("Answer:\n\t" + card.getAnswer());
            }

            // For tracking of correct/wrong answers
            Ui.printResponse("Did you get the correct answer? (y/n)");
            String answerCorrect = Ui.getRequest();
            if (answerCorrect.equals("y")) {
                correctAnswers++;

            } else if (answerCorrect.equals("n")) {
                wrongAnswers++;

            } else {
                Ui.printResponse("Please enter 'y' or 'n'.");

            }

            num++;
        }

        // Calculate percentage of right/wrong answers
        int totalAnswers = correctAnswers + wrongAnswers;
        double correctPercentage = (double) correctAnswers / totalAnswers * 100;
        Ui.printResponse("Your score is: " + correctPercentage + "% (" + correctAnswers + "/" + totalAnswers + ")");
    }

    @Override
    public Iterator<Card> iterator() {
        return flashCardSet.iterator();
    }
}
