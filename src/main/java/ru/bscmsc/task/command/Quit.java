package ru.bscmsc.task.command;

import ru.bscmsc.task.Task;

import java.util.List;

public class Quit implements ICommand {

    @Override
    public ICommand exec(List<Task> tasks, String param) {
        return this;
    }

    @Override
    public Command getCommand() {
        return Command.QUIT;
    }
}
