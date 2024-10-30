package seedu.duke.flashutils.utils;

import seedu.duke.flashutils.commands.Command;
import seedu.duke.flashutils.commands.AddCommand;
import seedu.duke.flashutils.commands.DeleteCommand;
import seedu.duke.flashutils.commands.EditCommand;
import seedu.duke.flashutils.commands.FlashbangCommand;
import seedu.duke.flashutils.commands.InvalidCommand;
import seedu.duke.flashutils.commands.QuitCommand;
import seedu.duke.flashutils.commands.ViewCommand;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private enum CommandType { Add, Delete, Edit, View, FlashBang, Quit, Invalid }

    private static CommandType parseCommandType(String input) {
        String commandKeyword = "^(add|delete|edit|view|flashbang|quit)";
        Pattern commandPattern = Pattern.compile(commandKeyword);
        Matcher matcher = commandPattern.matcher(input);
        if (matcher.find()) {
            return switch (matcher.group(1).toLowerCase()) {
                case "add" -> CommandType.Add;
                case "delete" -> CommandType.Delete;
                case "edit" -> CommandType.Edit;
                case "view" -> CommandType.View;
                case "flashbang" -> CommandType.FlashBang;
                case "quit" -> CommandType.Quit;
                default -> CommandType.Invalid;
            };
        }
        return CommandType.Invalid;
    }

    public static Command parseCommand(String input) {
        CommandType commandType = parseCommandType(input);
        return switch (commandType) {
            case Add -> createAddCommand(input);
            case Delete -> createDeleteCommand(input);
            case Edit -> createEditCommand(input);
            case View -> createViewCommand(input);
            case FlashBang -> createFlashbangCommand(input);
            case Quit -> createQuitCommand();
            default -> new InvalidCommand();
        };
    }

    /**
     * Splits the given command string into fields based on the provided regular expression.
     *
     * <p>Example usage:</p>
     * <pre>{@code
     * String rawText = "event <eventname> /from <startDate> /to <endDate>";
     * String regex = "event\\s(.+)\\s/from\\s(.+)\\s/to\\s(.+)";
     * ArrayList<String> fields = extractFields(rawText, regex);
     * // Resulting fields = {<eventname>, <startDate>, <endDate>}
     * }</pre>
     *
     * @param rawText the whole, unaltered command input from the user
     * @param regex the regular expression used to capture command arguments
     * @return a list of fields extracted from the input text
     */
    private static ArrayList<String> extractFields(String rawText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawText);

        ArrayList<String> fields = new ArrayList<>();

        if (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                fields.add(matcher.group(i));
            }
        }

        return fields;
    }

    private static FlashCardSet getModule(String moduleName) {
        return FlashBook.getInstance().getFlashCardSet(moduleName);
    }

    public static Command createAddCommand(String input) {
        String addRegex = "--m\\s+(.+?)(?:\\s+--t\\s+(.+))?\\s+--q\\s+(.+?)\\s+--a\\s+(.+)";
        ArrayList<String> fields = extractFields(input, addRegex);

        if (fields.size() == 4) {
            String moduleName = fields.get(0);
            String topic = fields.get(1);
            String question = fields.get(2);
            String answer = fields.get(3);
            FlashCardSet module = getModule(moduleName);
            return new AddCommand(module, new Card(question, answer, topic));
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createDeleteCommand(String input) {
        String deleteRegex = "--m\\s+(.+?)\\s+--i\\s+(\\d+)";
        ArrayList<String> fields = extractFields(input, deleteRegex);

        if (fields.size() == 2) {
            String moduleName = fields.get(0);
            int index = Integer.parseInt(fields.get(1));

            FlashCardSet module = getModule(moduleName);
            return new DeleteCommand(module, index);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createEditCommand(String input) {
        String editRegex = "--m\\s+(.+?)\\s+--i\\s+(\\d+)(?:\\s+--q\\s+(.+?)\\s+--a\\s+(.+))?";
        ArrayList<String> fields = extractFields(input, editRegex);

        if (fields.size() == 4) {
            String moduleName = fields.get(0);
            int index = Integer.parseInt(fields.get(1));
            FlashCardSet module = getModule(moduleName);
            String newQuestion = fields.get(2);
            String newAnswer = fields.get(3);
            return new EditCommand(module, index, newQuestion, newAnswer);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createViewCommand(String input) {
        String viewRegex = "--m\\s+(.+)";
        ArrayList<String> fields = extractFields(input, viewRegex);

        if (fields.size() == 1) {
            String moduleName = fields.get(0);
            FlashCardSet module = getModule(moduleName);
            return new ViewCommand(module);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createFlashbangCommand(String input) {
        String flashbangRegex = "--m\\s+(.+)";
        ArrayList<String> fields = extractFields(input, flashbangRegex);

        if (fields.size() == 1) {
            String moduleName = fields.get(0);
            FlashCardSet module = getModule(moduleName);
            return new FlashbangCommand(module);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createQuitCommand() {
        return new QuitCommand();
    }
}

