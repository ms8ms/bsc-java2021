package ru.bscmsk.todo.task.command;

public interface ICommand {
    void exec(String param);

    boolean isName(String toLowerCase);

    String name();

    String description();
}
