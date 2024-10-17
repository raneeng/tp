package seedu.duke.flashutils.utils;

import seedu.duke.flashutils.commands.Command;
import seedu.duke.flashutils.commands.AddCommand;
import seedu.duke.flashutils.commands.DeleteCommand;
import seedu.duke.flashutils.commands.EditCommand;
import seedu.duke.flashutils.commands.FlashbangCommand;
import seedu.duke.flashutils.commands.InvalidCommand;
import seedu.duke.flashutils.commands.QuitCommand;
import seedu.duke.flashutils.commands.ViewCommand;

import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.types.FlashCardSet;

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

    public static Command createAddCommand(String input) {
        Pattern addPattern = Pattern.compile("--m\\s+(.+?)\\s+--q\\s+(.+?)\\s+--a\\s+(.+)");
        Matcher matcher = addPattern.matcher(input);
        if (matcher.find()) {
            String moduleName = matcher.group(1);
            FlashCardSet module = FlashBook.getInstance().getFlashCardSet(moduleName);
            String question = matcher.group(2);
            String answer = matcher.group(3);
            return new AddCommand(module, question, answer);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createDeleteCommand(String input) {
        Pattern deletePattern = Pattern.compile("--m\\s+(.+?)\\s+--i\\s+(\\d+)");
        Matcher matcher = deletePattern.matcher(input);
        if (matcher.find()) {
            String moduleName = matcher.group(1);
            FlashCardSet module = FlashBook.getInstance().getFlashCardSet(moduleName);
            int index = Integer.parseInt(matcher.group(2));
            return new DeleteCommand(module, index);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createEditCommand(String input) {
        Pattern editPattern = Pattern.compile("--m\\s+(.+?)\\s+--i\\s+(\\d+)\\s+(--q\\s+(.+?)\\s+--a\\s+(.+))?");
        Matcher matcher = editPattern.matcher(input);

        if (matcher.find()) {
            String moduleName = matcher.group(1);
            FlashCardSet module = FlashBook.getInstance().getFlashCardSet(moduleName);
            int index = Integer.parseInt(matcher.group(2));

            // Check if new question and answer are provided in the input
            if (matcher.group(4) != null && matcher.group(5) != null) {
                // Use the provided question and answer
                String newQuestion = matcher.group(4);
                String newAnswer = matcher.group(5);
                return new EditCommand(module, index, newQuestion, newAnswer);
            } else {
                // No question and answer provided; create EditCommand with prompts
                return new EditCommand(module, index);
            }
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createViewCommand(String input) {
        Pattern viewModulePattern = Pattern.compile("--m\\s+(.+)");
        Matcher matcher = viewModulePattern.matcher(input);
        if (matcher.find()) {
            String moduleName = matcher.group(1);
            FlashCardSet module = FlashBook.getInstance().getFlashCardSet(moduleName);
            return new ViewCommand(module);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createFlashbangCommand(String input) {
        Pattern flashbangPattern = Pattern.compile("--m\\s+(.+)");
        Matcher matcher = flashbangPattern.matcher(input);
        if (matcher.find()) {
            String moduleName = matcher.group(1);
            FlashCardSet module = FlashBook.getInstance().getFlashCardSet(moduleName);
            return new FlashbangCommand(module);
        } else {
            return new InvalidCommand();
        }
    }

    public static Command createQuitCommand() {
        return new QuitCommand();
    }
}
