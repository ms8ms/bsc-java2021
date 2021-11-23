package ru.bscmsk.todo.task;


import ru.bscmsk.todo.task.command.ICommand;

import java.util.List;

public interface IOut {
    void print(String message);

    void printCommands(List<ICommand> commands);

    void selectCommand();

    void printError(String message);

    void printError(String message, Throwable e);
}
