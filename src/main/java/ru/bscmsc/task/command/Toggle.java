package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;

public class Toggle implements ICommand {

    @Override
    public ICommand exec(List<Task> tasks, String param) {
        if (Helper.isParamEmpty(err, param)) {
            out.print("Format command: toggle <task id>.\n");
        } else {
            if (tasks != null) {
                try {
                    int taskId = Integer.parseInt(param);
                    tasks.stream().filter(t -> taskId == t.getIndex()).findFirst().ifPresent(Task::toggle);
                } catch (NumberFormatException e) {
                    err.print("The task id must be number.\n");
                }
            }
        }
        return this;
    }

    @Override
    public Command getCommand() {
        return Command.TOGGLE;
    }

}
