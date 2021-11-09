package ru.bscmsc.task;

import ru.bscmsc.task.command.Command;
import ru.bscmsc.task.command.ICommand;

public class ToDo {
    private final In in = new In();


    public void exec() {
        Out.getInstance().printCommands();
        boolean quit = false;
        while (!quit) {
            Out.getInstance().selectCommand();
            String input = in.readCommand();
            ICommand command = controller(input);
            if (command != null) {
                command.exec(Helper.getParams(input));
                quit = Command.QUIT == command.getCommand();
            }
        }
    }

    private ICommand controller(String readCommand) {
        String[] pars = readCommand.trim().split(" ");

        if (pars[0].isEmpty()) {
            Out.getInstance().print("You have not entered a command");
            return null;
        }
        Command command = Command.byName(pars[0].toLowerCase());
        if (command != null) {
            return command.getCommand();
        } else {
            Out.getInstance().printNoSupported();
        }
        return null;
    }
}
