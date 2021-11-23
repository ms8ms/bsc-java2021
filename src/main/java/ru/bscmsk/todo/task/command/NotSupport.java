package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import ru.bscmsk.todo.task.IOut;

@RequiredArgsConstructor
public class NotSupport extends Command implements ICommand {
    private final IOut out;

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
