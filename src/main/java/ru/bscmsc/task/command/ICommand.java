package ru.bscmsc.task.command;

public interface ICommand {

    void exec(String param);

    Command getCommand();

}
