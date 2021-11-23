package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bscmsk.todo.task.Helper;
import ru.bscmsk.todo.task.IOut;
import ru.bscmsk.todo.task.ITasks;

@Service
@RequiredArgsConstructor
public class Delete extends Command implements ICommand {
    private final ITasks tasks;
    private final IOut out;

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
