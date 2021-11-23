package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.task.IOut;
import ru.bscmsk.todo.task.ITasks;
import ru.bscmsk.todo.task.Task;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Print extends Command implements ICommand {
    private final ITasks tasks;
    private final IOut out;

    @Override
    public void exec(String param) {
        if (!param.isEmpty() && !"all".equalsIgnoreCase(param)) {
            out.printError("The command does not correct parameters.\n");
            out.print("Format command: print [all]\n");
            return;
        }
        if (!tasks.getTasks().isEmpty()) {
            printTasks(!param.isEmpty());
        }
    }

    @Override
    public String name() {
        return "print";
    }

    @Override
    public String description() {
        return "печать списка задач";
    }

    private void printTasks(boolean isPrintAll) {
        List<Task> toPrint = tasks.getTasks(isPrintAll);
        toPrint.forEach(t -> out.print(t.toString()));
    }

}
