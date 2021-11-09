package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Out;
import ru.bscmsc.task.Tasks;


public class Delete implements ICommand {

    @Override
    public void exec(String param) {
        if (Helper.isParamEmpty(param)) {
            Out.getInstance().print("delete <идентификатор задачи>.");
            return;
        }
        if (!Tasks.getInstance().getTasks().isEmpty()) {
            int taskId;
            try {
                taskId = Integer.parseInt(param);
            } catch (NumberFormatException e) {
                Out.getInstance().printError("The task id must be number.", e);
                return;
            }
            Tasks.getInstance().remove(taskId);
        }
    }

    @Override
    public Command getCommand() {
        return Command.DELETE;
    }
}
