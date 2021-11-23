package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.task.Helper;
import ru.bscmsk.todo.task.IOut;
import ru.bscmsk.todo.task.ITasks;

@Component
@RequiredArgsConstructor
public class Toggle extends Command implements ICommand {

    private final ITasks tasks;
    private final IOut out;

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
