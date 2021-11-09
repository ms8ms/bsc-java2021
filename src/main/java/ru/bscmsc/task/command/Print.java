package ru.bscmsc.task.command;

import ru.bscmsc.task.Out;
import ru.bscmsc.task.Task;
import ru.bscmsc.task.Tasks;

import java.util.List;


public class Print implements ICommand {

    @Override
    public void exec(String param) {
        if (!param.isEmpty() && !"all".equalsIgnoreCase(param)) {
            Out.getInstance().printError("The command does not correct parameters.\n");
            Out.getInstance().print("Format command: print [all]\n");
            return;
        }
        if (!Tasks.getInstance().getTasks().isEmpty()) {
            printTasks(!param.isEmpty());
        }
    }

    @Override
    public Command getCommand() {
        return Command.PRINT;
    }

    public void printTasks(boolean isPrintAll) {
        List<Task> toPrint = Tasks.getInstance().getTasks(isPrintAll);
        toPrint.forEach(t -> Out.getInstance().print(t.toString()));
    }

}
