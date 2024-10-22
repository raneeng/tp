package seedu.duke.flashutils.utils;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Storage {
    private final File directory;

    public Storage(String directoryPath) {
        this.directory = new File(directoryPath);
        createDir();
    }

    private void createDir() {
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

    private Card cardFormatter(String line) {
        Pattern cardPattern = Pattern.compile(
                "(.+?)\\s*\\|\\s*(.+?)\\s*\\|\\s*(.+?)?");
        Matcher cardMatcher = cardPattern.matcher(line);
        if (cardMatcher.matches()) {
            String question = cardMatcher.group(1);
            String answer = cardMatcher.group(2);
            String topic = cardMatcher.group(3);
            return new Card(question, answer, topic);
        }
        return null;
    }

    private FlashCardSet readFlashCardSetFromFile(String module, File flashCardSetFile) throws IOException {

        ArrayList<Card> cards = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(flashCardSetFile);
            while (scanner.hasNext()) {
                Card card = cardFormatter(scanner.nextLine());
                cards.add(card);
            }
            scanner.close();
        } catch (IOException e) {
            throw new IOException("An error occurred while reading from the file.");
        }
        return new FlashCardSet(module,cards);
    }

    private void createFile(File file) {
        try {
            if(!file.exists()){
                if(!file.createNewFile()){
                    throw new IOException("Could not create file");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeFlashBookToFile(FlashBook flashBook){
        flashBook.getAllFlashCardSets().forEach((module, flashCardSet)-> {
            File flashCardSetFile = new File(directory, module+".txt");
            createFile(flashCardSetFile);
            try {
                FileWriter fileWriter = new FileWriter(flashCardSetFile.getPath());
                for (Card card : flashCardSet.getFlashCardSet()) {
                    fileWriter.write(card.toWritableString()+"\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file. ");
            }
        });
    }

    public HashMap<String, FlashCardSet> readFlashCardsFromFile() throws IOException {
        HashMap<String, FlashCardSet> flashCard = new HashMap<>();
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                String module = file.getName().split("\\.")[0];
                flashCard.put(module,readFlashCardSetFromFile(module, file));
            }
        } else {
            System.out.println("No text files found in the directory.");
        }

        return flashCard;
    }

}


