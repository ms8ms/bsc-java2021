package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;
import ru.bscmsc.task.Helper;


public class Add extends Command implements ICommand {

    public Add(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String description) {
        if (Helper.isParamEmpty(description)) {
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
