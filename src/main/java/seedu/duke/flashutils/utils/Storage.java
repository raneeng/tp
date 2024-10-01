package seedu.duke.flashutils.utils;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {
    private final File directory;

    Storage(String directoryPath) {
        this.directory = new File(directoryPath);
        createDir();
    }

    public void createDir() {
        try {
            if(!directory.exists()){
                if(!directory.mkdirs()){
                    throw new IOException("Could not create directory");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Card cardFormatter(String line){
        String[] lineArgs = line.split(",");
        return new Card(lineArgs[0],lineArgs[1]);
    }

    private FlashCardSet readFlashCardSetFromFile(String module, File flashCardSetFile) throws IOException {

        ArrayList<Card> cards = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(flashCardSetFile);
            while (scanner.hasNext()) {
                Card card = cardFormatter(scanner.nextLine());
                cards.add(card);
            }
        } catch (IOException e) {
            throw new IOException("An error occurred while reading from the file.");
        }
        return new FlashCardSet(module,cards);
    }

    public HashMap<String, FlashCardSet> readFlashCardsFromFile() throws IOException {
        HashMap<String, FlashCardSet> flashCard = new HashMap<>();
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                String module = file.getName().split(".")[0];
                flashCard.put(module,readFlashCardSetFromFile(module, file));
            }
        } else {
            System.out.println("No text files found in the directory.");
        }

        return flashCard;
    }

}


