package ru.bscmsc.task;

import ru.bscmsc.task.command.Command;

import java.io.PrintStream;

public class Out {
    private final PrintStream out;

    public Out(PrintStream printStream) {
        out = printStream;
    }

    public void printCommands() {
        print("Available commands:\n");
        for (Command command : Command.values()) {
            print(String.format("%d. %s - %s.\n", command.ordinal() + 1, command.getNameCommand(), command.getDescription()));
        }
    }

    public void print(String message) {
        out.print(message);
        out.flush();
    }

    public void selectCommand() {
        print("Select command -> ");
    }

    public void printNoSupported() {
        print("The entered command is not supported.\n");
    }
}
