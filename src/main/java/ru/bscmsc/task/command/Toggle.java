package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;
import ru.bscmsc.task.Helper;

public class Toggle extends Command implements ICommand {

    public Toggle(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String param) {
        if (Helper.isParamEmpty(param)) {
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
