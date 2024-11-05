package seedu.duke.flashutils.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.StubStorage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlashbangCommandTest {

    @Test
    public void testFlashbangCommandConstructor() {
        FlashCardSet testModule = new FlashCardSet("Some module");
        FlashbangCommand command = new FlashbangCommand(testModule);
        assertEquals(testModule, command.getTargetSet());
    }

    @Test
    public void testSuccessfulFlashbangCommand() {
        FlashCardSet testModule = new FlashCardSet("Some module");
        testModule.addCard(new Card("Some question", "Some answer"));

        FlashbangCommand command = new FlashbangCommand(testModule);
        CommandResult result = command.execute(new StubStorage());

        String expectedMessage = "Successful FlashBang for flashcard set: \n" + testModule;
        assertEquals(expectedMessage, result.getFeedbackToUser());
    }

}
