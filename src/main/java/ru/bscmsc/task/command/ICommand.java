package ru.bscmsc.task.command;

import ru.bscmsc.task.Out;
import ru.bscmsc.task.Task;

import java.util.List;

public interface ICommand {
    Out out = new Out(System.out);
    Out err = new Out(System.err);

    void exec(List<Task> tasks, String param);

    Command getCommand();

}
