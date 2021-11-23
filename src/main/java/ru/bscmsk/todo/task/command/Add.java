package ru.bscmsk.todo.task.command;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bscmsk.todo.task.Helper;
import ru.bscmsk.todo.task.IOut;
import ru.bscmsk.todo.task.ITasks;

@Service
@RequiredArgsConstructor
public class Add extends Command implements ICommand {
    private final ITasks tasks;
    private final IOut out;

    @Override
    public void exec(String description) {
        if (Helper.isParamEmpty(out, description)) {
            out.printError("Format command: add <description>");
            return;
        }
        tasks.add(description);
    }

    @Override
    public String name() {
        return "add";
    }

    @Override
    public String description() {
        return "добавление задачи";
    }
}
