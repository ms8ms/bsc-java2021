package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;

public class Edit implements ICommand {

    @Override
    public void exec(List<Task> tasks, String param) {
        String index = param.substring(0, param.indexOf(" ") + 1).trim();
        String description = Helper.getParams(param);

        if (Helper.isParamEmpty(err, index, description)) {
            out.print("edit <идентификатор задачи> <новое значение>\n");
            return;
        }
        if (!tasks.isEmpty()) {
            int taskId;
            try {
                taskId = Integer.parseInt(index);
            } catch (NumberFormatException e) {
                err.print("The task id must be number.\n");
                return;
            }
            tasks.stream().filter(t -> (taskId) == t.getIndex())
                    .forEach(t -> t.setDescription(description));
        }
    }

    @Override
    public Command getCommand() {
        return Command.EDIT;
    }
}
