package ru.bscmsc.task1;

import java.io.PrintStream;
import java.util.List;

public class Out {
    private final PrintStream out = System.out;


    public void printCommands() {
        out.println("Available commands:");
        for (Command command : Command.values()) {
            out.printf("%d. %s - %s.%n", command.ordinal() + 1, command.getNameCommand(), command.getDescription());
        }
    }

    public void print(String message) {
        out.print(message);
    }

    public void selectCommand() {
        out.print("Select command -> ");
    }

    public void printSuccessfully() {
        out.println("The command was executed successfully");
    }

    public void printTasks(List<Task> tasks, boolean isPrintAll) {
        int i = 0;
        for (Task task : tasks) {
            i++;
            if (isPrintAll || !task.getIsComplete())
                out.printf("%d. [%c] %s %n", i, task.getIsComplete() ? 'x' : ' ', task.getDescription());
        }
    }

    public void printNoSupported() {
        out.println("The entered command is not supported");
    }
}
