package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.IOut;
import ru.bscmsc.task.ITasks;

public class Toggle extends Command implements ICommand {

    private final ITasks tasks;
    private final IOut out;

    public Toggle(ITasks tasks, IOut out) {
        this.tasks = tasks;
        this.out = out;
    }

    @Override
    public void exec(String param) {
        if (Helper.isParamEmpty(out, param)) {
            out.print("Format command: toggle <task id>.");
            return;
        }
        if (!tasks.getTasks().isEmpty()) {
            int taskId;
            try {
                taskId = Integer.parseInt(param);
            } catch (NumberFormatException e) {
                out.printError("The task id must be number.", e);
                return;
            }
            tasks.toggle(taskId);
        }
    }

    @Override
    public String name() {
        return "toggle";
    }

    @Override
    public String description() {
        return "изменение статуса задачи";
    }

}
