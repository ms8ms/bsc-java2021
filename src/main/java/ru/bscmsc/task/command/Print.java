package ru.bscmsc.task.command;

import ru.bscmsc.task.Task;

import java.util.List;
import java.util.stream.Collectors;

public class Print implements ICommand {

    @Override
    public void exec(List<Task> tasks, String param) {
        if (!param.isEmpty() && !"all".equalsIgnoreCase(param)) {
            err.print("The command does not correct parameters.\n");
            out.print("Format command: print [all]\n");
            return;
        }
        if (!tasks.isEmpty()) {
            printTasks(tasks, !param.isEmpty());
        }
    }

    @Override
    public Command getCommand() {
        return Command.PRINT;
    }

    public void printTasks(List<Task> tasks, boolean isPrintAll) {
        List<Task> toPrint = tasks;
        if (!isPrintAll) {
            toPrint = tasks.stream().filter((Task::getIsNotComplete)).collect(Collectors.toList());
        }
        toPrint.forEach(t -> out.print(t.toString()));
    }

}
