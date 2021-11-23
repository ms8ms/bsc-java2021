package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.task.Helper;
import ru.bscmsk.todo.task.IOut;
import ru.bscmsk.todo.task.ITasks;
import ru.bscmsk.todo.task.Task;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Search extends Command implements ICommand {

    private final ITasks tasks;
    private final IOut out;

    @Override
    public void exec(String substring) {
        if (Helper.isParamEmpty(out, substring)) {
            out.print("Format command: search <substring>");
            return;
        }
        if (!tasks.getTasks().isEmpty()) {
            printTasks(substring);
        }
    }

    @Override
    public String name() {
        return "search";
    }

    @Override
    public String description() {
        return "поиска по подстроке";
    }

    private void printTasks(String substring) {
        List<Task> toPrint = tasks.getTasks(substring);
        toPrint.forEach(t -> out.print(t.toString()));
    }
}
