package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;

public class Delete implements ICommand {

    @Override
    public void exec(List<Task> tasks, String param) {
        if (Helper.isParamEmpty(err, param)) {
            out.print("delete <идентификатор задачи>.\n");
            return;
        }
        if (!tasks.isEmpty()) {
            int taskId;
            try {
                taskId = Integer.parseInt(param);
            } catch (NumberFormatException e) {
                err.print("The task id must be number.\n");
                return;
            }
            tasks.removeIf(t -> (taskId) == t.getIndex());
        }
    }

    @Override
    public Command getCommand() {
        return Command.DELETE;
    }
}
