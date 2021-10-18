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

    public boolean printTasks(List<Task> tasks, boolean isPrintAll) {
        int i = 0;
        boolean isPrint = false;
        for (Task task : tasks) {
            i++;
            if (printTask(i, task, isPrintAll) && !isPrint) {
                isPrint = true;
            }
        }
        return isPrint;
    }

    public boolean printTask(int indexOf, Task task, boolean isPrintAll) {
        if (isPrintAll || !task.getIsComplete()) {
            out.printf("%d. [%c] %s %n", indexOf, task.getIsComplete() ? 'x' : ' ', task.getDescription());
            return true;
        } else return false;
    }

    public void printNoSupported() {
        out.println("The entered command is not supported");
    }
}
