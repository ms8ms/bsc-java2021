package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Out;
import ru.bscmsc.task.Tasks;

public class Toggle implements ICommand {

    @Override
    public void exec(String param) {
        if (Helper.isParamEmpty(param)) {
            Out.getInstance().print("Format command: toggle <task id>.");
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
            Tasks.getInstance().toggle(taskId);
        }
    }

    @Override
    public Command getCommand() {
        return Command.TOGGLE;
    }

}
