package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Out;
import ru.bscmsc.task.Tasks;


public class Add implements ICommand {


    @Override
    public void exec(String description) {
        if (Helper.isParamEmpty(description)) {
            Out.getInstance().printError("Format command: add <description>");
            return;
        }
        Tasks.getInstance().add(description);
    }

    @Override
    public Command getCommand() {
        return Command.ADD;
    }
}
