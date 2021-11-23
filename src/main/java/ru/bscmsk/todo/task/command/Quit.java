package ru.bscmsk.todo.task.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.task.IOut;

@Component
@RequiredArgsConstructor
public class Quit extends Command implements ICommand {
    private final IOut out;

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
