package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;

public class Search implements ICommand {

    @Override
    public ICommand exec(List<Task> tasks, String substring) {
        if (Helper.isParamEmpty(err, substring)) {
            out.print("Format command: search <substring>\n");
        } else {
            if (tasks != null) {
                printTasks(tasks, substring);
            }
        }
        return this;
    }

    @Override
    public Command getCommand() {
        return Command.SEARCH;
    }

    public void printTasks(List<Task> tasks, String substring) {
        tasks.stream().filter(task -> task.getDescription().contains(substring)).
                forEach(t -> out.print(t.toString()));

    }
}
