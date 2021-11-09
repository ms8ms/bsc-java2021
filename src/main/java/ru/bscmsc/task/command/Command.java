package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;
import ru.bscmsc.task.IOut;
import ru.bscmsc.task.ITasks;

public abstract class Command implements ICommand {
    protected final ITasks tasks;
    protected final IOut out;

    public Command(Bean bean) {
        tasks = bean.getTasks();
        out = bean.getOut();
    }

    public boolean isName(String toLowerCase) {
        return name().equalsIgnoreCase(toLowerCase);
    }
}
