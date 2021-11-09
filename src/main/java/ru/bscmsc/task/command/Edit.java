package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;
import ru.bscmsc.task.Helper;


public class Edit extends Command implements ICommand {

    public Edit(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String param) {
        String index = param.substring(0, param.indexOf(" ") + 1).trim();
        String description = Helper.getParams(param);

        if (Helper.isParamEmpty(index, description)) {
            out.print("edit <идентификатор задачи> <новое значение>");
            return;
        }
        if (!tasks.getTasks().isEmpty()) {
            int taskId;
            try {
                taskId = Integer.parseInt(index);
            } catch (NumberFormatException e) {
                out.printError("The task id must be number.", e);
                return;
            }
            tasks.updateTask(taskId, description);
        }
    }

    @Override
    public String name() {
        return "edit";
    }

    @Override
    public String description() {
        return "редактирования задачи";
    }
}
