package ru.bscmsc.task.command;

import ru.bscmsc.task.Task;

import java.util.List;

public class Quit implements ICommand {

    @Override
    public void exec(List<Task> tasks, String param) {
    }

    @Override
    public Command getCommand() {
        return Command.QUIT;
    }
}
