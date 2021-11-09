package ru.bscmsc.task.command;

public class Quit implements ICommand {

    @Override
    public void exec(String param) {
    }

    @Override
    public Command getCommand() {
        return Command.QUIT;
    }
}
