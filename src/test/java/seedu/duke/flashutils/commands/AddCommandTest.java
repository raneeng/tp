package seedu.duke.flashutils.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCommandTest {

    @Test
    public void testAddCommandConstructor() {
        String testQuestion = "Some question";
        String testAnswer = "Some answer";
        FlashCardSet testModule = new FlashCardSet("Some module");
        AddCommand command = new AddCommand(testModule, testQuestion, testAnswer);

        assertEquals(testQuestion, command.getCardToAdd().getQuestion());
        assertEquals(testAnswer, command.getCardToAdd().getAnswer());

        assertEquals(testModule, command.getTargetSet());
    }

}
