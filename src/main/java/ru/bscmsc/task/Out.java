package ru.bscmsc.task;

import lombok.extern.slf4j.Slf4j;
import ru.bscmsc.task.command.Command;

@Slf4j
public class Out {
    private static Out out;

    public static Out getInstance() {
        if (out == null) {
            out = new Out();
        }
        return out;
    }

    public void print(String message) {
        log.debug(message);
    }

    public void printCommands() {
        StringBuilder str = new StringBuilder("Available commands:");
        for (Command command : Command.values()) {
            str.append(String.format("%n%d. %s - %s.", command.ordinal() + 1, command.getNameCommand(), command.getDescription()));
        }
        print(str.toString());
    }

    public void selectCommand() {
        print("Select command -> ");
    }

    public void printNoSupported() {
        printError("The entered command is not supported.");
    }

    public void printError(String message) {
        log.error(message);
    }

    public void printError(String message, Throwable e) {
        log.error(message, e);
    }
}
