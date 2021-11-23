package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.IOut;
import ru.bscmsc.task.ITasks;


public class Add extends Command implements ICommand {

    private final ITasks tasks;
    private final IOut out;

    public Add(ITasks tasks, IOut out) {
        this.tasks = tasks;
        this.out = out;
    }

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
