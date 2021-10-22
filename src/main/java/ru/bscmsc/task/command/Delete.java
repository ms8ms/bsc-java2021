package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;

public class Delete implements ICommand {

    @Override
    public ICommand exec(List<Task> tasks, String param) {
        if (Helper.isParamEmpty(err, param)) {
            out.print("delete <идентификатор задачи>.\n");
        } else {
            if (tasks != null) {
                try {
                    int taskId = Integer.parseInt(param);
                    tasks.removeIf(t -> (taskId) == t.getIndex());
                } catch (NumberFormatException e) {
                    err.print("The task id must be number.\n");
                }
            }
        }
        return this;
    }

    @Override
    public Command getCommand() {
        return Command.DELETE;
    }
}
