package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;
import ru.bscmsc.task.Helper;
import ru.bscmsc.task.Task;

import java.util.List;


public class Search extends Command implements ICommand {

    public Search(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String substring) {
        if (Helper.isParamEmpty(substring)) {
            out.print("Format command: search <substring>");
            return;
        }
        if (!tasks.getTasks().isEmpty()) {
            printTasks(substring);
        }
    }

    @Override
    public String name() {
        return "search";
    }

    @Override
    public String description() {
        return "поиска по подстроке";
    }

    public void printTasks(String substring) {
        List<Task> toPrint = tasks.getTasks(substring);
        toPrint.forEach(t -> out.print(t.toString()));
    }
}
