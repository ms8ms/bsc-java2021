package ru.bscmsc.task.command;

import ru.bscmsc.task.IOut;
import ru.bscmsc.task.ITasks;
import ru.bscmsc.task.Task;

import java.util.List;


public class Print extends Command implements ICommand {

    private final ITasks tasks;
    private final IOut out;

    public Print(ITasks tasks, IOut out) {
        this.tasks = tasks;
        this.out = out;
    }

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
