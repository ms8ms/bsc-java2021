package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.IOut;
import ru.bscmsc.task.ITasks;


public class Delete extends Command implements ICommand {


    private final ITasks tasks;
    private final IOut out;

    public Delete(ITasks tasks, IOut out) {
        this.tasks = tasks;
        this.out = out;
    }

    @Override
    public void exec(String param) {
        if (Helper.isParamEmpty(out, param)) {
            out.print("delete <идентификатор задачи>.");
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
            tasks.remove(taskId);
        }
    }

    @Override
    public String name() {
        return "delete";
    }

    @Override
    public String description() {
        return "удаления задачи из списка";
    }
}
