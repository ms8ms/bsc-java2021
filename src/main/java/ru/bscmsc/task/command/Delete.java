package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;
import ru.bscmsc.task.Helper;


public class Delete extends Command implements ICommand {

    public Delete(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String param) {
        if (Helper.isParamEmpty(param)) {
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
