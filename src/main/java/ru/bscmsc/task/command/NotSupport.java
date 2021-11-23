package ru.bscmsc.task.command;

import ru.bscmsc.task.IOut;

public class NotSupport extends Command implements ICommand {

    private final IOut out;

    public NotSupport(IOut out) {
        this.out = out;
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
