package ru.bscmsc.task.command;

import ru.bscmsc.task.IOut;

public class Quit extends Command implements ICommand {
    private final IOut out;

    public Quit(IOut out) {
        this.out = out;
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
