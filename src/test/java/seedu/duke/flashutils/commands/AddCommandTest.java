package seedu.duke.flashutils.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Parser;
import seedu.duke.flashutils.utils.Storage;

import static org.junit.jupiter.api.Assertions.*;

public class AddCommandTest {
    @Test
    public void testAddCommandConstructor() {
        String testQuestion = "Some question";
        String testAnswer = "Some answer";
        FlashCardSet testModule = new FlashCardSet("Some module");
        AddCommand command = new AddCommand(testModule, new Card(testQuestion, testAnswer));

        assertEquals(testQuestion, command.getCardToAdd().getQuestion());
        assertEquals(testAnswer, command.getCardToAdd().getAnswer());
        assertEquals(testModule, command.getTargetSet());
    }

    @Test public void testFlashcardActuallyAdded() {
        FlashCardSet testModule = new FlashCardSet("Some module");
        Card testCard = new Card("Some question", "Some answer");
        AddCommand command = new AddCommand(testModule, testCard);
        command.execute(new Storage("./data"));
        assertTrue(testModule.getFlashCardSet().contains(testCard));
    }

    @Test public void testAddMultipleFlashcards() {
        FlashCardSet testModule = new FlashCardSet("Some module");
        Card testCard1 = new Card("Question 1", "Answer 1");
        Card testCard2 = new Card("Question 2", "Answer 2");
        new AddCommand(testModule, testCard1).execute(new Storage("./data"));
        new AddCommand(testModule, testCard2).execute(new Storage("./data"));
        assertEquals(2, testModule.getFlashCardSet().size());
    }

    @Test
    public void testInvalidAddCommand() {
        Storage storage = new Storage("./data");
        String testString = "add --m  --t  --q  --a  ";
        assertThrows(IllegalArgumentException.class, () -> Parser.parseCommand(testString).execute(storage));
    }

    @Test public void testAddCommandNullFields() {
        FlashCardSet testModule = new FlashCardSet("Some module");
        assertThrows(NullPointerException.class, () -> new AddCommand(testModule, null, "Answer"));
        assertThrows(NullPointerException.class, () -> new AddCommand(testModule, "Question", null));
    }
}
