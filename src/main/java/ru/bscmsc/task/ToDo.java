package ru.bscmsc.task;

import ru.bscmsc.task.command.Command;
import ru.bscmsc.task.command.ICommand;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private final Out out = new Out(System.out);
    private final In in = new In();
    private final List<Task> tasks = new ArrayList<>();

    public void exec() {
        out.printCommands();
        boolean quit = false;
        while (!quit) {
            out.selectCommand();
            String input = in.readCommand();
            ICommand command = controller(input);
            if (command != null) {
                quit = Command.QUIT.equals(command.exec(tasks, Helper.getParams(input)).getCommand());
            }
        }
    }

    private ICommand controller(String readCommand) {
        String[] pars = readCommand.trim().split(" ");

        if (pars[0].isEmpty()) {
            out.print("You have not entered a command\n");
            return null;
        }
        Command command = Command.byName(pars[0].toLowerCase());
        if (command != null) {
            return command.getCommand();
        } else {
            out.printNoSupported();
        }
        return null;
    }
}
