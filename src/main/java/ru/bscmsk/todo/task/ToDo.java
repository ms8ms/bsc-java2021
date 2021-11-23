package ru.bscmsk.todo.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.task.command.ICommand;
import ru.bscmsk.todo.task.command.NotSupport;

import java.util.List;

@Component
public class ToDo {
    @Autowired
    private IInput in;
    @Autowired
    private IOut out;
    @Autowired
    private ITasks tasks;
    @Autowired
    private List<ICommand> listCommand;


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
