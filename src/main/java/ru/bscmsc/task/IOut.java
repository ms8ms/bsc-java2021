package ru.bscmsc.task;

import ru.bscmsc.task.command.ICommand;

import java.util.List;

public interface IOut {
    void print(String message);

    void printCommands(List<ICommand> commands);

    void selectCommand();

    void printNoSupported();

    void printError(String message);

    void printError(String message, Throwable e);
}
