package seedu.duke.flashutils.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private final String directoryPath = "./data";
    private final File testFile = new File(directoryPath+"/FunModule.txt");

    @Test
    void writeAndReadFlashCardsTest() throws IOException {
        Storage storage = new Storage("./data");
        FlashBook flashBook = FlashBook.getInstance();
        flashBook.addFlashCardSet("FunModule");
        FlashCardSet testSet = flashBook.getFlashCardSet("FunModule");
        testSet.addCard(new Card("is water wet?", "no?", "wetness"));
        storage.writeFlashBookToFile(flashBook);
        assertTrue(testFile.exists());
        Scanner scanner;
        try {
            scanner = new Scanner(testFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertEquals("is water wet? | no? | wetness", scanner.nextLine());
        HashMap<String, FlashCardSet> testBook;
        try {
            testBook = storage.readFlashCardsFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FlashCardSet testSet2 = testBook.get("FunModule");
        FlashCardSet actualSet = flashBook.getFlashCardSet("FunModule");
        assertTrue(testSet2.getCard(0).getAnswer().equals(actualSet.getCard(0).getAnswer())
                && testSet2.getCard(0).getQuestion().equals(actualSet.getCard(0).getQuestion()));
        scanner.close();
        if (Files.deleteIfExists(testFile.toPath())) {
            System.out.println("file deleted successfully");
        } else {
            System.out.println("error");
        }
    }
}