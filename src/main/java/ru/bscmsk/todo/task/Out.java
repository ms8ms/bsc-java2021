package ru.bscmsk.todo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.task.command.ICommand;

import java.util.List;

@Slf4j
@Component
public class Out implements IOut {

    public void print(String message) {
        log.info(message);
    }

    public void printCommands(List<ICommand> commands) {
        StringBuilder str = new StringBuilder("Available commands:");
        int number = 0;
        for (ICommand command : commands) {
            str.append(String.format("%n%d. %s - %s.", ++number, command.name(), command.description()));
        }
        print(str.toString());
    }

    public void selectCommand() {
        print("Select command -> ");
    }

    public void printError(String message) {
        log.error(message);
    }

    public void printError(String message, Throwable e) {
        log.error(message, e);
    }
}
