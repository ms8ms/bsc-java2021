package ru.bscmsc.task;

import ru.bscmsc.task.command.ICommand;
import ru.bscmsc.task.command.NotSupport;

public class ToDo {
    private final Bean bean = new Bean();


    public void exec() {
        bean.getOut().printCommands(bean.getListCommand());
        ICommand command;
        do {
            bean.getOut().selectCommand();
            String input = bean.getIn().readCommand();
            command = controller(input);
            command.exec(Helper.getParams(input));
        } while (!command.isName("quit"));
    }

    private ICommand controller(String readCommand) {
        String[] pars = readCommand.trim().split(" ");
        if (pars[0].isEmpty()) {
            bean.getOut().print("You have not entered a command");
            return new NotSupport(bean);
        }
        return bean.getListCommand().stream().filter(c -> c.isName(pars[0].toLowerCase()))
                .findFirst().orElse(new NotSupport(bean));
    }
}
