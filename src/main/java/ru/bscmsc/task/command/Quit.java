package ru.bscmsc.task.command;

import ru.bscmsc.task.Bean;

public class Quit extends Command implements ICommand {

    public Quit(Bean bean) {
        super(bean);
    }

    @Override
    public void exec(String param) {
        out.print("Good bye!");
    }

    @Override
    public String name() {
        return "quit";
    }

    @Override
    public String description() {
        return "завершение работы";
    }
}
