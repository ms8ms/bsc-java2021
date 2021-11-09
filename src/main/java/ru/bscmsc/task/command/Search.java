package ru.bscmsc.task.command;

import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Out;
import ru.bscmsc.task.Task;
import ru.bscmsc.task.Tasks;

import java.util.List;


public class Search implements ICommand {

    @Override
    public void exec(String substring) {
        if (Helper.isParamEmpty(substring)) {
            Out.getInstance().print("Format command: search <substring>");
            return;
        }
        if (!Tasks.getInstance().getTasks().isEmpty()) {
            printTasks(substring);
        }
    }

    @Override
    public Command getCommand() {
        return Command.SEARCH;
    }

    public void printTasks(String substring) {
        List<Task> toPrint = Tasks.getInstance().getTasks(substring);
        toPrint.forEach(t -> Out.getInstance().print(t.toString()));
    }
}
