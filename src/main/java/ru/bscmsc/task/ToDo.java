package ru.bscmsc.task;

import ru.bscmsc.task.command.*;

import java.util.Arrays;
import java.util.List;

public class ToDo {
    private final IInput in = new In();
    private final IOut out = new Out();
    private final ITasks tasks = new Tasks();
    private final List<ICommand> listCommand = Arrays.asList(new Add(tasks, out), new Delete(tasks, out),
            new Edit(tasks, out), new Print(tasks, out), new Quit(out),
            new Search(tasks, out), new Toggle(tasks, out));


    public void exec() {
        out.printCommands(listCommand);
        ICommand command;
        do {
            out.selectCommand();
            String input = in.readCommand();
            command = controller(input);
            command.exec(Helper.getParams(input));
        } while (!command.isName("quit"));
    }

    private ICommand controller(String readCommand) {
        String[] pars = readCommand.trim().split(" ");
        if (pars[0].isEmpty()) {
            out.printError("You have not entered a command");
            return new NotSupport(out);
        }
        return listCommand.stream().filter(c -> c.isName(pars[0].toLowerCase()))
                .findFirst().orElse(new NotSupport(out));
    }
}
