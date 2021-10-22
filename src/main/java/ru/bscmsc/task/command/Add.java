package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;

public class Add implements ICommand {

    @Override
    public ICommand exec(List<Task> tasks, String description) {
        if (Helper.isParamEmpty(err, description)) {
            out.print("Format command: add <description>\n");
        } else {
            tasks.add(new Task(description, tasks.size() + 1));
        }
        return this;
    }

    @Override
    public Command getCommand() {
        return Command.ADD;
    }
}
