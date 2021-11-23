package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bscmsk.todo.task.Helper;
import ru.bscmsk.todo.task.IOut;
import ru.bscmsk.todo.task.ITasks;

@Service
@RequiredArgsConstructor
public class Edit extends Command implements ICommand {
    private final ITasks tasks;
    private final IOut out;

    @Override
    public void exec(String param) {
        String index = param.substring(0, param.indexOf(" ") + 1).trim();
        String description = Helper.getParams(param);

        if (Helper.isParamEmpty(out, index, description)) {
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
