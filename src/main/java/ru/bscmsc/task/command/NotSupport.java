package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;

public class NotSupport extends Command implements ICommand {
    public NotSupport(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String param) {
        out.printError("The Command is not supported");
    }

    @Override
    public String name() {
        return "noSupport";
    }

    @Override
    public String description() {
        return "noSupport";
    }
}
