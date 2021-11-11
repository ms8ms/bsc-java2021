package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.IOut;
import ru.bscmsc.task.ITasks;
import ru.bscmsc.task.Task;

import java.util.List;


public class Search extends Command implements ICommand {

    private final ITasks tasks;
    private final IOut out;

    public Search(ITasks tasks, IOut out) {
        this.tasks = tasks;
        this.out = out;
    }

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
