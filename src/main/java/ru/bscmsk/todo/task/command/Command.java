package ru.bscmsk.todo.task.command;

public abstract class Command {

    public boolean isName(String toLowerCase) {
        return name().equalsIgnoreCase(toLowerCase);
    }

    public abstract String name();
}
