package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Out;
import ru.bscmsc.task.Tasks;


public class Edit implements ICommand {

    @Override
    public void exec(String param) {
        String index = param.substring(0, param.indexOf(" ") + 1).trim();
        String description = Helper.getParams(param);

        if (Helper.isParamEmpty(index, description)) {
            Out.getInstance().print("edit <идентификатор задачи> <новое значение>");
            return;
        }
        if (!Tasks.getInstance().getTasks().isEmpty()) {
            int taskId;
            try {
                taskId = Integer.parseInt(index);
            } catch (NumberFormatException e) {
                Out.getInstance().printError("The task id must be number.", e);
                return;
            }
            Tasks.getInstance().updateTask(taskId, description);
        }
    }

    @Override
    public Command getCommand() {
        return Command.EDIT;
    }
}
